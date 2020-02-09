package chess;

public class rook extends piece{
	public rook(int color, int x, int y) {
        super(color, x, y);
        this.name = "rook";
    }
	
	public boolean move(int a, int b) {
		if ((Math.abs(this.position.getx()-a)==0) || (Math.abs(this.position.gety()-b)==0))
			return true;
		else
			return false;
	}
}
