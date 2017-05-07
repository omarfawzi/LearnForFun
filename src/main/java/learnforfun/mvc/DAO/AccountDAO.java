package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by Omar on 12-Apr-17.
 */
@Repository
public interface AccountDAO {
    public void insert(Account acc);

    public Boolean update(int id, Account acc);

    public boolean exists(String mail, String password);

    public Account get(int id);

    // public int getID(String mail);
    // public Account findByCustomerId(int custId);
}
