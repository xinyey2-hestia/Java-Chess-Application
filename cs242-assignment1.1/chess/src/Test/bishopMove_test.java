package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class bishopMove_test {

	@Test
	public void test() {
		piece[][] newboard= new piece[8][8];
		rule rule=new rule();
		test t=new test();

		t.add(newboard, 1, "bishop", 2, 7);
		//black bishop invalid
		rule.moveto(newboard[2][7],newboard,4,7);
		assertEquals(newboard[2][7].name,"bishop");
		assertEquals(newboard[4][7],null);
		//black bishop valid
		rule.moveto(newboard[2][7],newboard,4,5);
		assertEquals(newboard[4][5].name,"bishop");
		//black bishop invalid (block)
		t.add(newboard, 1, "pawn", 4, 4);
		rule.moveto(newboard[4][5],newboard,4,2);
		assertEquals(newboard[4][2],null);
	}

}
