import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    private static void birthdayCakeCandles(int[] array) {
        int max = Integer.MIN_VALUE;
        int candles = 1;
        for (int arrayValue : array) {
            if(arrayValue == max) {
                candles += 1;
            }
            if (arrayValue > max) {
                max = arrayValue;
            }
        }
        //We check how many candles of the max value do we have.
        System.out.println(array.length);
        System.out.println(candles);
    }

    public static void main(String[] args) throws IOException {
        birthdayCakeCandles(new int[]{3,2,1,3});
    }
}
