package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Piece;
import chess.Rule;
import chess.test;

public class TraitorTest {

	@Test
	public void test() {
		Piece[][] newboard= new Piece[8][8];
		Rule rule=new Rule();
		test t=new test();

		t.add(newboard, 1, "traitor", 4, 7);
		rule.moveto(newboard[4][7],newboard,9,7);
		rule.moveto(newboard[4][7],newboard,2,3);
		rule.moveto(newboard[4][7],newboard,4,7);
		assertEquals(newboard[2][3],null);
		
		t.add(newboard, 1, "queen", 3, 6);
		t.add(newboard, 1, "queen", 4, 6);
		rule.moveto(newboard[4][7],newboard,4,5);
		rule.moveto(newboard[4][7],newboard,2,5);
	}

}
