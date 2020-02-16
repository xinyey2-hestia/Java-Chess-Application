package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class KnightMoveTest {

	@Test
	public void test() {
		piece[][] newboard= new piece[8][8];
		rule rule=new rule();
		test t=new test();

		t.add(newboard, 1, "knight", 1, 7);
		//black knight moves in 2 ways
		rule.moveto(newboard[1][7],newboard,2,5);
		assertEquals(newboard[2][5].name,"knight");
		rule.moveto(newboard[2][5],newboard,4,6);
		assertEquals(newboard[4][6].name,"knight");
		//invalid
		rule.moveto(newboard[4][6],newboard,4,7);
		assertEquals(newboard[4][7],null);
	}
}
