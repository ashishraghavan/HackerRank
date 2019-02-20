import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> list, List<Integer> b) {
        //What if sizes of the the list's are different?
        //This has not been mentioned in the problem statement.
        //So, return array {0,0}.
        List<Integer> arrayList = new ArrayList<>();
        if(list.size() != b.size()) {
            arrayList.add(0);
            arrayList.add(0);
            return arrayList;
        }
        int aliceCount = 0;
        int bobCount = 0;
        for(int key =0;key < list.size();key++) {
            if(list.get(key) > b.get(key)) {
                aliceCount++;
            } else if(list.get(key) < b.get(key)) {
                bobCount++;
            }
        }
        arrayList.add(aliceCount);
        arrayList.add(bobCount);
        return arrayList;
    }

    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        firstList.add(5);
        firstList.add(6);
        firstList.add(7);
        secondList.add(3);
        secondList.add(6);
        secondList.add(10);
        System.out.println(compareTriplets(firstList,secondList));
    }
}
