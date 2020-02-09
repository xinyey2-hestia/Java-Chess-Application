package chess;

public class bishop extends piece{
	public bishop(int color, int x, int y) {
        super(color, x, y);
        this.name = "bishop";
    }
	
	public boolean move(int a, int b) {
		if (Math.abs(this.position.getx()-a)==Math.abs(this.position.gety()-b))
			return true;
		else
			return false;
	}
}
