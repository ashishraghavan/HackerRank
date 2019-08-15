import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")

/**
 * 2D array with first line first number telling you the number of boxes in the board, second number saying the number of obstacles
 *               second line first number telling you the queen's position x co-ordinate, second number telling you queen's position y co-ordinate
 *               Each successive lines first number tells you the x co-ordinate of the obstacle and second number is y co-ordinate of the obstacle.
 *  5 3
    4 3

    5 5
    4 2
    2 3
 */
public class QueensAttack {

    // rows 0 -> 3, columns 0 -> 3
    //obstacles
    //static int[][] obstacles = { {2,0}, {3,2}, {1,2} };
    //static int[] queen = {2,1};
    //Initialize the board
    public static void main(String[] args) throws Exception {
        createBoardAndCalculateSteps(4,0, 4, 4, new int[][]{});//int[][]{{5,5},{4,2},{2,3}}
        //return totalSteps
        System.exit(0);
    }

    /**
     *  @param boardLength - Will go from 0 -> boardLength - 1
     * @param noOfObstacles - The no of obstacles present in the board; marked as X.
     *                      [0][0] = 5 [0][1] = 5
     *                      [1][0] = 4 [1][1] = 2
     */
    public static void createBoardAndCalculateSteps(int boardLength, int noOfObstacles, int queenXCord, int queenYCoord, int[][] obstacles) {
        char[][] board = new char[boardLength][boardLength];
        int totalSteps = 0;
        int[][] boardInformation = new int[boardLength][boardLength];
        for(int row=0; row < boardInformation.length;row++) {
            for(int column = 0; column < boardInformation[row].length;column++) {
                board[row][column] = 'X';
            }
        }
        List<Integer> obstacleList = new ArrayList<>(noOfObstacles);
        //Mark obstacles as O
        for (int[] obstacle : obstacles) {
            for (int anObstacle : obstacle) {
                obstacleList.add(anObstacle);
            }
        }
        //Use the list to mark X for obstacles
        for(int index = 0;index<obstacleList.size();index = index + 2) {
            board[obstacleList.get(index) - 1][obstacleList.get(index+1) - 1] = 'O';
        }
        //Mark position of the queen
        board[queenXCord - 1][queenYCoord - 1] = 'Q';
        //Print the board
        for (char[] aBoard : board) {
            for (char anABoard : aBoard) {
                System.out.print(anABoard + " ");
            }
            System.out.println();
        }

        int first = calculateXAxisSteps(queenXCord,queenYCoord, board, totalSteps);
        int second = calculateYAxisSteps(queenXCord,queenYCoord,board, first);
        int third = calculateDiagonalRight(queenXCord,queenYCoord,board, second);
        int fourth = calculateDiagonalLeft(queenXCord,queenYCoord,board, third);
        System.out.println("Total steps in the x,y co-ordinate = "+fourth);
    }

    //Only the y-axis changes, x-axis value remains the same
    //We go towards queen's left direction, then towards right
    //direction counting the no of steps.
    //xCordOfQueen = 4, yCordOfQueen = 3
    private static int calculateXAxisSteps(int xCordOfQueen, int yCordOfQueen, char[][] board, int totalSteps) {
        //towards left
        int x = xCordOfQueen - 1;
        int y = yCordOfQueen - 1;
        for(int j = y;j>=0;j--) {
            if(board[x][j] == 'O') {
                break;
            } else if(board[x][j] == 'X') {
                totalSteps++;
            }
        }
        //towards right
        for(int j = y;j < board.length;j++) {
            if(board[x][j] == 'O') {
                break;
            } else if(board[x][j] == 'X') {
                totalSteps++;
            }
        }
        return totalSteps;
    }

    private static int calculateYAxisSteps(int xCordOfQueen,int yCordOfQueen,char[][] board, int totalSteps) {
        //towards top
        int x = xCordOfQueen - 1;
        int y = yCordOfQueen - 1;
        for(int i = x;i>=0;i--) {
            if(board[i][y] == 'O') {
                break;
            } else if(board[i][y] == 'X') {
                totalSteps++;
            }
        }
        //towards bottom
        for(int i = xCordOfQueen;i<board.length;i++) {
            if(board[i][y] == 'O') {
                break;
            } else if(board[i][y] == 'X') {
                totalSteps++;
            }
        }
        return totalSteps;
    }

    //bottom left (3,2) -> (4,1) x axis will be incremented by one, y axis will be decremented by 1
    //top right   (3,2) -> (2,3) -> (1,4) x axis will be decremented by 1, y axis will be incremented by 1
    private static int calculateDiagonalRight(int xCordOfQueen,int yCordOfQueen,char[][] board, int totalSteps) {
        //Initialize position of queen correctly.
        int x = xCordOfQueen - 1;
        int y = yCordOfQueen - 1;
        //bottom right from the queen
        for(int i = x,j=y;i < board.length;i++,j++) {
            if(board[i][j] == 'O') {
                break;
            } else if(board[i][j] == 'X') {
                totalSteps++;
            }
        }

        //top left from the queen
        for(int i = x,j=y; j >= 0;i--,j--) {
            if(board[i][j] == 'O') {
                break;
            } else if(board[i][j] == 'X') {
                totalSteps++;
            }
        }
        return totalSteps;
    }

    private static int calculateDiagonalLeft(int xCordOfQueen,int yCoordOfQueen,char[][] board, int totalSteps) {
        int x = xCordOfQueen - 1;
        int y = yCoordOfQueen - 1;

        for(int i = x,j = y;i < board.length && j >= 0;i++,j--) {
            if(board[i][j] == 'O') {
                break;
            } else if(board[i][j] == 'X') {
                totalSteps++;
            }
        }

        for(int i =x,j = y; i >= 0 && j < board.length;i--,j++) {
            if(board[i][j] == 'O') {
                break;
            } else if(board[i][j] == 'X') {
                totalSteps++;
            }
        }
        return totalSteps;
    }
}
