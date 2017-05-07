package learnforfun.mvc.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import learnforfun.mvc.DAO.HangManDAO;
import learnforfun.mvc.DAO.PlayDAO;
import learnforfun.mvc.Models.Game;
import learnforfun.mvc.Models.HangMan;

public class HangManDAOImpl implements HangManDAO
{
    private PreparedStatement pstmt;
    private Connection con;

	public HangManDAOImpl() 
	{
        String dbdriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/learnforfun";
        String username = "root";
        String password = "root";
        
        try 
        {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void insert(HangMan HM)
	{
		try
		{
			pstmt = con.prepareStatement("INSERT INTO HANG_MAN (NAME, QUESTION, ANSWER, HINT, CID, RATE, VOTES) VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, HM.getGameName());
			pstmt.setString(2, HM.getQuestion());
			pstmt.setString(3, HM.getAnswer());
			pstmt.setString(4, HM.getHint());
			pstmt.setInt(5, HM.getCourseID());
			pstmt.setDouble(6, 0);
			pstmt.setInt(7, 0);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public String getAnswer(int ID) 
	{
		try
		{
			pstmt = con.prepareStatement("SELECT ANSWER FROM HANG_MAN WHERE GID = ?");
			
			pstmt.setInt(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getString(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "-1";
	}
	
	@Override
	public String getHint(int ID)
	{
		try
		{
			pstmt = con.prepareStatement("SELECT HINT FROM HANG_MAN WHERE GID = ?");
			
			pstmt.setInt(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getString(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "-1";
	}
	
	@Override
	public void delete(int ID)
	{
		PlayDAO pl = new PlayDAOImpl();
		
		pl.delete(ID);

		try
		{
			pstmt = con.prepareStatement("DELETE FROM HANG_MAN WHERE GID = ?");
			
			pstmt.setInt(1, ID);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	@Override
	public int getID(String name)
	{
		try
		{
			pstmt = con.prepareStatement("SELECT GID FROM HANG_MAN WHERE NAME = ?");
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	@Override
	public HangMan getGame(int ID)
	{
		HangMan game = new HangMan();
		
		try
		{
			pstmt = con.prepareStatement("SELECT * FROM HANG_MAN WHERE GID = ?");
			
			pstmt.setInt(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{				
				game.setAnswer(rs.getString("ANSWER"));
				game.setCourseID(rs.getInt("CID"));
				game.setGameID(rs.getInt("GID"));
				game.setGameName(rs.getString("NAME"));
				game.setQuestion(rs.getString("QUESTION"));
				game.setRate(rs.getDouble("RATE"));
				game.setVotes(rs.getInt("VOTES"));
				game.setHint(rs.getString("HINT"));				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return game;
	}
	
	@Override
	public double GetGameRate(int ID) 
	{
		try
		{
			pstmt = con.prepareStatement("SELECT RATE FROM HANG_MAN WHERE GID = ?");
			
			pstmt.setInt(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getDouble(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
	
	@Override
	public int GetVotes(int ID)
	{
		try
		{
			pstmt = con.prepareStatement("SELECT VOTES FROM HANG_MAN WHERE GID = ?");
			
			pstmt.setInt(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return 0;
	}
	
	@Override
	public void UpdateGameRate(int ID, int rate)
	{
		int v = GetVotes(ID);
		double r = GetGameRate(ID);
		
		r = (r*(v+1) + rate) / (v+1);
		
		UpdateGameVotes(ID, v+1);		
		
		try
		{
			pstmt = con.prepareStatement("UPDATE HANG_MAN SET RATE = ? WHERE GID = ?");
			
			pstmt.setDouble(1, r);
			pstmt.setInt(2, ID);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void UpdateGameVotes(int ID, int v)
	{
		try
		{
			pstmt = con.prepareStatement("UPDATE HANG_MAN SET VOTES = ? WHERE GID = ?");
			
			pstmt.setInt(1, v);
			pstmt.setInt(2, ID);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	@Override
	public void deleteCourseGames(int CID)
	{
		ArrayList<HangMan> games = getCourseGames(CID);
		
		for(Game i : games)
		{
			int id = i.getGameID();
			delete(id);
		}		
	}
	
	@Override
	public ArrayList<HangMan> getCourseGames(int CID)
	{
		ArrayList<HangMan> games = new ArrayList<HangMan>();
		HangMan game;
		
		try
		{
			pstmt = con.prepareStatement("SELECT * FROM HANG_MAN WHERE CID = ?");
			
			pstmt.setInt(1, CID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				game = new HangMan();
				
				game.setAnswer(rs.getString("ANSWER"));
				game.setCourseID(rs.getInt("CID"));
				game.setGameID(rs.getInt("GID"));
				game.setGameName(rs.getString("NAME"));
				game.setQuestion(rs.getString("QUESTION"));
				game.setRate(rs.getDouble("RATE"));
				game.setVotes(rs.getInt("VOTES"));
				game.setHint(rs.getString("HINT"));
				
				games.add(game);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return games;
	}
	
	@Override
	public ArrayList<HangMan> GetTop10()
	{
		ArrayList<HangMan> games = new ArrayList<HangMan>();
		HangMan game;

		try
		{
			pstmt = con.prepareStatement("SELECT * FROM HANG_MAN ORDER BY RATE DESC");
			
			ResultSet rs = pstmt.executeQuery();
			
			for (int i=0 ; i<10 && rs.next() ; i++)
			{
				game = new HangMan();
				
				game.setAnswer(rs.getString("ANSWER"));
				game.setCourseID(rs.getInt("CID"));
				game.setGameID(rs.getInt("GID"));
				game.setGameName(rs.getString("NAME"));
				game.setQuestion(rs.getString("QUESTION"));
				game.setRate(rs.getDouble("RATE"));
				game.setVotes(rs.getInt("VOTES"));
				game.setHint(rs.getString("HINT"));
				
				games.add(game);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return games;
	}
	
}
