package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.NotificationDAO;
import learnforfun.mvc.Models.Pair;

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
    public void insert(String notifiedUser, String notifizer , String notificationType, int courseID) {
        try {
            pstmt = con.prepareStatement("INSERT INTO NOTIFICATIONS (NOTIFIED_USER,NOTIFIZER,NOTIFICATION_TYPE,COURSE_ID) VALUES (?,?,?,?)");
            pstmt.setString(1,notifiedUser);
            pstmt.setString(2,notifizer);
            pstmt.setString(3,notificationType);
            pstmt.setInt(4,courseID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Pair <String,Pair<String,Integer> > > getNotification(String notifiedUser) {
        ArrayList<Pair<String,Pair<String,Integer>>> notifications = new ArrayList<Pair<String, Pair<String, Integer>>>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM NOTIFICATIONS WHERE NOTIFIED_USER = ?");
            pstmt.setString(1,notifiedUser);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()){
                notifications.add(new Pair<String, Pair<String, Integer>>(rs.getString("NOTIFIZER"),new Pair<String, Integer>(rs.getString("NOTIFICATION_TYPE"),rs.getInt("COURSE_ID"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }
}
