import java.text.DecimalFormat;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double negativeSum = 0d;
        double positiveSum = 0d;
        double zeroSum = 0d;

        //Find out positive numbers
        for (int value : arr) {
            if (value == 0) {
                zeroSum++;
            } else if (value > 0) {
                positiveSum++;
            } else {
                negativeSum++;
            }
        }
        double positiveRatio = positiveSum/(double)arr.length;
        double negativeRatio = negativeSum /(double)arr.length;
        double zeroRatio = zeroSum /(double)arr.length;
        String pattern = "0.000000";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        decimalFormat.applyPattern(pattern);
        System.out.println(decimalFormat.format(positiveRatio));
        System.out.println(decimalFormat.format(negativeRatio));
        System.out.println(decimalFormat.format(zeroRatio));
    }

    public static void main(String[] args) {
        int[] array = new int[]{-4,3,-9,0,4,1};
        plusMinus(array);
    }
}

