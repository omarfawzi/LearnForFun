package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Account;
import learnforfun.mvc.Models.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO {
    public void insert(Student st);

    public int signInExists(String mail, String password);

    public int signUpExists(String mail, String username);

    public Boolean mailExists(String mail) ;

    public int getID(String mail);

    public Account getAccount(int id);

    public Boolean updateAccount(Account account);

}
