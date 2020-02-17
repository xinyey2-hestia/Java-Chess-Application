package chess;

public class board {
	
	public piece[][] newboard;
	public board() {
		newboard= new piece[8][8];
        //White 0
		newboard[0][0]= new rook(0,0,0,newboard);
		newboard[1][0]= new knight(0,1,0,newboard);
		newboard[2][0]= new bishop(0,2,0,newboard);
		newboard[3][0]= new king(0,3,0,newboard);
		newboard[4][0]= new queen(0,4,0,newboard);
        newboard[5][0]= new bishop(0,5,0,newboard);
        newboard[6][0]= new knight(0,6,0,newboard);
        newboard[7][0]= new rook(0,7,0,newboard);
        newboard[0][1]= new pawn(0,0,1,newboard);
        newboard[1][1]= new pawn(0,1,1,newboard);
        newboard[2][1]= new pawn(0,2,1,newboard);
        newboard[3][1]= new pawn(0,3,1,newboard);
        newboard[4][1]= new pawn(0,4,1,newboard);
        newboard[5][1]= new pawn(0,5,1,newboard);
        newboard[6][1]= new pawn(0,6,1,newboard);
        newboard[7][1]= new pawn(0,7,1,newboard);

        //Black 1
		newboard[0][7]= new rook(1,0,7,newboard);
		newboard[1][7]= new knight(1,1,7,newboard);
		newboard[2][7]= new bishop(1,2,7,newboard);
		newboard[3][7]= new king(1,3,7,newboard);
		newboard[4][7]= new queen(1,4,7,newboard);
        newboard[5][7]= new bishop(1,5,7,newboard);
        newboard[6][7]= new knight(1,6,7,newboard);
        newboard[7][7]= new rook(1,7,7,newboard);
        newboard[0][6]= new pawn(1,0,6,newboard);
        newboard[1][6]= new pawn(1,1,6,newboard);
        newboard[2][6]= new pawn(1,2,6,newboard);
        newboard[3][6]= new pawn(1,3,6,newboard);
        newboard[4][6]= new pawn(1,4,6,newboard);
        newboard[5][6]= new pawn(1,5,6,newboard);
        newboard[6][6]= new pawn(1,6,6,newboard);
        newboard[7][6]= new pawn(1,7,6,newboard);

}

}
