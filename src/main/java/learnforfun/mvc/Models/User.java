package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class User {

    protected Account account;
    protected int ID;

    public User() {
    }

    public User(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

}
