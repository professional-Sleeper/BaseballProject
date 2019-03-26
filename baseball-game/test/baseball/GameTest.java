package baseball;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


import org.junit.Test;

public class GameTest {

	@Test
	public void make_object_test() {
		
		Game game = new Game();
		
		assertNotNull(game);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_no_input() {
		
		Game game = new Game();
		
		game.isValidInputLength("");
		
	}
	
	@Test
	public void when_no_input2() {
		
		Game game = new Game();
		
		try {
			game.isValidInputLength("");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("there is no input"));
		}
		
	}
	
	@Test
	public void check_not_overlapped_answer() {
		
		Game game = new Game();
		
		boolean isOverlapped = false;
		
		String answer = game.getAnswerNum();
		
		int first = Integer.parseInt(answer.substring(0, 1));
		
		int second = Integer.parseInt(answer.substring(1, 2));
		
		int third = Integer.parseInt(answer.substring(2, 3));
		
		if(first == second || second == third || third == first) {
			isOverlapped = true;
		}
		
		assertThat(false, is(isOverlapped));
		
	}
	
	@Test
	public void when_length_of_inputNum_is_not_3() {
		
		Game game = new Game();
		
		try {
			game.isValidInputLength("1234");
			fail();
		} catch(Exception e) {
			assertThat(e.getMessage(), is("length is not 3"));
		}
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void when_inputNum_is_not_valid_int() {
		
		Game game = new Game();
		
		game.isValidNumber("abcd");
		
	}
	
	@Test
	public void when_inputNum_is_overlapped() {
		
		Game game = new Game();
		
		try {
			game.isValidInputLength("332");
		} catch(Exception e) {
			assertThat(e.getMessage(), is("InputNum is Overlapped"));
		}
		
	}
	
}
