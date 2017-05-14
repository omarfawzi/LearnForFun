package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.MultipleChoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MultipleChoiceDAO {
    public void insert(MultipleChoice TF);

    public int getAnswer(int ID);

    public void delete(int ID);

    public int getID(String name);

    public void deleteCourseGames(int CID);

    public ArrayList<MultipleChoice> getCourseGames(int CID);

    public double GetGameRate(int ID);

    public void UpdateGameRate(int ID, int rate);

    public int GetVotes(int ID);

    public void UpdateGameVotes(int ID, int v);

    public ArrayList<MultipleChoice> GetTop10();
}
