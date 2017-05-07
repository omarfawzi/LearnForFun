package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.StudentDAO;
import learnforfun.mvc.DAOImp.StudentDAOImpl;
import learnforfun.mvc.Models.Account;

/**
 * Created by Omar on 20-Apr-17.
 */
public class StudentProfile implements UserProfile {
    private StudentDAO student = new StudentDAOImpl();
    @Override
    public Account getAccount(int id) {
        return student.getAccount(id);
    }

    @Override
    public Boolean updateAccount(Account account) {
       return student.updateAccount(account);
    }

}
