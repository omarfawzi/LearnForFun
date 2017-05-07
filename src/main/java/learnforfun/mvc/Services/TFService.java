package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.True_FalseDAO;
import learnforfun.mvc.DAOImp.True_FalseDAOImpl;
import learnforfun.mvc.Models.True_False;

import java.util.ArrayList;

/**
 * Created by Omar on 21-Apr-17.
 */
public class TFService {
    private True_FalseDAO true_falseDAO = new True_FalseDAOImpl();
    public void addGame(True_False TF){
        true_falseDAO.insert(TF);
    }

    public boolean getAnswer(int ID){
        return true_falseDAO.getAnswer(ID);
    }

    public void deleteGame(int ID){
        true_falseDAO.delete(ID);
    }

    public int getGameID(String name){
        return true_falseDAO.getID(name);
    }

    public void deleteCourseGames(int CID){
        true_falseDAO.deleteCourseGames(CID);
    }
    public ArrayList<True_False> getCourseGames(int CID){
        return true_falseDAO.getCourseGames(CID);
    }
    public double getGameRate(int ID){
        return true_falseDAO.GetGameRate(ID);
    }

    public void UpdateGameRate(int ID, int rate){
        true_falseDAO.UpdateGameRate(ID,rate);
    }
    public int getVotes(int ID){
        return true_falseDAO.GetVotes(ID);
    }
}
