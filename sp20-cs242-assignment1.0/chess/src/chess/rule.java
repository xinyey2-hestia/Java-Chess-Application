package chess;
public class rule {
	boolean checkvalid (piece p, int a, int b) {
		if (p.name=="bishop") {
			bishop piece=(bishop) p;
			return piece.move(a,b);
		}
		else if (p.name=="king") {
			king piece=(king) p;
			return piece.move(a,b);
		}
		else if (p.name=="knight") {
			knight piece=(knight) p;
			return piece.move(a,b);
		}
		else if (p.name=="pawn") {
			pawn piece=(pawn) p;
			return piece.move(a,b);
		}
		else if (p.name=="queen") {
			queen piece=(queen) p;
			return piece.move(a,b);
		}
		else if (p.name=="rook") {
			rook piece=(rook) p;
			return piece.move(a,b);
		}
		return false;		
	}
	void moveto(piece p, piece[][] board,int a, int b) {
		if (p==null) {
			System.out.println("invalid move");
			return;
		}
		else if (checkvalid(p,a,b)==true) {
			int x=p.position.getx();
			int y=p.position.gety();
			if (board[a][b] ==null)
				;
			else
				System.out.println("CAPTURED !");
			board[x][y]=null;
			//board[a][b]=null;
			board[a][b]=p;
			p.position.setx(a);
			p.position.sety(b);
			if (ifcheck(p,board))
				System.out.println("CHECKED !");
		}
		else
			System.out.println("invalid move");
	}
	
	int[] findoppoking(piece p, piece[][]board){
		int[] ret= new int [2];
		int oppo;
		if (p.color==0)
			oppo=1;
		else
			oppo=0;
		for (int i=0; i<8;i++) {
			for (int j=0; j<8;j++) {
				if(board[i][j]==null)
					continue;
				if (board[i][j].name=="king" && board[i][j].color==oppo) {
					ret[0]=i;
					ret[1]=j;
					break;
				}
			}
		}	
		return ret;
	}
	
	boolean ifcheck (piece p, piece[][] board) {
		int oppoking[]=findoppoking(p,board);
		if (checkvalid(p,oppoking[0],oppoking[1])==true)
			return true;
		else
			return false;
	}
}
