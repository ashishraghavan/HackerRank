import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {
    public static void main(String[] args) {
        List<Integer> arrA = Arrays.asList(3,4);
        List<Integer> arrB = Arrays.asList(24,48);
        System.out.println(getTotalX(arrA,arrB));
    }

    //2 3
    //2 4
    //16 32 96
    //[2,4], [16,32,96] ==> [4,8,16]
    //[3,4], [24,48]
    static int getTotalX(List<Integer> a, List<Integer> b) {
        Integer maxA = getMaxA(a);
        int count = 0;
        int mulVal = maxA;
        while(mulVal <= b.get(0)) {
            if(isFactorInA(a,mulVal) && isMultipleInB(b,mulVal)) {
                count++;
            }
            mulVal++;
        }
        return count;
    }

    static Integer getMaxA(List<Integer> a) {
        Integer max = Integer.MIN_VALUE;
        for(Integer val : a) {
            if(val > max) {
                max = val;
            }
        }
        //check if max % a[i] == 0
        return max;
    }

    static boolean isFactorInA(List<Integer> a,Integer value) {
        for(Integer listVal : a) {
            if(value % listVal != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isMultipleInB(List<Integer> b,Integer value) {
        for(Integer listVal : b) {
            if(listVal % value != 0) {
                return false;
            }
        }
        return true;
    }
}
