package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.AccountDAO;
import learnforfun.mvc.Models.Account;

import java.sql.*;

/**
 * Created by Omar on 12-Apr-17.
 */

public class AccountDAOImpl implements AccountDAO {

    private PreparedStatement pstmt;
    private Connection con;

    public AccountDAOImpl() {
        String dbdriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/learnforfun";
        String username = "root";
        String password = "root";
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Account acc) {
        try {
            pstmt = con.prepareStatement("INSERT INTO ACCOUNT (FIRST_NAME,LAST_NAME,USER_NAME,MAIL,PASSWORD,GENDER,PHONE,BIRTH_DATE,AGE) VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, acc.getFirstName());
            pstmt.setString(2, acc.getLastName());
            pstmt.setString(3, acc.getUserName());
            pstmt.setString(4, acc.getMail());
            pstmt.setString(5, acc.getPassword());
            pstmt.setString(6, acc.getGender());
            pstmt.setString(7, acc.getPhone());
            pstmt.setObject(8, acc.getBDate());
            pstmt.setInt(9, acc.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean update(int id, Account acc) {
        try {
            pstmt = con.prepareStatement("UPDATE ACCOUNT set FIRST_NAME = ? , LAST_NAME = ? , PASSWORD = ? , GENDER = ? , PHONE = ? , BIRTH_DATE = ? , AGE = ?  where UID = ?");
            pstmt.setString(1, acc.getFirstName());
            pstmt.setString(2, acc.getLastName());
            pstmt.setString(3, acc.getPassword());
            pstmt.setString(4, acc.getGender());
            pstmt.setString(5, acc.getPhone());
            pstmt.setObject(6, acc.getBDate());
            pstmt.setInt(7, acc.getAge());
            pstmt.setInt(8, id);
            int rs = pstmt.executeUpdate();
            return (rs != 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean exists(String mail, String password) {
        try {
            pstmt = con.prepareStatement("SELECT * FROM ACCOUNT where MAIL = ? and PASSWORD = ? ");
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Account get(int id) {
        try {
            pstmt = con.prepareStatement("SELECT * FROM ACCOUNT where UID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getInt(9));
                return account;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public Account findByCustomerId(int custId) {
//        return null;
//    }
}
