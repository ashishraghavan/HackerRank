
import java.io.IOException;
import java.math.BigInteger;

public class RepeatedString {

    // Complete the repeatedString function below.
    private static BigInteger repeatedString(String str, long number) {
        //If str is null, return a bigint 0
        if(str == null) {
            return BigInteger.ZERO;
        }
        //If string length is 1 and it is an a, return the number as is
        //else return 0.
        if(str.length() == 1) {
            if(str.equals("a")) {
                return BigInteger.valueOf(number);
            } else {
                return BigInteger.ZERO;
            }
        }
        //Find out the modulus of str.length % number
        //cfimaakj.length = 8, number = 554045874191
        //554045874191 % 8 = 7
        Integer modulusValue = 0;
        BigInteger dividedValue = BigInteger.ZERO;
        Integer strLength = str.length();
        BigInteger bigIntNumber = BigInteger.valueOf(number);
        //If input number is greater than string length, we do a modulo and division operation
        //to find extra characters to be added to the string and number of times that
        //the count needs to be multiplied.
        //For example, if abababab is the string and number is 50, we know that
        //there will be a remainder that needs to be added to abababab since the string
        //will be repeated the divided value times with remainder extra characters.
        //We get this remainder by doing a modulo division - number % string.length.
        //We do a divide also to check the number of times we have to repeat the
        //counting of a's. For example, if abababab is the string, and we get a
        //divided value of 10, we would do a (count number of a's in abababab) * 10
        //which would give us the total count of a's after repetition minus the number
        //of extra characters)
        if(bigIntNumber.compareTo(BigInteger.valueOf(strLength)) >= 1) {
            BigInteger modulus = bigIntNumber.mod(BigInteger.valueOf(strLength));
            modulusValue = modulus.intValue();
            dividedValue = (bigIntNumber.divide(BigInteger.valueOf(strLength)));
        } else if(BigInteger.valueOf(strLength).compareTo(bigIntNumber) >= 1) {
            //The number of characters needed is less than the string length. In this case,
            //we take a substring of the string and return number of a's in that sub string.
            return BigInteger.valueOf(calculateNoOfA(str.substring(0,bigIntNumber.intValue()).toCharArray()));
        }
        //Now we calculate the substring to be taken from the main string
        //depending on the remainder obtained by dividing the input number
        //by the string length.
        String extraStrChars = modulusValue > str.length() ? "" : str.substring(0,(modulusValue > 0 ? modulusValue : 0));
        char[] extraStrCharArray = extraStrChars.toCharArray();
        long extraCharArrayCount = calculateNoOfA(extraStrCharArray);
        long aCount = calculateNoOfA(str.toCharArray());
        return (BigInteger.valueOf(aCount).multiply(dividedValue.compareTo(BigInteger.ZERO)
                >= 1 ? dividedValue : BigInteger.ONE)).add(BigInteger.valueOf(extraCharArrayCount));
    }

    /**
     *
     * @param inputCharArray The input char array for which we want to calculate the number of a's
     * @return returns a long count of number of a's in the inputCharArray.
     */
    private static long calculateNoOfA(char[] inputCharArray) {
        long count = 0;
        for (char anExtraStrCharArray : inputCharArray) {
            if (anExtraStrCharArray == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm",736778906400L));
    }
}

