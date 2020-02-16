package Test;
import chess.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class checkMatetwo {

	@Test
	public void test() {
		board board= new board();
		rule rule=new rule();
		piece[][] newboard=board.newboard;
		test t=new test();
		// board setting
		t.printall(newboard);
		//white pawn move 2
		rule.moveto(newboard[0][1],newboard,0,3);
		t.printall(newboard);
		//same pawn move 2 again
		rule.moveto(newboard[0][3],newboard,0,5);
		//same pawn move 2 backward
		rule.moveto(newboard[0][3],newboard,0,1);
		//white rook move forward 2
		rule.moveto(newboard[0][0],newboard,0,2);
		//white rook move forward 2, check routeBlock, assert invalid
		System.out.println("There is a pawn in front of you");
		rule.moveto(newboard[0][2], newboard, 0, 4);
		t.printall(newboard);
		//move all 6 black pawns forward 2
		rule.moveto(newboard[0][6],newboard,0,4);
		rule.moveto(newboard[1][6],newboard,1,4);
		rule.moveto(newboard[2][6],newboard,2,4);
		rule.moveto(newboard[3][6],newboard,3,4);
		rule.moveto(newboard[4][6],newboard,4,4);
		rule.moveto(newboard[5][6],newboard,5,4);
		t.printall(newboard);
		//black knight moves in 2 ways
		rule.moveto(newboard[1][7],newboard,2,5);
		t.printall(newboard);
		rule.moveto(newboard[2][5],newboard,4,6);
		t.printall(newboard);
		//black bishop invalid
		rule.moveto(newboard[2][7],newboard,4,7);
		//black bishop valid
		rule.moveto(newboard[2][7],newboard,4,5);
		t.printall(newboard);
		//black king
		rule.moveto(newboard[3][7],newboard,3,6);
		t.printall(newboard);
		
		rule.moveto(newboard[3][4], newboard, 3, 3);
		rule.moveto(newboard[3][3], newboard, 3, 2);
		
		rule.moveto(newboard[3][2], newboard, 4, 1);
		t.printall(newboard);
		
		
		
		rule.moveto(newboard[3][6], newboard, 3, 5);
		rule.moveto(newboard[3][5], newboard, 3, 4);
		rule.moveto(newboard[3][4], newboard, 3, 3);
		newboard[3][4] = new rook(1,3,4,newboard);
		rule.moveto(newboard[3][3], newboard, 3, 2);
		int res = rule.moveto(newboard[3][2], newboard, 3, 1);
		assertEquals(res,2);
		t.printall(newboard);
	}

}
