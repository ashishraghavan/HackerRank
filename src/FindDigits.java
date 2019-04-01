import java.io.IOException;

public class FindDigits {

    // Complete the findDigits function below.
    static int findDigits(int number) {
        int noOfDivisors = 0;
        String numberStr = String.valueOf(number);
        char[] numberStrChar = numberStr.toCharArray();
        for (char element : numberStrChar) {
            //We don't want division by zero causing arithmetic exception
            if(Integer.parseInt(String.valueOf(element)) == 0) {
                continue;
            }
            if (number % Integer.parseInt(String.valueOf(element)) == 0) {
                noOfDivisors++;
            }
        }
        return noOfDivisors;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(findDigits(12));
    }
}

