public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    /*private static void miniMaxSum(int[] arr) {
        BigInteger fourSum = BigInteger.ZERO;
        BigInteger max = new BigInteger(Integer.MIN_VALUE);
        double min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<i;j++) {
                fourSum += arr[j];
            }
            for(int j=i+1;j<arr.length;j++) {
                fourSum += arr[j];
            }
            if(fourSum > max) {
                max = fourSum;
            }
            if(fourSum < min) {
                min = fourSum;
            }
            //reset fourSum to zero before proceeding with the next index.
            fourSum = 0;
        }
        System.out.println(min+" "+max);
    }

    public static void main(String[] args) {
        miniMaxSum(new int[]{1,2,3,4,5});
    }*/
}
