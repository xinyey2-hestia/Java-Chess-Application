package chess;

public class Queen extends Piece {
	public Queen(int color, int x, int y,Piece[][] board) {
        super(color, x, y,board);
        this.name = "queen";
    }
	
	public boolean move(int a, int b) {
		
			// check if move out of bound 
		if (edgeCase(a,b)||notMove(a,b,this.position.getx(), this.position.gety())) {
				return false;
		}
			
			
		if ((Math.abs(this.position.getx()-a)==0) || (Math.abs(this.position.gety()-b)==0) )
			return !routeBlockedRook(a,b,this.position.getx(),this.position.gety());
		
		if ( (Math.abs(this.position.getx()-a)==Math.abs(this.position.gety()-b))) {
			return !routeBlockedBishop(a,b,this.position.getx(),this.position.gety());
		}
			return false;
}
}