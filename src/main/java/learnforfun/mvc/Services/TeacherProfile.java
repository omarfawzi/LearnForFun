package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.TeacherDAO;
import learnforfun.mvc.DAOImp.TeacherDAOImpl;
import learnforfun.mvc.Models.Account;

/**
 * Created by Omar on 20-Apr-17.
 */
public class TeacherProfile implements UserProfile {
    private TeacherDAO teacher = new TeacherDAOImpl();
    @Override
    public Account getAccount(int id) {
        return teacher.getAccount(id);
    }

    @Override
    public Boolean updateAccount(Account account) {
        return teacher.updateAccount(account);
    }
}
