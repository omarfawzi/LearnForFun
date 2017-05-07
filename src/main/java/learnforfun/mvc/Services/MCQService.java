package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.MultipleChoiceDAO;
import learnforfun.mvc.DAOImp.MultipleChoiceDAOImpl;
import learnforfun.mvc.Models.MultipleChoice;

import java.util.ArrayList;

/**
 * Created by Omar on 21-Apr-17.
 */
public class MCQService {
    private MultipleChoiceDAO multipleChoiceDAO = new MultipleChoiceDAOImpl();
    public void addGame(MultipleChoice TF){
        multipleChoiceDAO.insert(TF);
    }

    public int getAnswer(int ID){
        return multipleChoiceDAO.getAnswer(ID);
    }

    public void deleteGame(int ID){
        multipleChoiceDAO.delete(ID);
    }

    public int getGameID(String name){
        return multipleChoiceDAO.getID(name);
    }

    public void deleteCourseGames(int CID){
        multipleChoiceDAO.deleteCourseGames(CID);
    }

    public ArrayList<MultipleChoice> getCourseGames(int CID){
       return multipleChoiceDAO.getCourseGames(CID);
    }

    public double getGameRate(int ID){
        return multipleChoiceDAO.GetGameRate(ID);
    }
    public void updateGameRate(int ID, int rate){
        multipleChoiceDAO.UpdateGameRate(ID,rate);
    }

    public int getVotes(int ID){
        return multipleChoiceDAO.GetVotes(ID);
    }

    public void updateGameVotes(int ID, int v){
        multipleChoiceDAO.UpdateGameVotes(ID,v);
    }
    public ArrayList<MultipleChoice> getTop10(){
        return multipleChoiceDAO.GetTop10();
    }
}
