package chess;

public class Piece {
	public int color; // Distinguish players, 0 for white, 1 for black white go first
	public Position position = new Position();
	public String name = "";
	public Piece[][] board;
	public Piece(int color, int x, int y, Piece[][] board) {
		this.color = color;
		this.position.setx(x);
		this.position.sety(y);
		this.board = board;
	}
	
	

	 public boolean routeBlockedBishop(int des_x, int des_y, int cur_x, int cur_y){
	        int dir_x = des_x > cur_x ? 1 : -1;
	        int dir_y = des_y > cur_y ? 1 : -1;
	        for (int i = 1; i < Math.abs(des_x - cur_x); i++) {
	            if (board[cur_x + i * dir_x][cur_y + i * dir_y] != null){
	                return true;
	            }
	        }
	        // destination tile has another alliance piece
	        if (board[des_x][des_y] != null) {
	            if (board[des_x][des_y].color == board[cur_x][cur_y].color)
	                return true;
	        }
	        return false;
	    }


	
	
	
    public boolean routeBlockedRook(int des_x, int des_y, int cur_x, int cur_y){
        int dir_x = 0;
        int dir_y = 0;
        if (des_x == cur_x)
            dir_y = des_y > cur_y ? 1 : -1;
        if (des_y == cur_y)
            dir_x = des_x > cur_x ? 1 : -1;
        int dist = Math.abs(des_x - cur_x) > Math.abs(des_y - cur_y) ? Math.abs(des_x - cur_x) : Math.abs(des_y - cur_y);

        for (int i = 1; i < dist; i++) {
            if (board[cur_x + i * dir_x][cur_y + i * dir_y] != null){
                return true;
            }
        }
        // destination tile has another alliance piece
        if (board[des_x][des_y]!= null) {
            if (board[des_x][des_y].color == board[cur_x][cur_y].color)
                return true;
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
