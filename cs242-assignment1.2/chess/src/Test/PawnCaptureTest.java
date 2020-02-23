package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PawnCaptureTest {

	@Test
	public void test() {
		Piece[][] newboard= new Piece[8][8];
		Rule rule=new Rule();
		test t=new test();
		t.add(newboard, 0, "pawn", 3, 3);
		t.add(newboard, 1, "pawn", 3, 4);
		t.add(newboard, 1, "king", 4, 4);
		t.printall(newboard);
		rule.moveto(newboard[3][3], newboard, 4, 4);
		t.printall(newboard);
		assertEquals(newboard[4][4].name,"king");

	}

}
