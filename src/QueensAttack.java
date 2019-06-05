@SuppressWarnings("Duplicates")
public class QueensAttack {

    // rows 0 -> 3, columns 0 -> 3
    private static char[][] board = new char[4][4];
    //obstacles
    //static int[][] obstacles = { {2,0}, {3,2}, {1,2} };
    //static int[] queen = {2,1};
    //Initialize the board
    public static void main(String[] args) {
        //Set 'Q' for queen's position on the board
        board[2][1] = 'Q';
        //Set 'O' for obstacles
        board[1][1] = 'X';
        board[2][0] = 'X';
        board[3][2] = 'X';
        board[1][2] = 'X';
        for(int i = 0;i<board.length;i++) {
            for(int j =0; j < board.length; j++) {
                if(board[i][j] != 'Q' && board[i][j] != 'X') {
                    board[i][j] = 'O';
                }
            }
        }

        //First Print out the board
        for (char[] aBoard : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(aBoard[j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        //We determine number of steps on X axis first
        //We know that the queen's x-axis co-ordinate is 2.
        //So, we will iterate over y-axis's with x-axis as 2
        //That means, [2,0],[2,1],[2,2],[2,3]
        int i = 2;
        int yCordOfQueen = 1;
        int totalSteps = 0;
        for(int j = 0; j<board.length;j++) {
            //If current square is an obstacle
            if(board[i][j] == 'X') {
                //Check if y co-ordinate of the square is greater than y co-ordinate of queen.
                //If it is, we can't take the queen any further than this square.
                if(j > yCordOfQueen) {
                    break;
                }
            } else {
                //If this position is not the queen,
                //we increment the step count
                if(board[i][j] != 'Q') {
                    totalSteps++;
                }
            }
        }

        //determine Y axis
        //Keep the column constant
        int j = 1;
        int xCordOfQueen = 2;
        for(int column = board.length - 1;column>=0;column--) {
            if(board[column][j] == 'X') {
                //Check if y co-ordinate of the square is greater than y co-ordinate of queen.
                //If it is, we can't take the queen any further than this square.
                if(column < xCordOfQueen) {
                    break;
                }
            } else {
                //If this position is not the queen,
                //we increment the step count
                if(board[column][j] != 'Q') {
                    totalSteps++;
                }
            }
        }

        //diagonal bottom left
        for(int row = 2,column = 1;row< board.length;row++,column--) {
            if(column >= 0) {
                if(board[row][column] == 'X') {
                    break;
                } else {
                    if(board[row][column] != 'Q') {
                        totalSteps++;
                    }
                }
            }
        }
        //diagonal top right
        for(int row = 2,column=1;column<board.length;column++,row--) {
            if(row >= 0) {
                if(board[row][column] == 'X') {
                    break;
                } else {
                    if(board[row][column] != 'Q') {
                        totalSteps++;
                    }
                }
            }
        }

        //diagonal top left
        //row and column both decrease
        for(int row=2,column=1;column>=0;column--,row--) {
            if(row >= 0) {
                if(board[row][column] == 'X') {
                    break;
                } else {
                    if(board[row][column] != 'Q') {
                        totalSteps++;
                    }
                }
            }
        }

        //diagonal bottom right
        //row increases, column also increases
        for(int row=2,column=1;row<board.length;row++,column++) {
            if(column < board.length) {
                if(board[row][column] == 'X') {
                    break;
                } else {
                    if(board[row][column] != 'Q') {
                        totalSteps++;
                    }
                }
            }
        }

        System.out.println("The number of steps the queen can take in the X direction is "+totalSteps);
    }

}
