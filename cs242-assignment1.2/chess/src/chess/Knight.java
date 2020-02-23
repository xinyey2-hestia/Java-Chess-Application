package chess;

public class Knight extends Piece {
	public Knight(int color, int x, int y,Piece[][] board) {
        super(color, x, y,board);
        this.name = "knight";
    }
	
	public boolean move(int a, int b) {
		if (edgeCase(a,b)||notMove(a,b,this.position.getx(), this.position.gety())) {
			return false;
		}
		if ((Math.abs(this.position.getx()-a)==1 && Math.abs(this.position.gety()-b)==2) || (Math.abs(this.position.getx()-a)==2 && Math.abs(this.position.gety()-b)==1))
			return true;
		else
			return false;
	}
}
