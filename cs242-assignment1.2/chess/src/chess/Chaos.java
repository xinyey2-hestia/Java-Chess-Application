package chess;

public class Chaos extends Piece{
	public Chaos(int color, int x, int y, Piece[][]board) {
		super(color, x, y, board);
		this.name = "Chaos";
		
	}
	public boolean move(int a, int b) {
		if (edgeCase(a,b)||notMove(a,b,this.position.getx(), this.position.gety())) {
			return false;
		}
		if (a == 7 || b == 7 || a==0||b==0)
			return true;
		else
			return false;
		
	

	}
}
