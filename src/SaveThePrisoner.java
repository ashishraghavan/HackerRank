import java.io.IOException;

public class SaveThePrisoner {
    //cnt = 384, curr = 94731253
    //4294967295
    //2147483648
    //1000000000
    //499999999 999999997 2
    //499999999 999999998 2
    //999999999 999999999 1
    static int saveThePrisonerUpdated(int n, int m, int s) {
        long cnt = 1,curr = s;
        while(cnt < m) {
            if(curr > n) {
                curr = 1;
                continue;
            }
            cnt++;
            curr++;
        }
        return (int)curr;
    }

    /**
     *https://www.hackerrank.com/challenges/save-the-prisoner/problem
     *
     * n = no of prisoners
     * m = no of candies
     * s = the chair no from where distribution of candies start
     *
     * 3 possible cases
     * 1. n==m, s = 1
     * 2. n > m, #2a. s = 1, #2b. s > 1
     * 3. n < m, #3a. s = 1, #3b. s > 1
     *
     * 1. return n
     * 2. m % s. If s == 1
     */
    public static void main(String[] args) throws IOException {
        //352926151,380324688,94730870
        //4,6,2
        //5,2,1
        //5,2,2
        //7,19,2
        //3,7,3
        //499999999, 999999997, 2 - 499999999
        //499999999, 999999998, 2 - 1
        //999999999 999999999 1 - 999999999
        System.out.println(saveThePrisonerUpdated(499999999, 999999998, 2));
    }
}
