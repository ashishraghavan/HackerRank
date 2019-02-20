public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        for(int i=0;i<n;i++) {
            int k = n - i;
            //Print blanks
            for(int j=0;j<k;j++) {
                System.out.print(" ");
            }
            //Print numbers
            for(int j=k;j<=n;j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        staircase(10);
    }
}

