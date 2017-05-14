package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.PlayDAO;
import learnforfun.mvc.DAO.True_FalseDAO;
import learnforfun.mvc.Models.Game;
import learnforfun.mvc.Models.True_False;

import java.sql.*;
import java.util.ArrayList;

public class True_FalseDAOImpl implements True_FalseDAO {
    private PreparedStatement pstmt;
    private Connection con;

    public True_FalseDAOImpl() {
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
    public void insert(True_False TF) {
        try {
            pstmt = con.prepareStatement("INSERT INTO TRUE_AND_FALSE (NAME, QUESTION, ANSWER, CID, RATE, VOTES) VALUES (?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, TF.getGameName());
            pstmt.setString(2, TF.getQuestion());
            pstmt.setBoolean(3, TF.getAnswer());
            pstmt.setInt(4, TF.getCourseID());
            pstmt.setDouble(5, 0);
            pstmt.setInt(6, 0);
            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public boolean getAnswer(int ID) {
        try {
            pstmt = con.prepareStatement("SELECT ANSWER FROM TRUE_AND_FALSE WHERE GID = ?");

            pstmt.setInt(1, ID);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                return rs.getBoolean(1);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    @Override
    public void delete(int ID) {
        try {
            pstmt = con.prepareStatement("DELETE FROM TRUE_AND_FALSE WHERE GID = ?");

            pstmt.setInt(1, ID);

            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public int getID(String name) {
        try {
            pstmt = con.prepareStatement("SELECT GID FROM TRUE_AND_FALSE WHERE NAME = ?");

            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                return rs.getInt(1);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return -1;
    }

    @Override
    public double GetGameRate(int ID) {
        try {
            pstmt = con.prepareStatement("SELECT RATE FROM TRUE_AND_FALSE WHERE GID = ?");

            pstmt.setInt(1, ID);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                return rs.getDouble(1);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return 0;
    }

    @Override
    public int GetVotes(int ID) {
        try {
            pstmt = con.prepareStatement("SELECT VOTES FROM TRUE_AND_FALSE WHERE GID = ?");

            pstmt.setInt(1, ID);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                return rs.getInt(1);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return 0;
    }

    @Override
    public void UpdateGameRate(int ID, int rate) {
        int v = GetVotes(ID);
        double r = GetGameRate(ID);

        r = (r * (v + 1) + rate) / (v + 1);

        UpdateGameVotes(ID, v + 1);

        try {
            pstmt = con.prepareStatement("UPDATE TRUE_AND_FALSE SET RATE = ? WHERE GID = ?");

            pstmt.setDouble(1, r);
            pstmt.setInt(2, ID);

            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void UpdateGameVotes(int ID, int v) {
        try {
            pstmt = con.prepareStatement("UPDATE TRUE_AND_FALSE SET VOTES = ? WHERE GID = ?");

            pstmt.setInt(1, v);
            pstmt.setInt(2, ID);

            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void deleteCourseGames(int CID) {
        ArrayList<True_False> games = getCourseGames(CID);
        PlayDAO pl = new PlayDAOImpl();

        for (Game i : games) {
            int id = i.getGameID();

            pl.delete(id);
            delete(id);
        }
    }

    @Override
    public ArrayList<True_False> getCourseGames(int CID) {
        ArrayList<True_False> games = new ArrayList<True_False>();
        True_False game;

        try {
            pstmt = con.prepareStatement("SELECT * FROM TRUE_AND_FALSE WHERE CID = ?");

            pstmt.setInt(1, CID);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                game = new True_False();

                game.setAnswer(rs.getBoolean("ANSWER"));
                game.setCourseID(rs.getInt("CID"));
                game.setGameID(rs.getInt("GID"));
                game.setGameName(rs.getString("NAME"));
                game.setQuestion(rs.getString("QUESTION"));
                game.setRate(rs.getDouble("RATE"));
                game.setVotes(rs.getInt("VOTES"));

                games.add(game);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return games;
    }

    @Override
    public ArrayList<True_False> GetTop10() {
        ArrayList<True_False> games = new ArrayList<True_False>();
        True_False game;

        try {
            pstmt = con.prepareStatement("SELECT * FROM TRUE_AND_FALSE ORDER BY RATE DESC");

            ResultSet rs = pstmt.executeQuery();

            for (int i = 0; i < 10 && rs.next(); i++) {
                game = new True_False();

                game.setAnswer(rs.getBoolean("ANSWER"));
                game.setCourseID(rs.getInt("CID"));
                game.setGameID(rs.getInt("GID"));
                game.setGameName(rs.getString("NAME"));
                game.setQuestion(rs.getString("QUESTION"));
                game.setRate(rs.getDouble("RATE"));
                game.setVotes(rs.getInt("VOTES"));

                games.add(game);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return games;
    }
}
