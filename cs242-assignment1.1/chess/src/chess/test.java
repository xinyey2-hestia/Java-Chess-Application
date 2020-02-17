package chess;

public class test {
	public void printall(piece[][] newboard) {	
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
	public void add(piece[][] board, int color, String name, int x, int y) {
		if (board[x][y] !=null) {
			System.out.println("Remove the piece in ("+x+", "+y+") first.");
			return;
		}
		if (name=="bishop") {
			board[x][y]=new bishop(color,x,y,board);
		}
		else if (name=="king") {
			board[x][y]=new king(color,x,y,board);
		}
		else if (name=="knight") {
			board[x][y]=new knight(color,x,y,board);
		}
		else if (name=="pawn") {
			board[x][y]=new pawn(color,x,y,board);
		}
		else if (name=="queen") {
			board[x][y]=new queen(color,x,y,board);
		}
		else if (name=="rook") {
			board[x][y]=new rook(color,x,y,board);
		}
		else if (name=="choas") {
			board[x][y]=new Chaos(color,x,y,board);
		}
		else if (name=="traitor") {
			board[x][y]=new Traitor(color,x,y,board);
		}
	}
	
	public void remove (piece[][] board, int x, int y) {
		if (board[x][y]==null)
			System.out.println("Already empty !");
		else
			board[x][y]=null;		
	}

	
}
