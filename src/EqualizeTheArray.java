import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Finding out the minimum number of array elements to delete so that all elements of the array are equal.
 */
@SuppressWarnings("ALL")
public class EqualizeTheArray {

    private static Logger logger = Logger.getLogger(EqualizeTheArray.class.getSimpleName());
    public static void main(String[] args) {
        //Test 1 : {3,3,2,1,3}
        int[] arr = {7,7,7,7,1,3,6,6,2,2,2,2,9,9,9,9,9};
        System.out.println(equalizeArray(arr));
    }

    //Assumption that any of the numbers
    static int equalizeArray(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int deletionCount = 0;
        Map<Integer,Integer> numberMap = new HashMap<>();
        for(Integer number : arr) {
            if(numberMap.containsKey(number)) {
                numberMap.put(number,numberMap.get(number) + 1);
            } else {
                numberMap.put(number,1);
            }
        }
        //find the key with maximum value in the map.
        int max = Integer.MIN_VALUE;
        int keyMax = -1;
        for(Integer key : numberMap.keySet()) {
            Integer value = numberMap.get(key);
            if(value >= max) {
                max = value;
                keyMax = key;
            }
        }
        //Delete every thing in the array except keyMax and count the deletions
        for (Map.Entry<Integer, Integer> mapKeyValue : numberMap.entrySet()) {
            if (!((Map.Entry) mapKeyValue).getKey().equals(keyMax)) {
                deletionCount += numberMap.get(((Map.Entry) mapKeyValue).getKey());
            }
        }

        return deletionCount;
    }
}
