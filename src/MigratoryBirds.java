import java.io.IOException;
import java.util.*;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> birdArray) {
        //Find the frequency of each element first.
        Map<Integer,Integer> birdFrequencyMap = new HashMap<>();
        for(Integer birdValue : birdArray) {
            //Check if this number is already present in the map.
            //We add this bird type into the map
            if(birdFrequencyMap.get(birdValue) == null) {
                birdFrequencyMap.put(birdValue, 1);
            } else {
                birdFrequencyMap.put(birdValue,birdFrequencyMap.get(birdValue)+1);
            }
        }
        //We check which birds have the same pairs.
        //We are sure that all bird types will be in {1,2,3,4,5}
        //1 -> 2, 2 -> 2, 3 -> 3, 4-> 3, 5 -> 1
        int highestFrequency = -1;
        int birdNumber = -1;
        for(int i=1;i<6;i++) {
            Integer frequency = birdFrequencyMap.get(i);
            if(frequency == null){
                continue;
            }
            if(frequency > highestFrequency) {
                highestFrequency = frequency;
                birdNumber = i;
            } else if(frequency == highestFrequency) {
                birdNumber = Math.min(i,birdNumber);
            }
        }
        return birdNumber;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> birdArray = new ArrayList<>();
        Collections.addAll(birdArray,1,4,4,4,5,3);
        System.out.println(migratoryBirds(birdArray));
    }
}
