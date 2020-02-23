package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class QueenMoveTest {

	@Test
	public void test() {
		Piece[][] newboard= new Piece[8][8];
		Rule rule=new Rule();
		test t=new test();

		t.add(newboard, 1, "queen", 4, 7);
		rule.moveto(newboard[4][7],newboard,9,7);
		t.add(newboard, 1, "queen", 3, 6);
		t.add(newboard, 1, "queen", 4, 6);
		rule.moveto(newboard[4][7],newboard,4,5);
		rule.moveto(newboard[4][7],newboard,2,5);
		//black queen
		rule.moveto(newboard[4][7],newboard,1,7);
		assertEquals(newboard[1][7].name,"queen");
		assertEquals(newboard[4][7],null);
		//black queen invalid
		rule.moveto(newboard[1][7],newboard,0,5);
		assertEquals(newboard[1][7].name,"queen");
		//invalid (block)
		t.add(newboard, 1, "queen", 4, 7);
		rule.moveto(newboard[1][7],newboard,6,7);
		assertEquals(newboard[1][7].name,"queen");
	}

}
