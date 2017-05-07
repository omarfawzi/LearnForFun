package learnforfun.mvc.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import learnforfun.mvc.DAO.MultipleChoiceDAO;
import learnforfun.mvc.DAO.PlayDAO;
import learnforfun.mvc.Models.Game;
import learnforfun.mvc.Models.MultipleChoice;

public class MultipleChoiceDAOImpl implements MultipleChoiceDAO
{
    private PreparedStatement pstmt;
    private Connection con;

	public MultipleChoiceDAOImpl() 
	{
        String dbdriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/learnforfun";
        String username = "root";
        String password = "root";
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void insert(MultipleChoice MC) 
	{
		try
		{
			pstmt = con.prepareStatement("INSERT INTO MULTIPLE_CHOICE"
					+ " (NAME, QUESTION, CHOICE_1, CHOICE_2, CHOICE_3, CHOICE_4, ANSWER, CID, RATE, VOTES) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setString(1, MC.getGameName());
			pstmt.setString(2, MC.getQuestion());
			pstmt.setString(3, MC.getChoice1());
			pstmt.setString(4, MC.getChoice2());
			pstmt.setString(5, MC.getChoice3());
			pstmt.setString(6, MC.getChoice4());
			pstmt.setInt(7, MC.getAnswer());
			pstmt.setInt(8, MC.getCourseID());
			pstmt.setDouble(9, 0);
			pstmt.setInt(10, 0);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public int getAnswer(int ID)
	{
		try
		{
			pstmt = con.prepareStatement("SELECT ANSWER FROM MULTIPLE_CHOICE WHERE GID = ?");
			
			pstmt.setInt(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	@Override
	public void delete(int ID) 
	{
		try
		{
			pstmt = con.prepareStatement("DELETE FROM MULTIPLE_CHOICE WHERE GID = ?");
			
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
			pstmt = con.prepareStatement("SELECT GID FROM MULTIPLE_CHOICE WHERE NAME = ?");
			
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
	public double GetGameRate(int ID)
	{
		try
		{
			pstmt = con.prepareStatement("SELECT RATE FROM MULTIPLE_CHOICE WHERE GID = ?");
			
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
			pstmt = con.prepareStatement("SELECT VOTES FROM MULTIPLE_CHOICE WHERE GID = ?");
			
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
			pstmt = con.prepareStatement("UPDATE MULTIPLE_CHOICE SET RATE = ? WHERE GID = ?");
			
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
			pstmt = con.prepareStatement("UPDATE MULTIPLE_CHOICE SET VOTES = ? WHERE GID = ?");
			
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
		ArrayList<MultipleChoice> games = getCourseGames(CID);
		PlayDAO pl = new PlayDAOImpl();
		
		for(Game i : games)
		{
			int id = i.getGameID();
			
			pl.delete(id);
			delete(id);
		}
	}
	
	@Override
	public ArrayList<MultipleChoice> getCourseGames(int CID)
	{
		ArrayList<MultipleChoice> games = new ArrayList<MultipleChoice>();
		MultipleChoice game;
		
		try
		{
			pstmt = con.prepareStatement("SELECT * FROM MULTIPLE_CHOICE WHERE CID = ?");
			
			pstmt.setInt(1, CID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				game = new MultipleChoice();
				
				game.setChoice1(rs.getString("CHOICE_1"));
				game.setChoice2(rs.getString("CHOICE_2"));
				game.setChoice3(rs.getString("CHOICE_3"));
				game.setChoice4(rs.getString("CHOICE_4"));
				game.setCourseID(rs.getInt("CID"));
				game.setGameID(rs.getInt("GID"));
				game.setGameName(rs.getString("NAME"));
				game.setQuestion(rs.getString("QUESTION"));
				game.setRate(rs.getDouble("RATE"));
				game.setVotes(rs.getInt("VOTES"));
				game.setAnswer(rs.getInt("ANSWER"));
				
				games.add(game);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return games;
	}
	
	@Override
	public ArrayList<MultipleChoice> GetTop10()
	{
		ArrayList<MultipleChoice> games = new ArrayList<MultipleChoice>();
		MultipleChoice game;
		
		try
		{
			pstmt = con.prepareStatement("SELECT * FROM MULTIPLE_CHOICE ORDER BY RATE DESC");
						
			ResultSet rs = pstmt.executeQuery();
			
			for (int i=0 ; i<10 && rs.next() ; i++)
			{
				game = new MultipleChoice();
				
				game.setChoice1(rs.getString("CHOICE_1"));
				game.setChoice2(rs.getString("CHOICE_2"));
				game.setChoice3(rs.getString("CHOICE_3"));
				game.setChoice4(rs.getString("CHOICE_4"));
				game.setCourseID(rs.getInt("CID"));
				game.setGameID(rs.getInt("GID"));
				game.setGameName(rs.getString("NAME"));
				game.setQuestion(rs.getString("QUESTION"));
				game.setRate(rs.getDouble("RATE"));
				game.setVotes(rs.getInt("VOTES"));
				game.setAnswer(rs.getInt("ANSWER"));
				
				games.add(game);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return games;
	}	
}
