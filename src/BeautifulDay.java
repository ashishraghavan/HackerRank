import java.io.IOException;
import java.math.BigInteger;

public class BeautifulDay {

    // Complete the beautifulDays function below.
    static int beautifulDays(int startingRange, int endingRange, int divisor) {
        BigInteger noOfBeautifulDays = BigInteger.ZERO;
        for(long i= startingRange;i <= endingRange;i++) {
            BigInteger _i = BigInteger.valueOf(i);
            //Reverse i
            String number = String.valueOf(_i);
            //We remove 0 at the end of the number to facilitate reversing without caring about 0's.
            if(number.endsWith("0")) {
                number = number.substring(0,number.length() - 1);
            }
            char[] charNumber = number.toCharArray();
            StringBuilder numberBuilder = new StringBuilder();
            //If it's a three digited number, we can't omit 0 from the middle
            //For example if it is 203, we can't reverse the number like 32.
            //We have to check if the 0 is at the last position
            //Only then, we omit this 0.
            for(int j = charNumber.length - 1;j >= 0 ;j--) {
                numberBuilder.append(charNumber[j]);
            }
            BigInteger reversedNumber = BigInteger.valueOf(Long.valueOf(numberBuilder.toString()));
            BigInteger subtractedNumber = reversedNumber.compareTo(_i) >= 1 ? reversedNumber.subtract(_i) : _i.subtract(reversedNumber);
            if(subtractedNumber.remainder(BigInteger.valueOf(divisor)).equals(BigInteger.ZERO)) {
                noOfBeautifulDays = noOfBeautifulDays.add(BigInteger.ONE);
            }
        }
        return noOfBeautifulDays.intValue();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(beautifulDays(123 , 456789, 189));
    }
}

