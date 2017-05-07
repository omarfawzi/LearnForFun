package learnforfun.mvc.Models;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Account {

    private String FirstName;
    private String LastName;
    private String UserName;
    private String Mail;
    private String Password;
    private String Gender;
    private String Phone;
    private Date BDate;
    private int Age;
    private int UserID;

    public Account() {
        super();
        Age=0;
    }

    public Account(Account other) {
        this.FirstName = other.FirstName;
        this.LastName = other.LastName;
        this.UserName = other.UserName;
        this.Mail = other.Mail;
        this.Password = other.Password;
        this.Gender = other.Gender;
        this.Phone = other.Phone;
        this.BDate = other.BDate;
        this.Age = other.Age;
        this.UserID = other.UserID;
    }

    public Account(String firstName, String lastName, String userName, String mail, String password, String gender,
                   String phone, Date bDate, int age) {
        super();
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        Mail = mail;
        Password = password;
        Gender = gender;
        Phone = phone;
        BDate = bDate;
        Age = age;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Date getBDate() {
        return BDate;
    }

    public void setBDate(Date bDate) {
        BDate = bDate;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

}
