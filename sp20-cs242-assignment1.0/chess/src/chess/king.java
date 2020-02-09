package chess;

public class king extends piece{
	public king(int color, int x, int y) {
        super(color, x, y);
        this.name = "king";
    }
	
	public boolean move(int a, int b) {
		if (Math.abs(this.position.getx()-a)==1 || Math.abs(this.position.gety()-b)==1)
			return true;
		else
			return false;
	}
}
