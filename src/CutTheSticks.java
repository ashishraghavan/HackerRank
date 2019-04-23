import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] inputArray, List<Integer> leftStickList) {
        //First sort the array so that the lowest one is at the beginning
        if(inputArray.length <= 0) {
            //convert the list into an array and return.
            return copyListToArray(leftStickList);
        }

        if(inputArray.length == 1) {
            //Add a one since only one element is left in the inputArray at this point.
            leftStickList.add(1);
            //convert the list into an array and return.
            return copyListToArray(leftStickList);
        } else {
            int smallestStick = inputArray[0];
            //delete this element.
            //Before deleting anything, let's put the total in the array list
            leftStickList.add(inputArray.length);
            //Find the index from where to delete the element.
            int deleteIndex = 0;
            for(int i =1;i<inputArray.length;i++) {
                if(inputArray[i] == smallestStick) {
                    deleteIndex++;
                }
            }
            //we are using deleteIndex + 1 because of 0 based indexing.
            int[] finalInputArray = new int[inputArray.length - (deleteIndex + 1)];
            //subtract the value of smallestIndex from other big sticks
            for(int i = deleteIndex + 1;i<inputArray.length;i++) {
                inputArray[i] = inputArray[i] - smallestStick;
            }
            //Copy all elements - the smallest ones to a different array.
            System.arraycopy(inputArray,deleteIndex + 1,finalInputArray,0,finalInputArray.length);
            return cutTheSticks(finalInputArray,leftStickList);
        }
    }

    static int[] copyListToArray(List<Integer> finalStickList) {
        int[] finalArray = new int[finalStickList.size()];
        int index = 0;
        for(Integer value : finalStickList) {
            finalArray[index++] = value;
        }
        return finalArray;
    }

    public static void main(String[] args) throws IOException {
        int[] inputArray = new int[]{8,8,14,10,3,5,14,12};
        Arrays.sort(inputArray);
        int[] result = cutTheSticks(inputArray,new ArrayList<>());
        System.out.println(Arrays.toString(result));
    }
}

