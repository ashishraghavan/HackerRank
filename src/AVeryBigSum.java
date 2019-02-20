import java.io.IOException;

public class AVeryBigSum {

    // Complete the aVeryBigSum function below.
    private static long aVeryBigSum(long[] array) {
        long arraySum = 0;
        for (long arrayValue : array) {
            arraySum += arrayValue;
        }
        return arraySum;
    }

    public static void main(String[] args) throws IOException {
        long[] ar = new long[]{1000000001,1000000002,1000000003,1000000004,1000000005};
        System.out.println(aVeryBigSum(ar));
    }
}

