package learnforfun.mvc.DAO;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import learnforfun.mvc.Models.HangMan;
import learnforfun.mvc.Models.True_False;

@Repository
public interface HangManDAO
{
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
