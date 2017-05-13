package learnforfun.mvc.DAOImp;

import learnforfun.mvc.DAO.CommentsDAO;
import learnforfun.mvc.Models.Comment;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Omar on 13-May-17.
 */
public class CommentsDAOImpl implements CommentsDAO {
    private PreparedStatement pstmt;
    private Connection con;

    public CommentsDAOImpl() {
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
    public void insert(Comment comment) {
        try {
            pstmt = con.prepareStatement("INSERT INTO COMMENTS (USER_ID,COURSE_ID,GAME_ID,COMMENT) VALUES (?,?,?,?)");
            pstmt.setInt(1,comment.getUserID());
            pstmt.setInt(2,comment.getCourseID());
            pstmt.setInt(3,comment.getGameID());
            pstmt.setString(4,comment.getComment());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Comment> getComments(int courseID, int gameID) {
        ArrayList <Comment> ret = new ArrayList<Comment>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM COMMENTS WHERE COURSE_ID = ? AND GAME_ID = ?");
            pstmt.setInt(1,courseID);
            pstmt.setInt(2,gameID);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()){
                ret.add(new Comment(rs.getInt("USER_ID"),courseID,gameID,rs.getString("COMMENT")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
