package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.NotificationDAO;
import learnforfun.mvc.DAOImp.NotificationDAOImpl;
import learnforfun.mvc.Models.Notifications;

import javax.management.Notification;
import java.util.ArrayList;

/**
 * Created by Omar on 13-May-17.
 */
public class NotificationService {
    private NotificationDAO notificationDAO = new NotificationDAOImpl();
    public void insert(Notifications notification) {
        notificationDAO.insert(notification);
    }
    public ArrayList<Notifications> getNotifications(String notifiedUser) {
        return notificationDAO.getNotifications(notifiedUser);
    }
}
