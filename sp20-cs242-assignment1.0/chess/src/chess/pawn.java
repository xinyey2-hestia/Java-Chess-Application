package chess;

public class pawn extends piece{
	boolean ifmoved=false;
	public pawn(int color, int x, int y) {
        super(color, x, y);
        this.name = "pawn";
    }
	public boolean move(int a, int b) {
		if (this.color==0) {//white
			if (this.ifmoved==false && b-this.position.gety()==2 && this.position.getx()==a ) {
				this.ifmoved=true;
				return true;
			}
			else if (b-this.position.gety()==1 && this.position.getx()==a) {
				this.ifmoved=true;
				return true;
			}
			//else if (b-this.position.gety()==1 && Math.abs(this.position.getx()-a)==1 && )
			else
				return false;
		}

		if (this.color==1) {//black
			if (this.ifmoved==false && this.position.gety()-b==2 && this.position.getx()==a ) {
				this.ifmoved=true;
				return true;
			}
			else if (this.position.gety()-b==1 && this.position.getx()==a) {
				this.ifmoved=true;
				return true;
			}
			else
				return false;
		}
		return false;
	}
}