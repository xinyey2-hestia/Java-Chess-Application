package chess;

public class test {
	public void printall(Piece[][] newboard) {	
		for (int j=7; j>-1;j--) {
			for (int i=0; i<8;i++) {
				if (newboard[i][j] !=null)
					System.out.print(newboard[i][j].color + newboard[i][j].name +" ");
				else
					System.out.print("empty ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}	
	public void add(Piece[][] board, int color, String name, int x, int y) {

		if (name=="bishop") {
			board[x][y]=new Bishop(color,x,y,board);
		}
		else if (name=="king") {
			board[x][y]=new King(color,x,y,board);
		}
		else if (name=="knight") {
			board[x][y]=new Knight(color,x,y,board);
		}
		else if (name=="pawn") {
			board[x][y]=new Pawn(color,x,y,board);
		}
		else if (name=="queen") {
			board[x][y]=new Queen(color,x,y,board);
		}
		else if (name=="rook") {
			board[x][y]=new Rook(color,x,y,board);
		}
		else if (name=="Chaos") {
			board[x][y]=new Chaos(color,x,y,board);
		}
		else if (name=="traitor") {
			board[x][y]=new Traitor(color,x,y,board);
		}
	}
	
	public void remove (Piece[][] board, int x, int y) {
		if (board[x][y]==null)
			System.out.println("Already empty !");
		else
			board[x][y]=null;		
	}

	
}
