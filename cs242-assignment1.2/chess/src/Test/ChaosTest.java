package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Piece;
import chess.Rule;
import chess.test;

public class ChaosTest {

	@Test
	public void test() {
		Piece[][] newboard= new Piece[8][8];
		Rule rule=new Rule();
		test t=new test();

		t.add(newboard, 1, "Chaos", 4, 7);
		rule.moveto(newboard[4][7],newboard,9,7);
		rule.moveto(newboard[4][7],newboard,2,3);
		rule.moveto(newboard[4][7],newboard,4,7);
		
		t.add(newboard, 0, "rook", 1, 3);
		t.add(newboard, 0, "rook", 2, 3);
		t.add(newboard, 0, "rook", 3, 3);
		t.add(newboard, 0, "rook", 4, 3);
		t.add(newboard, 1, "king", 2, 1);
		rule.moveto(newboard[1][3], newboard, 2, 3);
		rule.moveto(newboard[4][3], newboard, 4, 1);
	}

}
