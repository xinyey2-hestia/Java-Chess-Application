package chess;
import static javax.swing.JOptionPane.showMessageDialog;
public class Rule {
	
	public int checkColor;
	boolean checkvalid (Piece p, int a, int b, Piece[][] board) {
		if (p.name=="bishop") {
			Bishop piece=(Bishop) p;
			return piece.move(a,b);
		}
		else if (p.name=="king") {
			King piece=(King) p;
			return piece.move(a,b);
		}
		else if (p.name=="knight") {
			Knight piece=(Knight) p;
			return piece.move(a,b);
		}
		else if (p.name=="pawn") {
			Pawn piece=(Pawn) p;
			return piece.move(a,b);
		}
		else if (p.name=="queen") {
			Queen piece=(Queen) p;
			return piece.move(a,b);
		}
		else if (p.name=="rook") {
			Rook piece=(Rook) p;
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
	
	// loop the whole board to see if any piece can check given piece
	boolean checkTest (int destx, int desty, Piece[][]board) {
		
		if(destx<0||destx>7||desty<0||desty>7) {
			return true;
		}
			

		  for (int i =0; i <8; i++ ) {
		   for (int j = 0; j< 8; j++) {
		    if (board[i][j]!=null) {

		    	if(board[i][j].color!=checkColor && checkvalid(board[i][j],destx,desty,board)) {
		    		 return true;
		    	}
		    	
		    	
		    	
		    
		    }
		   }
		  }
		  System.out.println("GG");
		  return false;
		 }
		 
	// check if all possible moveable places for king are checked
	boolean checkMate(int destx, int desty, Piece[][]board) {
		System.out.println("yes u re checked");
		  if (checkTest(destx,desty, board)) {
			  
			
		   if (checkvalid(board[destx][desty],destx+1,desty,board)) {
			   if (board[destx+1][desty]==null) {
				   if (!checkTest(destx+1,desty,board))
					   return false;
			   }
			   else if (board[destx][desty].color!=board[destx+1][desty].color)
				   if (!checkTest(destx+1,desty,board))
					   return false;
		    
		 
		   }
		   if (checkvalid(board[destx][desty],destx,desty+1,board)) {
			   if (board[destx][desty+1] == null) {
				   if (!checkTest(destx,desty+1,board))
					   return false;
			   }
			   else if (board[destx][desty].color!=board[destx][desty+1].color)
					   if (!checkTest(destx,desty+1,board))
						   return false;

		   }
		   if (checkvalid(board[destx][desty],destx-1,desty,board)) {
			   if (board[destx-1][desty] == null) {
				   if (!checkTest(destx-1,desty,board))
					   return false;
			   }
			   else if(board[destx][desty].color!=board[destx-1][desty].color)
				   		if (!checkTest(destx-1,desty,board))
				   			return false;

		   }
		   if (checkvalid(board[destx][desty],destx,desty-1,board)) {
			   if (board[destx][desty-1] == null) {
				   if (!checkTest(destx,desty-1,board))
					   return false;
			   }
			   	else if(board[destx][desty].color!=board[destx][desty-1].color)
				   if (!checkTest(destx,desty-1,board))
					   return false;
		   }
		   if (checkvalid(board[destx][desty],destx+1,desty+1,board)) {
			   if (board[destx+1][desty+1] == null) {
				   if (!checkTest(destx+1,desty+1,board))
					   return false;
			   }
			   	else if(board[destx][desty].color!=board[destx+1][desty+1].color)
			   		if (!checkTest(destx+1,desty+1,board))
			   			return false;
		   }
		   if (checkvalid(board[destx][desty],destx-1,desty-1,board)) {
			   if (board[destx-1][desty-1] == null) {
				   if (!checkTest(destx-1,desty-1,board))
					   return false;
			   }
			   else if (board[destx][desty].color!=board[destx-1][desty-1].color)
					   if (!checkTest(destx-1,desty-1,board))
						   return false;
		   }
		   if (checkvalid(board[destx][desty],destx+1,desty-1,board)) {
			   if (board[destx+1][desty-1] == null) {
				   if (!checkTest(destx+1,desty-1,board))
					   return false;
			   }
			   else if (board[destx][desty].color!=board[destx+1][desty-1].color)
					   if (!checkTest(destx+1,desty-1,board))
						   return false;
		   }
		   if (checkvalid(board[destx][desty],destx-1,desty+1,board)) {
			   if (board[destx-1][desty+1] == null) {
				   if (!checkTest(destx-1,desty+1,board))
					   return false;
			   }
			   else if (board[destx][desty].color!=board[destx-1][desty+1].color)
					   if (!checkTest(destx-1,desty+1,board))
						   return false;
		   }
		  
		  }
		  else
			  ;
		  
		  return true;
		 }
	
	// move piece to destination places on given board return 1 for success, 0 for fail
	public int moveto(Piece p, Piece[][] board,int a, int b) {

		if (p==null) {
			System.out.println("invalid move");
			return 0;
		}
		
		if (checkvalid(p,a,b,board)==true) {
			int x=p.position.getx();
			int y=p.position.gety();
			if (board[a][b]!=null && p.color == board[a][b].color) {
				System.out.println("You cannot eat your friends");
				return 0;
			}	
		
			
		
			if(p.name=="pawn") {
				if (Math.abs(x-a)==1 && Math.abs(y-b)==1) {
					if (board[a][b]==null) {
						System.out.println("invalid move");
						return 0;
					}
					else {
						if (board[a][b].name =="king") {
							System.out.println(a);
							System.out.println(b);
							System.out.println("Game over! Player" + p.color + " wins");
							return 2;
						}
						board[a][b] = p;
						board[x][y] = null;
						p.position.setx(a);
						p.position.sety(b);
						
						return 1;
					}
				}
				else {
					if (board[a][b]==null) {
						
						board[a][b] = p;
						board[x][y] = null;
						p.position.setx(a);
						p.position.sety(b);
						return 1;
					}
					else {
						System.out.println("pawn cannot eat forward");
						return 0;
					}
				}
			
			}
			if(p.name=="Traitor") {
			board[x][y].color = Math.abs(board[x][y].color-1);
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
				return 2;
			}
			}
			board[x][y]=null;
			board[a][b]=p;
			p.position.setx(a);
			p.position.sety(b);
			if (ifcheck(p,board)) {
				showMessageDialog(null, "checked!");
				checkColor = Math.abs(p.color-1);
				System.out.println("CHECKED !");
				int oppoking[]=findoppoking(p,board);
				if (checkMate(oppoking[0],oppoking[1],board)) {
					showMessageDialog(null, "CheckMate!");
					System.out.println("Check Mate, you win");
					return 2;
				}
				
				// checkmate detection
				//return 3;
			}
			return 1;
			
		}
		else {
			System.out.println("false movement invalid move");
			return 0;
			
		}
		
	}
	//return x y coordinate of opponent's king
	public int[] findoppoking(Piece p, Piece[][]board){
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
	
	boolean ifcheck (Piece p, Piece[][] board) {
		int oppoking[]=findoppoking(p,board);
		if (checkvalid(p,oppoking[0],oppoking[1],board)==true)
			return true;
		else
			return false;
	}
	

}
