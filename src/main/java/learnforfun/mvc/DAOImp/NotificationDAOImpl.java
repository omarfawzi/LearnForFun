package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.NotificationDAO;
import learnforfun.mvc.Models.Notifications;

import java.sql.*;
import java.util.ArrayList;

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
    public void insert(Notifications notification) {
        try {
            pstmt = con.prepareStatement("INSERT INTO NOTIFICATIONS (NOTIFIED_USER,NOTIFIZER,NOTIFICATION_TYPE,COURSE_ID) VALUES (?,?,?,?)");
            pstmt.setString(1, notification.getNotified());
            pstmt.setString(2, notification.getNotifizer());
            pstmt.setString(3, notification.getType());
            pstmt.setInt(4, notification.getCourseID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Notifications> getNotifications(String notifiedUser) {
        ArrayList<Notifications> notifications = new ArrayList<Notifications>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM NOTIFICATIONS WHERE NOTIFIED_USER = ?");
            pstmt.setString(1, notifiedUser);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                notifications.add(new Notifications(rs.getString("NOTIFICATION_TYPE"), rs.getString("NOTIFIZER"), notifiedUser, rs.getInt("COURSE_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }
}
