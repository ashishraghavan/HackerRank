import java.io.IOException;

public class TallestHurdle {

    // Complete the hurdleRace function below.
    static int hurdleRace(int maxJump, int[] hurdelHeightArr) {
        int doeses = 0;
        if(hurdelHeightArr == null || hurdelHeightArr.length ==0) {
            System.out.println("No hurdle height, returning 0 doses");
            return doeses;
        }
        //FInd the maximum hurdle out of the hurdleHeightArr
        int max = hurdelHeightArr[0];
        if(hurdelHeightArr.length == 1) {
            return Math.abs(maxJump - max);
        }
        for(int i=1;i<hurdelHeightArr.length;i++) {
            if(hurdelHeightArr[i] > max) {
                max = hurdelHeightArr[i];
            }
        }
        if(maxJump > max) {
            //maximum jump is already greater than max
            //zero d
            return 0;
        }
        //By this time, we will get the max from the hurdles.
        doeses = Math.abs(maxJump - max);
        return doeses;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(hurdleRace(7, new int[]{2,5,4,5,2}));
    }
}

