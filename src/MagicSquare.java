/*public class MagicSquare {

    // Complete the formingMagicSquare function below.
    //It has been given that only 3 * 3 matrices will
    //be given.
    static int formingMagicSquare(int[][] matrix) {
        //find out magic square first
        //(n ^ 2 * (n ^ 2 + 1)/2)/n
        //Sum will always be 15
        //sum = 15
        int sum = ((3 ^ 2 * ((3 ^ 2) + 1))/2)/3;
        //loop until all sums are equal
        int rowSum = calculateRowSum(3,matrix);
        int columnSum = calculateColumnSum(3, matrix);
        int diagonalSum = calculateDiagonalSum(3,matrix);
        while(rowSum != columnSum &&
                rowSum != diagonalSum &&
                columnSum != diagonalSum) {
            //We loop and set values until all sums are the same.

        }
    }

    //It is always 3
    static int calculateRowSum(int length,int[][] matrix,int row) {

    }

    //length is always 3
    static int calculateColumnSum(int height,int[][] matrix,int column) {

    }

    //length is always 3
    static int calculateDiagonalSum(int length,int[][] matrix,int diagonalNumber) {

    }

    public static void main(String[] args) throws IOException {
        System.out.println(formingMagicSquare(new int[][]{{5,3,4},{1,5,8},{6,4,2}}));
    }
}*/

