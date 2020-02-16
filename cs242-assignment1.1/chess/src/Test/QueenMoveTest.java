package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class QueenMoveTest {

	@Test
	public void test() {
		piece[][] newboard= new piece[8][8];
		rule rule=new rule();
		test t=new test();

		t.add(newboard, 1, "queen", 4, 7);
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
