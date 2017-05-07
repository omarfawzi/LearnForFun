package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.StudentDAO;
import learnforfun.mvc.DAO.TeacherDAO;
import learnforfun.mvc.DAOImp.StudentDAOImpl;
import learnforfun.mvc.DAOImp.TeacherDAOImpl;
import learnforfun.mvc.Models.Account;
import learnforfun.mvc.Models.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by Omar on 16-Apr-17.
 */
@Repository
public class TeacherValidation implements Validation {
    private TeacherDAO teacher = new TeacherDAOImpl();
    private StudentDAO student = new StudentDAOImpl();

    @Override
    public int SignIn(String mail, String pass) {
        if (teacher.signInExists(mail, pass) == -1){
            if (!teacher.mailExists(mail))
                return -1 ;
            else return -2 ;
        }
        else return teacher.signInExists(mail, pass);
    }

    //public Account(String firstName, String lastName, String userName, String mail, String password, String gender,
    //             String phone, Date bDate, int age, int id) ;
    @Override
    public int SignUp(Account account) {
        Teacher obj = new Teacher(account);
        try {
            if (teacher.signUpExists(account.getMail(),account.getUserName()) != -1 || student.signUpExists(account.getMail(),account.getUserName()) != -1)
                return -1;
            teacher.insert(obj);
            return teacher.getID(account.getMail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
