package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.HangManDAO;
import learnforfun.mvc.DAOImp.HangManDAOImpl;
import learnforfun.mvc.Models.HangMan;

import java.util.ArrayList;

/**
 * Created by Omar on 22-Apr-17.
 */
public class HangManService {
    private HangManDAO hangManDAO = new HangManDAOImpl();

    public void addGame(HangMan TF) {
        hangManDAO.insert(TF);
    }

    public String getAnswer(int ID) {
        return hangManDAO.getAnswer(ID);
    }

    public void deleteGame(int ID) {
        hangManDAO.delete(ID);
    }

    public int getGameID(String name) {
        return hangManDAO.getID(name);
    }

    public void deleteCourseGames(int CID) {
        hangManDAO.deleteCourseGames(CID);
    }

    public ArrayList<HangMan> getCourseGames(int CID) {
        return hangManDAO.getCourseGames(CID);
    }

    public double getGameRate(int ID) {
        return hangManDAO.GetGameRate(ID);
    }

    public void updateGameRate(int ID, int rate) {
        hangManDAO.UpdateGameRate(ID, rate);
    }

    public int getVotes(int ID) {
        return hangManDAO.GetVotes(ID);
    }

    public void updateGameVotes(int ID, int v) {
        hangManDAO.UpdateGameVotes(ID, v);
    }

    public ArrayList<HangMan> getTop10() {
        return hangManDAO.GetTop10();
    }

    public HangMan getGame(int ID) {
        return hangManDAO.getGame(ID);
    }
}
