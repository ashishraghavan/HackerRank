import java.io.IOException;
import java.util.Arrays;

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int max;
        int min;
        if(s.equals(t)) {
            return "Yes";
        }
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        if(S.length == 0 || T.length == 0) {
            return "No";
        }
        if(S.length >= T.length) {
            max = S.length;
        } else {
            max = T.length;
        }
        int i;
        int j;
        //Because we are assuming that length of T will always be smaller than S, it will lead to errors
        //like ArrayIndeOutOfBoundsException.
        for(i =0;i < max;i++) {
            if(i < T.length && i < S.length) {
                if(S[i] != T[i]) {
                    break;
                }
            } else {
                break;
            }
        }
        int charRemForS = S.length - i;
        int charRemForT = T.length - i;
        if((charRemForS + charRemForT) > k) {
            return "No";
        }
        //Start deleting characters from S.
        //Before that, save this point
        int previous = i;
        int sCount   = i;
        if(S.length < max || S.length < T.length) {
            //Get the original value of S as a string.
            //zzzzz | previousValue = "zzzzz";
            String previousValue = Arrays.toString(S);
            //tempS.length = 7;
            char[] tempS = new char[max];
            System.arraycopy(S, 0, tempS, 0, S.length);
            /*for(int p= tempS.length;p<max;p++) {
                tempS[p] = Character.MIN_VALUE;
            }*/
            S = tempS;
        }
        for(j = i;j<max;j++) {
            S[j] = Character.MIN_VALUE;
        }
        for(int p = sCount;p<T.length;p++) {
            S[previous] = T[p];
            previous++;
        }
        return "Yes";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(appendAndDelete("abcd", "abcdert", 10));
    }
}

