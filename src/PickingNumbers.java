import java.io.IOException;
import java.util.*;

public class PickingNumbers {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    //After sorting, the list is
    //[1,1,2,2,4,4,5,5,5]
    //Start from first integer, loop from second to end
    //If subtraction results in less than or equal to 1
    //add it to the sub list.
    //Find the longest sequence of numbers where difference
    //between current number and next number is less than
    //or equal to 1
    //[1,1,2,2,4,4,5,5,5]
    private static int pickingNumbers(List<Integer> numberList) {
        // Write your code here
        //First sort the list
        int longestCount = 1;
        int currentLongestCount = 0;
        Collections.sort(numberList);
        System.out.println(numberList);
        List<Integer> longestSequenceList = new ArrayList<>();
        longestSequenceList.add(numberList.get(0));
        for(int i = 1;i < numberList.size();i++) {
            //If the index of previous number is greater
            // than 0, check if absolute difference
            //between current number and previous
            //number is less than or equal to 1.
            //If it is, increment longestcount
            //otherwise, set longestCount to 0.
            //Difference between current and
            //previous number can be 1, but
            //difference between any two numbers
            //must be less than or equal to one.
            if(checkSetDifference(numberList.get(i),longestSequenceList)) {
                longestSequenceList.add(numberList.get(i));
            } else {
                if(longestSequenceList.size() > currentLongestCount) {
                    currentLongestCount = longestSequenceList.size();
                }
                longestSequenceList.clear();
                longestSequenceList.add(numberList.get(i));
            }
        }
        return Math.max(longestSequenceList.size(),currentLongestCount);
    }

    private static boolean checkSetDifference(Integer number,
                                              List<Integer> longestSequenceSet) {
        for(Integer _number : longestSequenceSet) {
            if(Math.abs(number - _number) > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> numberList = new ArrayList<>();
        Collections.addAll(numberList,1,2,2,3,1,2);
        System.out.println(PickingNumbers.pickingNumbers(numberList));
    }
}

