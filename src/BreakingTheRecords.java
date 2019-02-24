import java.io.IOException;
import java.util.Arrays;

public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    //Assign min and max as the first record in the array.
    //for each value of the array, check if the record is
    //greater than max. If it is, increment the max count by 1.
    //In the same loop instance, check if the record is less
    //than minimum. If it is, increment min count by 1.
    //return new long array with max as first element
    //and min as second element.
    static long[] breakingRecords(long[] scores) {
        long maxBreak = 0L;
        long minBreak = 0L;
        long max = scores[0];
        long min = scores[0];
        for (long score : scores) {
            if (score > max) {
                max = score;
                maxBreak++;
            }
            if (score < min) {
                min = score;
                minBreak++;
            }
        }
        return new long[]{maxBreak,minBreak};
    }

    public static void main(String[] args) throws IOException {
        long[] result = breakingRecords(new long[]{10, 5, 20, 20, 4, 5, 2, 25, 1});
        System.out.println(Arrays.toString(result));
    }
}

