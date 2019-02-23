public class Staircase {

    // Complete the staircase function below.
    //if n = 6
    static void staircase(int n) {
        //i = 6 - 1 = 5, 5 >= 0; i--
        for(int i=n-1;i>=0;i--) {
            //k = 6 - 5 = 1;
            int k = n - i;
            //Print blanks
            //j = 5; j > 1; j--
            for(int j=n-1 ;j>=k;j--) {
                System.out.print(" ");
            }
            //Print #
            for(int j=k;j>0;j--) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        staircase(6);
    }
}

