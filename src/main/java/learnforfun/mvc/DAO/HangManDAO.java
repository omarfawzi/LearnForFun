package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.HangMan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HangManDAO {
    public void insert(HangMan HM);

    public String getAnswer(int ID);

    public String getHint(int ID);

    public void delete(int ID);

    public int getID(String name);

    public HangMan getGame(int ID);

    public void deleteCourseGames(int CID);

    public ArrayList<HangMan> getCourseGames(int CID);

    public double GetGameRate(int ID);

    public void UpdateGameRate(int ID, int rate);

    public int GetVotes(int ID);

    public void UpdateGameVotes(int ID, int v);

    public ArrayList<HangMan> GetTop10();
}
