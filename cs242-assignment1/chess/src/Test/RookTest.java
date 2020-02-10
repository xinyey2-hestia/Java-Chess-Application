package Test;

import chess.*;
import junit.framework.Test;
import junit.framework.Assert;


public class RookTest {

	board board;
	@Test
	public void validXMovetest() {
		// out of bound edge case test:
		board = new board();
		piece[][]newboard = board.newboard; 
		rook rookie = new rook(1,3,3,newboard);
		Assert.assertFalse("Move fail", rookie.move(0,8));
		
		
	}
	
	
}
