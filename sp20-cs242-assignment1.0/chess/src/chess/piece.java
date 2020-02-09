package chess;

public class piece {
int color;
position position=new position();
String name = "";
public piece(int color, int x, int y) {
	this.color=color;
	this.position.setx(x);
	this.position.sety(y);
	}
}
