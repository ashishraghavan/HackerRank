import java.math.BigInteger;

public class ExtraLongFactorials {

    // Complete the extraLongFactorials function below.
    static BigInteger extraLongFactorials(int n) {
        if(n <= 0) {
            return BigInteger.ONE;
        } else {
            BigInteger nValue = BigInteger.valueOf(n);
            return nValue.multiply(extraLongFactorials(n - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(extraLongFactorials(100));
    }
}
