package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Comment;

import java.util.ArrayList;

/**
 * Created by Omar on 13-May-17.
 */
public interface CommentsDAO {
    public void insert(Comment comment);

    public ArrayList<Comment> getComments(int courseID, int gameID);
}
