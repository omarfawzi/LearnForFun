package learnforfun.mvc.Models;

/**
 * Created by Omar on 13-May-17.
 */
public class Comment {
    private int userID, courseID, gameID;
    private String Comment;

    public Comment(Comment other) {
        this.userID = other.userID;
        this.courseID = other.courseID;
        this.gameID = other.gameID;
        this.Comment = other.Comment;
    }

    public Comment(int userID, int courseID, int gameID, String Comment) {
        this.userID = userID;
        this.courseID = courseID;
        this.gameID = gameID;
        this.Comment = Comment;
    }

    public Comment() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
