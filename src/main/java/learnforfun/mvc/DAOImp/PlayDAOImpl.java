package learnforfun.mvc.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import learnforfun.mvc.DAO.PlayDAO;
import learnforfun.mvc.Models.Achievement;

public class PlayDAOImpl implements PlayDAO
{
    private PreparedStatement pstmt;
    private Connection con;

	public PlayDAOImpl()
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
	public void insert(int UID, int GID, int score, String type)
	{
		try
		{
			pstmt = con.prepareStatement("INSERT INTO PLAY (GID, UID, SCORE, TYPE) VALUES (?, ?, ?, ?)");
			
			pstmt.setInt(1, GID);
			pstmt.setInt(2, UID);
			pstmt.setInt(3, score);
			pstmt.setString(4, type);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	@Override
	public void delete(int GID)
	{
		try
		{
			pstmt = con.prepareStatement("DELETE FROM PLAY WHERE GID = ?");

			pstmt.setInt(1, GID);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public ArrayList<Achievement> GetUserGames(int UID)
	{
		ArrayList<Achievement> achievements  = new ArrayList<Achievement>();
		Achievement achievement;
		
		try
		{
			//From true & false
			pstmt = con.prepareStatement("SELECT PLAY.GID, PLAY.SCORE, TRUE_AND_FALSE.NAME "
					+ "FROM PLAY, TRUE_AND_FALSE WHERE PLAY.GID = TRUE_AND_FALSE.GID AND PLAY.TYPE = ? AND PLAY.UID = ?");
			
			pstmt.setString(1, "TF");
			pstmt.setInt(2, UID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				achievement = new Achievement();
				
				achievement.setGameID(rs.getInt(1));
				achievement.setScore(rs.getInt(2));
				achievement.setGameName(rs.getString(3));
				
				achievements.add(achievement);				
			}
			
			// From multiple choice
			pstmt = con.prepareStatement("SELECT PLAY.GID, PLAY.SCORE, multiple_choice.NAME "
					+ "FROM PLAY, multiple_choice WHERE PLAY.GID = multiple_choice.GID AND PLAY.TYPE = ? AND PLAY.UID = ?");
			
			pstmt.setString(1, "MC");
			pstmt.setInt(2, UID);
			
			 rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				achievement = new Achievement();
				
				achievement.setGameID(rs.getInt(1));
				achievement.setScore(rs.getInt(2));
				achievement.setGameName(rs.getString(3));
				
				achievements.add(achievement);				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return achievements;
	}
}
