package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CheckTest {

	@Test
	public void test() {
		piece[][] newboard= new piece[8][8];
		rule rule=new rule();
		test t=new test();

		t.add(newboard, 0, "pawn", 3, 4);
		t.add(newboard, 0, "king", 3, 6);
		//invalid check (same color)
		rule.moveto(newboard[3][4],newboard,3,5);
		//valid check (in diagonal)
		t.remove(newboard,3,6);
		t.add(newboard, 1, "king", 3, 6);
		t.add(newboard, 0, "pawn", 2, 4);
		rule.moveto(newboard[2][4],newboard,2,5);
		assertEquals(newboard[2][5].name,"pawn");
				
	}
	
	public void test_2() {
		piece[][] board= new piece[8][8];
		rule rule=new rule();
		test t=new test();
		t.add(board, 0, "pawn", 3, 3);
		t.add(board, 0, "pawn", 4, 4);
		t.add(board, 0, "pawn", 2, 4);
		t.add(board, 0, "king", 3, 4);
		
		t.add(board, 1, "queen", 5, 7);
		t.printall(board);
		rule.moveto(board[5][7], board, 3, 7);
		rule.moveto(board[3][7], board, 3, 6);
		assertEquals(board[3][6].name,"queen");
	}

}
