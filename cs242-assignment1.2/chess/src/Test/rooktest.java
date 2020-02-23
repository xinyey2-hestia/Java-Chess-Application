package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import chess.*;
public class rooktest {
	Board board;
	@Test
	public void testkk() {
		board = new Board();
		Piece[][]newboard = board.newboard; 
		Rook rookie = new Rook(1,3,3,newboard);
		assertFalse("Move fail", rookie.move(0,8));
	}

}
