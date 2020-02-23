package chess;

public class Pawn extends Piece{
	public boolean ifmoved=false;
	public Pawn(int color, int x, int y,Piece[][]board) {
        super(color, x, y,board);
        this.name = "pawn";
    }
	public boolean move(int a, int b) {
		if (edgeCase(a,b)||notMove(a,b,this.position.getx(), this.position.gety())) {
			return false;
		}
		
		if (this.color==0) {//white
			if (this.ifmoved==false && b-this.position.gety()==2 && this.position.getx()==a ) {
				this.ifmoved=true;
				return true;
			}
			else if (b-this.position.gety()==1 && this.position.getx()==a) {
				this.ifmoved=true;
				return true;
			}
			else if (b-this.position.gety()==1 && Math.abs(this.position.getx()-a)==1)
				return true;
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
			else if (this.position.gety()-b==1 && Math.abs(this.position.getx()-a)==1)
				return true;
			else
				return false;
		}
		return false;
	}
}
