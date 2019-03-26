package baseball;

public class GameResult {

	private boolean solved;
	private int strikes;
	private int balls;
	
	public GameResult() {

	}
	
	public GameResult(boolean solved, int strikes, int balls) {
		super();
		this.solved = solved;
		this.strikes = strikes;
		this.balls = balls;
	}
	
	public boolean isSolved() {
		return solved;
	}
	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	public int getStrikes() {
		return strikes;
	}
	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}

	@Override
	public String toString() {
		return strikes+"\t"+balls+"\t"+solved;
	}
	
}
