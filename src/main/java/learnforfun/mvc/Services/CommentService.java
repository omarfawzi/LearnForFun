package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.CommentsDAO;
import learnforfun.mvc.DAOImp.CommentsDAOImpl;
import learnforfun.mvc.Models.Comment;

import java.util.ArrayList;

/**
 * Created by Omar on 13-May-17.
 */
public class CommentService {
    private CommentsDAO commentsDAO = new CommentsDAOImpl();
    public void insert(Comment comment){
        commentsDAO.insert(comment);
    }
    public ArrayList<Comment> getComments(int courseID, int gameID){
        return commentsDAO.getComments(courseID,gameID);
    }
}
