package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class bishopMove_test {

	@Test
	public void test() {
		Piece[][] newboard= new Piece[8][8];
		Rule rule=new Rule();
		test t=new test();
		
		t.add(newboard, 1, "bishop", 1, 7);
		rule.moveto(newboard[4][7],newboard,9,7);
		t.add(newboard, 1, "bishop", 1, 6);
		
		rule.moveto(newboard[4][7],newboard,1,5);

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
