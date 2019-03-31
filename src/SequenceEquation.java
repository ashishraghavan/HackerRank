import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] array) {
        List<Integer> arrayList = new ArrayList<>();
        int[] newArray = new int[array.length];
        //Add array elements to arrayList.
        for (int key : array) {
            arrayList.add(key);
        }
        for(int i = 1;i <= array.length;i++) {
            if (arrayList.contains(i)) {
                int firstIndex = arrayList.indexOf(i) + 1;
                if (arrayList.contains(firstIndex)) {
                    int secondIndex = arrayList.indexOf(firstIndex) + 1;
                    newArray[i-1] = secondIndex;

                }
            }
        }

        return newArray;
    }


    public static void main(String[] args) throws IOException {
        int[] result = permutationEquation(new int[]{4,3,5,1,2});
        System.out.println(Arrays.toString(result));
    }
}

