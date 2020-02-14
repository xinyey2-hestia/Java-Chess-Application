package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import chess.*;
public class rooktest {
	board board;
	@Test
	public void testkk() {
		board = new board();
		piece[][]newboard = board.newboard; 
		rook rookie = new rook(1,3,3,newboard);
		assertFalse("Move fail", rookie.move(0,8));
	}

}
