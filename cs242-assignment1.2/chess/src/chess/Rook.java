package chess;

public class Rook extends Piece{
	public Rook(int color, int x, int y, Piece[][] board) {
		super(color,x,y, board);
		this.name = "rook";
	}
	

	public boolean move(int a, int b) {
		// check if move out of bound 
		if (edgeCase(a,b)||notMove(a,b,this.position.getx(), this.position.gety())) {
			return false;
		}
		// check if exists barrier in row or column
//		int xend = Math.max(this.position.getx(), a);
//		int xbegin = Math.min(this.position.getx(), a);
//		for (int i = 1; i <(xend- xbegin); i++) {
//			if (board[xbegin+i][b]!=null)
//				return false;
//		}
//		int yend = Math.max(this.position.gety(), b);
//		int ybegin = Math.min(this.position.gety(), b);
//		for (int i = 1; i <(yend- ybegin); i++) {
//			if (board[a][ybegin+i]!=null)
//				return false;
//		}
		// check move function
		if ((Math.abs(this.position.getx()-a)!=0)&&(Math.abs(this.position.gety()-b)!=0)) {
			return false;
		}
		return !routeBlockedRook(a,b,this.position.getx(),this.position.gety());
		
		
	}
	

}
