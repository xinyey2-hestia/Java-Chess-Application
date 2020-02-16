package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PawnMove_test {

	@Test
	public void test() {
		board board= new board();
		rule rule=new rule();
		piece[][] newboard=board.newboard;
		//white pawn move 2
		rule.moveto(newboard[0][1],newboard,0,3);
		assertEquals(newboard[0][3].name,"pawn");
		assertEquals(newboard[0][1],null);
		//same pawn move 2 again
		rule.moveto(newboard[0][3],newboard,0,5);
		assertEquals(newboard[0][3].name,"pawn");
		//same pawn move 1 backward
		rule.moveto(newboard[0][3],newboard,0,2);
		assertEquals(newboard[0][3].name,"pawn");
		//black pawn move 1
		rule.moveto(newboard[1][6],newboard,1,4);
		assertEquals(newboard[1][4].name,"pawn");
		//black pawn move 1 back
		rule.moveto(newboard[1][4],newboard,1,5);
		assertEquals(newboard[1][5],null);
	}

}
