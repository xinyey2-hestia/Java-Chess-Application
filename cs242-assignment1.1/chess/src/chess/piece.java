package chess;

public class piece {
	public int color; // Distinguish players, 0 for white, 1 for black white go first
	position position = new position();
	public String name = "";
	public piece[][] board;
	public piece(int color, int x, int y, piece[][] board) {
		this.color = color;
		this.position.setx(x);
		this.position.sety(y);
		this.board = board;
	}
	
	
	public boolean routeBlockedBishop(int desti, int destj, int locx, int locy){
        if (desti < locx){
            if (destj < locy){ //3rd quadrant
                for (; desti < locx; desti++) {
                    piece p = this.board[desti][destj++];
                    if (p != null) {
                        return true;
                    }
                }
            }
            if (destj > locy){ // 2nd quadrant
                for (; desti < locx; desti++) {
                    piece p = this.board[desti][destj--];
                    if (p != null) {
                        return true;
                    }
                }
            }
        }
        if (desti > locx){
            if (destj < locy){ // 4th quadrant
                for (; desti > locx; desti--) {
                    piece p = this.board[desti][destj++];
                    if (p != null) {
                        return true;
                    }
                }
            }
            if (destj > locy){ //1st quadrant
                for (; desti > locx; desti--) {
                    piece p = this.board[desti][destj--];
                    if (p != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean routeBlockedRook(int desti, int destj, int locx, int locy){
        if (destj < locy-1){ //moving backwards
            for ( ; destj < locy-1; destj++){
                piece p = board[locx][destj+1];
                if (p != null){
                    return true;
                }
            }
        }
        if (destj-1 > locy){ //moving forward
            for ( ; locy < destj; destj--){
                piece p = board[locx][destj];
                if (p != null){
                    return true;
                }
            }
        }
        if (desti < locx-1){ //moving left
            for ( ; desti < locx; desti++){
                piece p = board[desti][locy];
                if (p != null){
                    return true;
                }
            }
        }
        if (desti-1 > locx){ //moving right
            for ( ; locx < desti; desti--){
                piece p = board[desti][locy];
                if (p != null){
                    return true;
                }
            }
        }
        return false;
    }
	
	
	
	
	
	
    public boolean edgeCase(int i, int j){
        if(i < 0 || i > 7 || j < 0 || j > 7){
            return true;
        }
        return false;
    }

    public boolean notMove(int desti, int destj, int loci, int locj){
        return desti == loci && destj == locj;
    }
}