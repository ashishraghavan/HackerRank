import java.io.IOException;

public class Sherlock_and_Squares {

    // Complete the squares function below.
    static int squares(Integer lowerBoundary, Integer upperBoundary) {
        Integer count = 0;
        for(Integer i = lowerBoundary; i <= upperBoundary;i++) {
            Double value = Math.sqrt(Double.parseDouble(String.valueOf(i)));
            //Check if value is an integer
            if(Math.floor(value) != value || Double.isInfinite(value)) {
                continue;
            }
            Integer preSquaredValue = value.intValue();
            Double squaredValue = Math.pow(preSquaredValue,2);
            if(squaredValue.intValue() == i) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(squares(465868129, 988379794));
    }
}
