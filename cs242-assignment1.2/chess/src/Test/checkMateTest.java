package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Piece;
import chess.Rule;
import chess.test;

public class checkMateTest {

	@Test
	public void endgametest() {
		Piece[][] newboard= new Piece[8][8];
		Rule rule=new Rule();
		test t=new test();
		t.add(newboard, 0, "pawn", 3, 3);
		t.add(newboard, 1, "pawn", 3, 4);
		t.add(newboard, 1, "king", 4, 4);
		int res = rule.moveto(newboard[3][3], newboard, 4, 4);
		assertEquals(res,2);
		

	}
	


}
