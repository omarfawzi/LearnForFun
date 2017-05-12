package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.NotificationDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Omar on 12-May-17.
 */
public class NotificationDAOImpl implements NotificationDAO {
    private PreparedStatement pstmt;
    private Connection con;

    public NotificationDAOImpl() {
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
    public void insert(String notifiedUser, String notifizer) {
        try {
            pstmt = con.prepareStatement("INSERT INTO NOTIFICATIONS (NOTIFIED_USER,NOTIFIZER) VALUES (?,?)");
            pstmt.setString(1,notifiedUser);
            pstmt.setString(2,notifizer);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
