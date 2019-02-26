import java.io.IOException;

public class DivisibleSumPairs {

    // Complete the divisibleSumPairs function below.
    //1,3,2,6,1,2
    // (1+2)/3 = 1, (3+6)/3=3, (1+2)/3=1, (2+1)/3=1, (1+2)/3 = 1
    //you can't sort the numbers because order will be changed.
    //Because a condition is i < j, we have to do a loop inside a loop.
    //causing the run time to be : i -> 0 : array.length (n times)
    //j -> i - 1 times (n - 1 times) O(n) * O(n-1) = O(n^2)
    static int divisibleSumPairs(int arrayCount, int k, int[] array) {
        int pairCount = 0;
        for(int i=0;i<arrayCount;i++) {
            for(int j = i+1;j<arrayCount;j++) {
                if((array[i] + array[j])%k == 0) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(divisibleSumPairs(6, 3, new int[]{1,3,2,6,1,2}));
    }
}

