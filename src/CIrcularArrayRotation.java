import java.io.IOException;
import java.util.*;

public class CIrcularArrayRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] arrayToRotate, int noOfRotations, int[] queries) {
        List<Integer> resultSet = new ArrayList<>();
        Map<Integer,Integer> finalPositionMap = new HashMap<>();
        for(int currentIndex = arrayToRotate.length - 1;currentIndex>=0;currentIndex--) {
            int rotationResult = currentIndex + noOfRotations;
            int finalPosition = rotationResult % arrayToRotate.length;
            finalPositionMap.put(finalPosition,arrayToRotate[currentIndex]);
        }
        System.out.println(finalPositionMap);
        for (int query : queries) {
            //we have to calculate the new position of the array
            resultSet.add(finalPositionMap.get(query));
        }
        int[] result = new int[resultSet.size()];
        int count = 0;
        for (Integer aResultList : resultSet) {
            result[count++] = aResultList;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(circularArrayRotation(new int[]{39356,87674,16667,54260,43958,70429,53682,6169,87496,66190,90286,4912,44792,65142,36183,43856,77633,38902,1407,88185,80399,72940,97555,23941,96271,49288,27021,32032,75662,69161,33581,15017,56835,66599,69277,17144,37027,39310,23312,24523,5499,13597,45786,66642,95090,98320,26849,72722,37221,28255,60906}, 51, new int[]{47,10,12,13,6,29,22,17,7,3,30,45,1,21,50,17,25,42,5,6,47,2,24,1,6,14,24,43,7,2,35,3,13,22,16,19,0,12,10,32,41,14,1,42,35,0,9,34,17,14,15,38,17,13,40,48,27,38,41,8,14,25,11,27,47,2,20,22,39,4,28,29,43,29,21,1,4,4,10,46,43,50,33,34,12,47,32,13,8,47,22,23,21,33,24,43,35,19,39,24})));
    }
}
