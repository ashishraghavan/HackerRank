import java.io.IOException;

public class DiagonalDifference {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        int leftToRightDiagonalSum = 0;
        int rightToLeftDiagonalSum = 0;
        for(int i = 0; i < arr.length; i++) {
            leftToRightDiagonalSum += arr[i][i];
        }
        for(int j=arr.length - 1,k=0; j >= 0; j--,k++) {
            rightToLeftDiagonalSum += arr[j][k];
        }
        return Math.abs(leftToRightDiagonalSum - rightToLeftDiagonalSum);
    }


    public static void main(String[] args) throws IOException {
        int[][] arr = { {11,2,4}, {4,5,6}, {10,8,-12} };
        System.out.println(diagonalDifference(arr));
    }
}

