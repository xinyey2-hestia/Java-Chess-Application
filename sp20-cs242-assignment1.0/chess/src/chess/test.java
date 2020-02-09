package chess;

public class test {
	
	void printall(piece[][] newboard) {	
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
	

}
