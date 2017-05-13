package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Notifications;

import java.util.ArrayList;

/**
 * Created by Omar on 12-May-17.
 */
public interface NotificationDAO {
    public void insert(Notifications notification);
    public ArrayList <Notifications> getNotifications (String notifiedUser);
}
