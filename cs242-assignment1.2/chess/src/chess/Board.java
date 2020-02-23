package chess;

public class Board {
	
	public Piece[][] newboard;
	public Board() {
		newboard= new Piece[8][8];
        //White 0
		newboard[0][0]= new Rook(0,0,0,newboard);
		newboard[1][0]= new Knight(0,1,0,newboard);
		newboard[2][0]= new Bishop(0,2,0,newboard);
		newboard[3][0]= new King(0,3,0,newboard);
		newboard[4][0]= new Queen(0,4,0,newboard);
        newboard[5][0]= new Bishop(0,5,0,newboard);
        newboard[6][0]= new Knight(0,6,0,newboard);
        newboard[7][0]= new Rook(0,7,0,newboard);
        newboard[0][1]= new Pawn(0,0,1,newboard);
        newboard[1][1]= new Pawn(0,1,1,newboard);
        newboard[2][1]= new Pawn(0,2,1,newboard);
        newboard[3][1]= new Pawn(0,3,1,newboard);
        newboard[4][1]= new Pawn(0,4,1,newboard);
        newboard[5][1]= new Pawn(0,5,1,newboard);
        newboard[6][1]= new Pawn(0,6,1,newboard);
        newboard[7][1]= new Pawn(0,7,1,newboard);

        //Black 1
		newboard[0][7]= new Rook(1,0,7,newboard);
		newboard[1][7]= new Knight(1,1,7,newboard);
		newboard[2][7]= new Bishop(1,2,7,newboard);
		newboard[3][7]= new King(1,3,7,newboard);
		newboard[4][7]= new Queen(1,4,7,newboard);
        newboard[5][7]= new Bishop(1,5,7,newboard);
        newboard[6][7]= new Knight(1,6,7,newboard);
        newboard[7][7]= new Rook(1,7,7,newboard);
        newboard[0][6]= new Pawn(1,0,6,newboard);
        newboard[1][6]= new Pawn(1,1,6,newboard);
        newboard[2][6]= new Pawn(1,2,6,newboard);
        newboard[3][6]= new Pawn(1,3,6,newboard);
        newboard[4][6]= new Pawn(1,4,6,newboard);
        newboard[5][6]= new Pawn(1,5,6,newboard);
        newboard[6][6]= new Pawn(1,6,6,newboard);
        newboard[7][6]= new Pawn(1,7,6,newboard);

}

}
