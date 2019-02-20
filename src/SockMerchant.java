import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static Integer sockMerchant(int n, int[] ar) {
        //sock number vs count
        Map<Integer,Integer> sockCountMap = new HashMap<>();
        for (int i1 : ar) {
            //Check if this sock number is present in the map.
            //If it is, increment the number.
            if (sockCountMap.get(i1) != null) {
                int sockCount = sockCountMap.get(i1);
                sockCountMap.put(i1, ++sockCount);
            } else {
                //We put a 1 indicating that this is the first time
                //we are putting a sock in the map
                sockCountMap.put(i1, 1);
            }
        }
        //Return and count even number of pairs and return.
        int finalSockCount = 0;
        for(Integer sockCountKey : sockCountMap.keySet()) {
            Integer sockCount = sockCountMap.get(sockCountKey);
            if((sockCount/2) >= 1) {
                finalSockCount += sockCount/2;
            }
        }
        return finalSockCount;
    }

    public static void main(String[] args) {
        int[] sockArray = new int[]{1,2,1,2,1,3,2};
        System.out.println("The total sock count is "+sockMerchant(sockArray.length,sockArray));
    }
}