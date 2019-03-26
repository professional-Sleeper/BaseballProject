package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

	public static void main(String[] args) {
		
		List <String> inputLog = new ArrayList<String>();
		
		Game game = new Game();
		
		while (true) {
			System.out.println("숫자를 입력해주세요 : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputNum = null;

			try {
				inputNum = exceptionCheck(game, br);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}

			// 통과

			GameResult gameResult = game.checkResult(inputNum);
			
			inputLog.add(inputNum+"\t\t"+gameResult.toString());
			System.out.println("\nInput"+"\t\t"+"strikes\t"+"balls\t"+"solved");
			for (String s : inputLog) {
				System.out.println(s.toString());
			}
			System.out.println();
			if( gameResult.isSolved()) {
				
				System.out.println("정답!!!!!!!!!!!");
				
				break;
			}
			
			
			
		}

	}

	private static String exceptionCheck(Game game, BufferedReader br) 
			throws IOException, IsOverlappedException {
		String inputNum;
		inputNum = br.readLine();
		game.isValidInputLength(inputNum);
		game.isValidNumber(inputNum);
		game.isOverlappedInputNum(inputNum);
		return inputNum;
	}

}
