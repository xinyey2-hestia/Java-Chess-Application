package chess;

public class rule {
	boolean checkvalid (piece p, int a, int b, piece[][] board) {
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
		else if (p.name=="Chaos") {
			Chaos piece=(Chaos) p;
			return piece.move(a,b);
		}
		else if (p.name=="Traitor") {
			Traitor piece=(Traitor) p;
			return piece.move(a,b);
		}
		return false;		
	}
	
	boolean checkTest (int destx, int desty, piece[][]board) {

		  for (int i =0; i <8; i++ ) {
		   for (int j = 0; j< 8; j++) {
		    if (board[i][j]!=null && board[i][j].color!=board[destx][desty].color && checkvalid(board[i][j],destx,desty,board)) {
		    	System.out.println(board[3][0].color);
		    	System.out.println(board[3][1].color);
		    	System.out.println(board[i][j].position.gety());
		
		    	System.out.println(destx);
		    	System.out.println(desty);
		    	
		    	
		    	
		     return true;
		    }
		    else
		    	continue;
		   }
		  }
		  return false;
		 }
		 
	boolean checkMate(int destx, int desty, piece[][]board) {
		  if (checkTest(destx,desty, board)) {
			  System.out.println("yes u re checked");
		   if (checkvalid(board[destx][desty],destx+1,desty,board)&&board[destx][desty].color!=board[destx+1][desty].color) {
			   changeColor(destx+1,desty,board);
		    if (!checkTest(destx+1,desty,board)) {
		    	changeColor(destx+1,desty,board);
		    	return false;
		    }
		    changeColor(destx+1,desty,board);
		   }
		   if (checkvalid(board[destx][desty],destx,desty+1,board)&&board[destx][desty].color!=board[destx][desty+1].color) {
			   System.out.println("I thinbk is ok");
			   changeColor(destx,desty+1,board);
		    if (!checkTest(destx,desty+1,board)) {
		    	changeColor(destx,desty+1,board);
		    	return false;
		    }
		    changeColor(destx,desty+1,board);
		   }
		   if (checkvalid(board[destx][desty],destx-1,desty,board)&&board[destx][desty].color!=board[destx-1][desty].color) {
			   changeColor(destx-1,desty,board);
			   if (!checkTest(destx-1,desty,board)) {
				   changeColor(destx-1,desty,board);
			    	return false;
			    }
			   changeColor(destx-1,desty,board);
		   }
		   if (checkvalid(board[destx][desty],destx,desty-1,board)&&board[destx][desty].color!=board[destx][desty-1].color) {
			   changeColor(destx,desty-1,board);
			   if (!checkTest(destx,desty-1,board)) {
				   changeColor(destx,desty-1,board);
			    	return false;
			    }
			   changeColor(destx,desty-1,board);
		   }
		   if (checkvalid(board[destx][desty],destx+1,desty+1,board)&&board[destx][desty].color!=board[destx+1][desty+1].color) {
			   if (!checkTest(destx+1,desty+1,board)) {
			    	return false;
			    }
		   }
		   if (checkvalid(board[destx][desty],destx-1,desty-1,board)&&board[destx][desty].color!=board[destx-1][desty-1].color) {
			   if (!checkTest(destx-1,desty-1,board)) {
			    	return false;
			    }
		   }
		   if (checkvalid(board[destx][desty],destx+1,desty-1,board)&&board[destx][desty].color!=board[destx+1][desty-1].color) {
			   if (!checkTest(destx+1,desty-1,board)) {
			    	return false;
			    }
		   }
		   if (checkvalid(board[destx][desty],destx-1,desty+1,board)&&board[destx][desty].color!=board[destx-1][desty+1].color) {
			   if (!checkTest(destx-1,desty+1,board)) {
			    	return false;
			    }
		   }
		  
		  }
		  
		  return true;
		 }
	public void moveto(piece p, piece[][] board,int a, int b) {

		if (p==null) {
			System.out.println("invalid move");
			return ;
		}
		else if (checkvalid(p,a,b,board)==true) {
			int x=p.position.getx();
			int y=p.position.gety();
			if (board[a][b]!=null && p.color == board[a][b].color) {
				System.out.println("You cannot eat your friends");
				return;
			}	
		
			
		
			if(p.name=="pawn") {
				if (Math.abs(x-a)==1 && Math.abs(y-b)==1) {
					if (board[a][b]==null) {
						System.out.println("invalid move");
						return;
					}
					else {
						board[a][b] = p;
						board[x][y] = null;
						p.position.setx(a);
						p.position.sety(b);
						return;
					}
				}
				else {
					if (board[a][b]==null) {
						
						board[a][b] = p;
						board[x][y] = null;
						p.position.setx(a);
						p.position.sety(b);
						return;
					}
					else {
						System.out.println("pawn cannot eat forward");
						return;
					}
				}
			
			}
			if(p.name=="Traitor") {
			changeColor(x,y,board);
			}
			if (board[a][b] ==null) {
				board[a][b] = p;
			}
			else {
				System.out.println("CAPTURED !");
			// check end condition
			if (board[a][b].name =="king") {
				System.out.println(a);
				System.out.println(b);
				System.out.println("Game over! Player" + p.color + " wins");
			}
			}
			board[x][y]=null;
			board[a][b]=p;
			p.position.setx(a);
			p.position.sety(b);
			if (ifcheck(p,board)) {
				System.out.println("CHECKED !");
				int oppoking[]=findoppoking(p,board);
				if (checkMate(oppoking[0],oppoking[1],board)) {
					System.out.println("Check Mate, you win");
				}
				
				// checkmate detection
			}
			
		}
		else {
			System.out.println("invalid move");
			
		}
		
	}
	
	public int[] findoppoking(piece p, piece[][]board){
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
		if (checkvalid(p,oppoking[0],oppoking[1],board)==true)
			return true;
		else
			return false;
	}
	
	void changeColor(int a, int b, piece[][]board) {
		if (board[a][b] == null)
			return;
		if (board[a][b].color ==0) {
			board[a][b].color =1;
		}
		else { 
			board[a][b].color =0;
		}
		return;
	}
}
