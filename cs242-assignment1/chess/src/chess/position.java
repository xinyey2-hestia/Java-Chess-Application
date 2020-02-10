package chess;

public class position {
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

public position(){
	x = 0;
	y = 0;
}

}
