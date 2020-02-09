package chess;

public class queen extends piece{
	public queen(int color, int x, int y) {
        super(color, x, y);
        this.name = "queen";
    }
	
	public boolean move(int a, int b) {
		if ((Math.abs(this.position.getx()-a)==0) || (Math.abs(this.position.gety()-b)==0) || (Math.abs(this.position.getx()-a)==Math.abs(this.position.gety()-b)))
			return true;
		else
			return false;
	}
}
