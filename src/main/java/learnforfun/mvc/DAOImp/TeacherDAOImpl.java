package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.AccountDAO;
import learnforfun.mvc.DAO.TeacherDAO;
import learnforfun.mvc.Models.Account;
import learnforfun.mvc.Models.Teacher;

import java.sql.*;

public class TeacherDAOImpl implements TeacherDAO {
    private PreparedStatement pstmt;
    private Connection con;
    private AccountDAO accountDAO = new AccountDAOImpl();

    public TeacherDAOImpl() {
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
    public void insert(Teacher te) {
        try {
            accountDAO.insert(te.getAccount());
            pstmt = con.prepareStatement("INSERT INTO TEACHER (UID) SELECT UID FROM ACCOUNT WHERE MAIL = ?");
            pstmt.setString(1, te.getAccount().getMail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int signInExists(String mail, String password) {
        try {
            pstmt = con.prepareStatement("SELECT TEACHER.UID FROM TEACHER, ACCOUNT WHERE TEACHER.UID = ACCOUNT.UID AND (ACCOUNT.MAIL = ? AND ACCOUNT.PASSWORD = ? )");
            pstmt.setString(1, mail);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return rs.getInt(1);
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int signUpExists(String mail, String username) {
        try {
            pstmt = con.prepareStatement("SELECT TEACHER.UID FROM TEACHER, ACCOUNT WHERE TEACHER.UID = ACCOUNT.UID AND (ACCOUNT.MAIL = ? OR ACCOUNT.USER_NAME = ? )");
            pstmt.setString(1, mail);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return rs.getInt(1);
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Boolean mailExists(String mail) {
        try {
            pstmt = con.prepareStatement("SELECT TEACHER.UID FROM TEACHER, ACCOUNT WHERE TEACHER.UID = ACCOUNT.UID AND ACCOUNT.MAIL = ?");
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getID(String mail) {
        try {
            if (!mailExists(mail))
                return -1;
            pstmt = con.prepareStatement("SELECT * FROM ACCOUNT where MAIL = ?");
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return rs.getInt("UID");
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Account getAccount(int id) {
        try {
            pstmt = con.prepareStatement("SELECT TEACHER.UID FROM TEACHER, ACCOUNT WHERE TEACHER.UID = ACCOUNT.UID AND TEACHER.UID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return accountDAO.get(id);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean updateAccount(Account account) {
        int id = getID(account.getMail());
        if (id == -1)
            return false;
        return accountDAO.update(account.getUserID(), account);
    }
}
