import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class AppleAndOrange {
    //              Apples    Oranges
    //7, 10, 4, 12, {2,3,-4}, {3,-2,-4}
    static void countApplesAndOranges(int houseStartingPoint, int houseEndingPoint, int appleTreeLocation,
                                      int orangeTreeLocation, int[] apples, int[] oranges) {
        //Create range of integers between house starting point and house ending point + 1
        //IntStream stream = IntStream.rangeClosed(houseStartingPoint,houseEndingPoint);
        int appleCount = 0;
        int orangeCount = 0;
        //appleTreeLocation + each value of apples = [a1,a2,a3...] check if within houseStartingPoint and houseEndingPoint inclusive
        //orangeTreeLocation + each value of oranges = [o1,o2,o3...] check if within houseStartingPoint and houseEndingPoint inclusive
        for(int appleLocation : apples) {
            int applocRelativetoHouse = appleTreeLocation + appleLocation;
            if(applocRelativetoHouse >= houseStartingPoint && applocRelativetoHouse <= houseEndingPoint) {
                appleCount++;
            }
        }

        for(int orangeLocation : oranges) {
            int orangelocRelativeToHouse = orangeTreeLocation + orangeLocation;
            if(orangelocRelativeToHouse <= houseEndingPoint && orangelocRelativeToHouse >= houseStartingPoint) {
                orangeCount++;
            }
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }


    public static void main(String[] args) {
        countApplesAndOranges(39824, 64275, 867,
                94784, new int[]{-2,2,1}, new int[]{5,-6});
    }
}

