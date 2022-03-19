import java.util.Scanner;
public class TwentyFortyEight{
    public static void main(String[]args) {
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
                horizontal = 0;
                vertical = 1;
                break;
        }
        for(int i = vertical == 1 ?  2 : Math.abs(vertical); vertical == 1 ? i >= 0 : i < 4; i += vertical == 1 ? -1 : 1)
            for(int j = horizontal == 1 ? 2 : Math.abs(horizontal); horizontal == 1 ? j >= 0 : j < 4; j += horizontal == 1 ? -1 : 1) {
                //Find position of number to collide
                if(board[i][j] != 0) {
                    numPos = -1;
                    for(int n = (int) (horizontal == 0? i + Math.signum(vertical) : j + Math.signum(horizontal)); n >= 0 && n <= 3; n += horizontal == 1? 1 : (vertical == 1? 1 : -1) )
                        if(board[horizontal == 0 ? n : i][horizontal == 0 ? j : n] != 0) {
                            numPos = n;
                            break;
                        }
                }
                else continue;

                //Move Number
                if(numPos == -1) {
                    board[horizontal == 0? (vertical == -1? 0 : 3 ): i][vertical == 0? (horizontal == -1? 0 : 3): j] = board[i][j];
                    board[i][j] = 0;
                }
                else if(board[horizontal == 0? numPos : i][horizontal == 0? j : numPos] == board[i][j] && !wasCombined[horizontal == 0? numPos : i][horizontal == 0? j : numPos]) {
                    wasCombined[horizontal == 0? numPos : i][horizontal == 0? j : numPos] = true;
                    board[horizontal == 0? numPos : i][horizontal == 0? j : numPos] *=2;
                    board[i][j] = 0;
                }
                else if(board[i][j] != board[horizontal == 0? (numPos - vertical) : i][horizontal == 0? j : (numPos - horizontal)]) {
                    board[horizontal == 0? (numPos - vertical) : i][horizontal == 0? j : (numPos - horizontal)] = board[i][j];
                    board[i][j] = 0;
                }
            }

        return board;
    }
}
