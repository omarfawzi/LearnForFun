package learnforfun.mvc.Models;

import javax.persistence.Entity;

@Entity
public class True_False extends Game {

    private boolean Answer;

    public boolean getAnswer() {
        return Answer;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }
}
