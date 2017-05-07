package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.StudentDAO;
import learnforfun.mvc.DAO.TeacherDAO;
import learnforfun.mvc.DAOImp.StudentDAOImpl;
import learnforfun.mvc.DAOImp.TeacherDAOImpl;
import learnforfun.mvc.Models.Account;
import learnforfun.mvc.Models.Student;
import learnforfun.mvc.Models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by Omar on 16-Apr-17.
 */
@Repository
public class StudentValidation implements Validation {
    private StudentDAO student = new StudentDAOImpl();
    private TeacherDAO teacher = new TeacherDAOImpl();

    @Override
    public int SignIn(String mail, String pass) {
       if (student.signInExists(mail, pass) == -1){
         if (!student.mailExists(mail))
            return -1 ;
         else return -2 ;
        }
        else return student.signInExists(mail, pass);
    }

    @Override
    public int SignUp(Account account) {
        Student obj = new Student(account);
        try {
            if (teacher.signUpExists(account.getMail(),account.getUserName()) != -1 || student.signUpExists(account.getMail(),account.getUserName()) != -1)
                return -1;
            student.insert(obj);
            return student.getID(account.getMail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
