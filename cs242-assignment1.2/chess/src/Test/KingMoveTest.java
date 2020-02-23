package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

import chess.Piece;
import chess.Rule;
import chess.test;

public class KingMoveTest {

	@Test
	public void test() {
		Piece[][] newboard= new Piece[8][8];
		Rule rule=new Rule();
		test t=new test();

		t.add(newboard, 1, "king", 3, 7);
		//black king valid
		rule.moveto(newboard[3][7],newboard,3,6);
		assertEquals(newboard[3][6].name,"king");
		assertEquals(newboard[3][7],null);
		//invalid
		rule.moveto(newboard[3][6],newboard,2,4);
		assertEquals(newboard[2][4],null);
	}

}
