package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NormalCaptureTest {

	@Test
	public	void test() {
		piece[][] newboard= new piece[8][8];
		rule rule=new rule();
		test t=new test();

		t.add(newboard, 0, "pawn", 3, 3);
		t.add(newboard, 1, "pawn", 3, 4);


		//white pawn captures white pawn (invalid)
		t.add(newboard, 0, "pawn", 3, 5);
		rule.moveto(newboard[3][4],newboard,3,5);
		assertEquals(newboard[3][4].name,"pawn");
		//white pawn captures black pawn (in diagonal)
		t.add(newboard, 1, "pawn", 2, 5);
		rule.moveto(newboard[3][4],newboard,2,5);
		assertEquals(newboard[2][5].color,0);
	}

}
