package learnforfun.mvc.Services;

import learnforfun.mvc.Models.Account;

/**
 * Created by Omar on 20-Apr-17.
 */
public interface UserProfile {
    public Account getAccount(int id);

    public Boolean updateAccount(Account account);
}
