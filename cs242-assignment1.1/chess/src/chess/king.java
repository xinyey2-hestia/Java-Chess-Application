package chess;

public class king extends piece {
	public king(int color, int x, int y, piece[][] board) {
        super(color, x, y, board);
        this.name = "king";
    }
	
	public boolean move(int a, int b) {
		if (edgeCase(a,b)||notMove(a,b,this.position.getx(), this.position.gety())) {
			return false;
		}
		if (Math.abs(this.position.getx()-a)< 2 && Math.abs(this.position.gety()-b)<2)
			return true;
		else
			return false;
	}
}
