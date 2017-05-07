package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class Student extends User {

    private int EID;

    public Student() {
    }

    public Student(Account account) {
        super(account);
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int eID) {
        EID = eID;
    }
}
