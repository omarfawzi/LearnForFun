package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class Game {

    private String GameName;
    private String Question;
    private int GameID;
    private int CourseID;
    private int Votes;
    private double Rate;

    public int getVotes() {
		return Votes;
	}

	public void setVotes(int votes) {
		Votes = votes;
	}

	public double getRate() {
		return Rate;
	}

	public void setRate(double rate) {
		Rate = rate;
	}

	public Game(Game other) {
        this.GameName = other.GameName;
        this.Question = other.Question;
        this.GameID = other.GameID;
    }

    public Game() {
        super();
    }

    public Game(String gameName, String question, int gameID) {
        GameName = gameName;
        Question = question;
        GameID = gameID;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public int getGameID() {
        return GameID;
    }

    public void setGameID(int gameID) {
        GameID = gameID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }
}
