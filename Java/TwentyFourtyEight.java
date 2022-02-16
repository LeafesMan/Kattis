import java.util.Scanner;
public class TwentyFourtyEight {

	public static void main(String[] args) {
		// Initialize Variables and get input
		Scanner in = new Scanner(System.in);
		//Populate 2D array
		int board [][]= new int[4][4];
		for(int i = 0; i < 4; i++)
			for(int j = 0; j <4; j++)
				board[i][j] = in.nextInt();
		int dir = in.nextInt();
		in.close();
		
		board = moveTiles(board, dir);
		
		//Prints board
		for(int i = 0; i < 4; i++) {
			System.out.println();
			for(int j = 0; j < 4; j++)
				System.out.print(board[i][j] + " ");
		}
	}
	
	//Moves board tiles based on direction given 0,1,2,3 correspond to left,up,right,down
	public static int[][] moveTiles(int[][] board, int dir){
		int numPos = 0, vertical = 0, horizontal = 0;
		boolean wasCombined [][] = new boolean[4][4];
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				wasCombined[i][j] = false;
		
		//Sets up variables based on direction
		switch(dir) {
		case 0:
			horizontal = -1;
			vertical = 0;
			break;
		case 1:
			horizontal = 0;
			vertical = -1;
			break;
		case 2:
			horizontal = 1;
			vertical = 0;
			break;
		case 3:
			horizontal = 1;
			vertical = 0;
			break;
		}
		for(int i = 2+vertical; i<4; i++)
			for(int j = 0; j<4; j++) {
				//Find position of number to collide
				if(board[i][j] != 0) {
					numPos = -1;
					for(int n = 1; i-n >= 0; n++)
						if(board[i-n][j] != 0) {
							numPos = i-n;	
							break;
						}
				}
				else continue;
				
				//Move Number
				if(numPos == -1) {
					board[0][j] = board[i][j];
					board[i][j] = 0;
				}
				else if(board[numPos][j] == board[i][j] && !wasCombined[numPos][j]) {
					wasCombined[numPos][j] = true;
					board[numPos][j] *=2;
					board[i][j] = 0;
				}
				else {
					int temp = board[i][j];
					board[i][j] = 0;
					board[numPos+1][j] = temp;
				}
			}
		
		return board;
	}
}
		
