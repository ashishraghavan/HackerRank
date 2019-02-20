import java.math.BigInteger;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    //BigInteger was used instead of integer because
    //on adding very large numbers from the array
    //an integer overflow can happen.
    //Further, I have used Long.MAX_VALUE and Long.MIN_VALUE
    //instead of Integer.MAX_VALUE and Integer.MIN_VALUE
    //for the same reasons as mentioned above.
    private static void miniMaxSum(int[] arr) {
        BigInteger fourSum = BigInteger.ZERO;
        BigInteger max = BigInteger.valueOf(Long.MIN_VALUE);
        BigInteger min = BigInteger.valueOf(Long.MAX_VALUE);
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<i;j++) {
                fourSum = fourSum.add(BigInteger.valueOf(arr[j]));
            }
            for(int j=i+1;j<arr.length;j++) {
                fourSum = fourSum.add(BigInteger.valueOf(arr[j]));
            }
            if(fourSum.compareTo(max) >= 1) {
                max = fourSum;
            }
            if(fourSum.compareTo(min) < 1) {
                min = fourSum;
            }
            //reset fourSum to zero before proceeding with the next index.
            fourSum = BigInteger.ZERO;
        }
        System.out.println(min+" "+max);
    }

    public static void main(String[] args) {
        int[] arrayValues = new int[5];
        arrayValues[0] = 942381765;
        arrayValues[1] = 627450398;
        arrayValues[2] = 954173620;
        arrayValues[3] = 583762094;
        arrayValues[4] = 236817490;
        miniMaxSum(arrayValues);
    }
}
