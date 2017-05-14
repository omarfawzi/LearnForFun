package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.True_False;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface True_FalseDAO {
    public void insert(True_False TF);

    public boolean getAnswer(int ID);

    public void delete(int ID);

    public int getID(String name);

    public void deleteCourseGames(int CID);

    public ArrayList<True_False> getCourseGames(int CID);

    public double GetGameRate(int ID);

    public void UpdateGameRate(int ID, int rate);

    public int GetVotes(int ID);

    public void UpdateGameVotes(int ID, int v);

    public ArrayList<True_False> GetTop10();
}
