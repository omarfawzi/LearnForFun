package learnforfun.mvc.Models;

public class HangMan extends Game
{
	private String Answer;
	private String Hint;
	
	public String getAnswer() {
		return Answer;
	}
	
	public void setAnswer(String answer) {
		Answer = answer;
	}
	
	public String getHint() {
		return Hint;
	}
	
	public void setHint(String hint) {
		Hint = hint;
	}
}
