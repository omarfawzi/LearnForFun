package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class Achievement {
    private int Score;
    private int GameID;
    private String GameName;

    public Achievement() {
        super();
    }

    public Achievement(int score, int gameID) {
        Score = score;
        GameID = gameID;
    }

    public Achievement(Achievement other) {

        this.Score = other.Score;
        this.GameID = other.GameID;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getGameID() {
        return GameID;
    }

    public void setGameID(int gameID) {

        GameID = gameID;
    }
}
