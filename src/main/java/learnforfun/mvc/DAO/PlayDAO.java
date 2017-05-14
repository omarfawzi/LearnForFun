package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Achievement;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlayDAO {
    public void insert(int UID, int GID, int score, String type);

    public void delete(int GID);

    public ArrayList<Achievement> GetUserGames(int UID);
}
