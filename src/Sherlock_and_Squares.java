import java.io.IOException;

public class Sherlock_and_Squares {

    // Complete the squares function below.
    static int squares(Integer lowerBoundary, Integer upperBoundary) {
        Integer count = 0;
        for (int i = lowerBoundary; i <= upperBoundary; i++) {
            //Find the digit at unit's place
            int unitPlaceDigit = i % 10;
            if (unitPlaceDigit == 2 || unitPlaceDigit == 3 || unitPlaceDigit == 7 || unitPlaceDigit == 8) {
                continue;
            }
            Double value = Math.sqrt(i);
            //Check if value is an integer
            ////If the value is an integer, it must be a perfect square.
            if (Math.floor(value) == value) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(squares(465868129, 988379794));
    }
}
