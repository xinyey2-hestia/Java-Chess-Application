package chess;

public class Position {
int x;
int y;

public int getx() {
	return x;
}

public int gety() {
	return y;
}

public void setx(int row) {
	x = row;
}

public void sety(int column) {
	y = column;
}

public Position(){
	x = 0;
	y = 0;
}

}
