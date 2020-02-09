package chess;

public class knight extends piece{
	public knight(int color, int x, int y) {
        super(color, x, y);
        this.name = "knight";
    }
	
	public boolean move(int a, int b) {
		if ((Math.abs(this.position.getx()-a)==1 && Math.abs(this.position.gety()-b)==2) || (Math.abs(this.position.getx()-a)==2 && Math.abs(this.position.gety()-b)==1))
			return true;
		else
			return false;
	}
}
