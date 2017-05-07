package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class Teacher extends User {

    private int DID;

    public Teacher() {
    }

    public Teacher(Account account) {
        super(account);
    }

    public int getDID() {
        return DID;
    }

    public void setDID(int dID) {
        DID = dID;
    }
}
