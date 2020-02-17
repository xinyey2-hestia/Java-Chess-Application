package chess;

public class Traitor extends piece{
	public Traitor(int color, int x, int y, piece[][]board) {
		super(color, x, y, board);
		this.name = "Traitor";
		
	}
	public boolean move(int a, int b) {
		if (edgeCase(a,b)||notMove(a,b,this.position.getx(), this.position.gety())) {
			return false;
		}
		if (Math.abs(this.position.getx()-a)==Math.abs(this.position.gety()-b))
			return !routeBlockedBishop(a,b,this.position.getx(),this.position.gety());
		
		return false;
		
	}
}