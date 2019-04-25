import java.io.IOException;

public class Sherlock_and_Squares {

    // Complete the squares function below.
    static int squares(Integer lowerBoundary, Integer upperBoundary) {
        Integer count = 0;
        //Find the digit at unit's place
        //FInd square root of lower boundary
        double lowerBoundaryRoot = Math.sqrt(lowerBoundary);
        //Find square root of upper boundary
        double upperBoundaryRoot = Math.sqrt(upperBoundary);
        int intFloorValue = (int)Math.floor(upperBoundaryRoot);
        int intCeilingValue = (int)Math.ceil(lowerBoundaryRoot);
        count = (intFloorValue -  intCeilingValue) + 1;
        return count;
    }

    //465868129             988379794
    public static void main(String[] args) throws IOException {
        //expected answer is
        //count of (1,4,9,16,25,36,49,64,81,100) = 10
        System.out.println(squares(1,100));
    }
}
