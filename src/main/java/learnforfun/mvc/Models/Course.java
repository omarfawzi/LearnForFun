package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class Course {

    private String Name;
    private int ID;
    private int UserID;
    private String Description;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int uID) {
        UserID = uID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
