package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Pair;

import java.util.ArrayList;

/**
 * Created by Omar on 12-May-17.
 */
public interface NotificationDAO {
    public void insert(String notifiedUser, String notifizer , int courseID);
    public ArrayList <Pair<String,Integer>> getNotification (String notifiedUser);
}
