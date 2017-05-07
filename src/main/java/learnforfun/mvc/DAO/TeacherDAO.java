package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Account;
import learnforfun.mvc.Models.Teacher;

import java.sql.SQLException;

public interface TeacherDAO {
    public void insert(Teacher te) throws SQLException;
    public int signInExists(String mail, String password);
    public int signUpExists(String mail, String username) throws SQLException;
    public Boolean mailExists(String mail) ;
    public int getID(String mail);
    public Account getAccount(int id);
    public Boolean updateAccount(Account account);
}
