package baseball;

public class Game {

	private String answerNum ="";
	
	public Game() {
		makeAnswer();
	}

	private void makeAnswer() {
		int first = (int) (Math.random() * 10);
		int second, third;
		while(true) {
			second = (int) (Math.random() * 10);
			if(second != first) break;
		}
		while(true) {
			third = (int) (Math.random() * 10);
			if(second != third && third != first) break;
		}
		answerNum = String.valueOf(first) + String.valueOf(second) + String.valueOf(third);
	}
	
	public void isValidInputLength(String inputNum) {
		
		if(inputNum.length() == 0) {
			throw new IllegalArgumentException("there is no input");
		}
		else if(inputNum.length() != 3) {
			throw new IllegalArgumentException("length is not 3");
		}
				
	}
	
	public void isValidNumber(String inputNum) throws NumberFormatException{
		
		Integer.parseInt(inputNum);
		
	}
	
	public void isOverlappedInputNum(String inputNum) throws IsOverlappedException {

		char inputNumArray [] = new char [3];
		
		for (int i=0; i<3; i++) {
			inputNumArray[i] = inputNum.charAt(i);
			
		}
		
		if(inputNumArray[0] == inputNumArray[1] || inputNumArray[1] == inputNumArray[2]
				|| inputNumArray[2] == inputNumArray[0]) {
			throw new IsOverlappedException("InputNum is Overlapped");
		}
		
	}

	public GameResult checkResult(String inputNum) {
		
		GameResult gameResult = new GameResult();
		
		int strikes = 0;
		int balls = 0;
		boolean solved = false;
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if(inputNum.charAt(i) == answerNum.charAt(j)) {
					if(i == j) strikes++;
					else balls++;
				}
			}
		}
		
		 
		gameResult.setStrikes(strikes);
		gameResult.setBalls(balls);
		if ( strikes ==3 ) {
			solved = true;
		}
		gameResult.setSolved(solved);
		
		return gameResult;
	}
	
	public String getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(String answerNum) {
		this.answerNum = answerNum;
	}
	
}
