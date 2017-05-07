package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.UserDAO;

import java.sql.*;

/**
 * Created by Omar on 06-May-17.
 */
public class UserDAOImpl implements UserDAO {
    private PreparedStatement pstmt;
    private Connection con;

    public UserDAOImpl() {
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
    public void insert(String username) {
        try {
            pstmt = con.prepareStatement("INSERT INTO signed_in_users (USERNAME) VALUES (?)");
            pstmt.setString(1,username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {
        try {
            pstmt = con.prepareStatement("DELETE FROM  SIGNED_IN_USERS WHERE USERNAME = ?");
            pstmt.setString(1,username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean exists(String username) {
        try {
            pstmt = con.prepareStatement("SELECT * FROM SIGNED_IN_USERS where USERNAME = ?");
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
