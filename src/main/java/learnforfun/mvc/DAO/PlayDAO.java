package learnforfun.mvc.DAO;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import learnforfun.mvc.Models.Achievement;

@Repository
public interface PlayDAO 
{
	public void insert(int UID, int GID, int score, String type);
	
	public void delete(int GID);
	
	public ArrayList<Achievement> GetUserGames(int UID);
}
