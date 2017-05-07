package learnforfun.mvc.Services;

import learnforfun.mvc.Models.Account;

import java.sql.SQLException;

/**
 * Created by Omar on 16-Apr-17.
 */
public interface Validation {
    public int SignIn(String mail, String pass);

    public int SignUp(Account account) throws SQLException;
}
