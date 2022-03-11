import java.io.IOException;
import java.util.Arrays;

public class AppendAndDelete {
    public static void main(String[] args) throws IOException {
        //"abcdert","abcd",3
        //"abcdert","abcd",11
        //"abc","def",6
        //"hackerhappy","hackerrank",9
        //"aba","aba",7
        //"ashley","ash",2
        //"abcd", "abcdert", 10

        //"asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv",
        //"asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv", 20
        System.out.println(appendAndDeleteUpdated("zzzzz", "zzzzzzz", 4));
        //zzzzz + zzz ---> add 3 z's and remove 1 z for total of 4 ops and s==t

        //"ab", "ab", 2
        //"bb","bbb", 2 -- No,
        //"bb","bbb", 3 -- Yes - add 2 b's & remove 1 b in string s
    }

    static String appendAndDeleteUpdated(String s, String t, int k) {
        if(s.equals(t))
        if((s.length() + t.length()) <= k) {
            return "YES";
        }
        int i = 0,j=0;
        while(i < s.length() && j < t.length() && (s.charAt(i) == t.charAt(j))) {
            i++;
            j++;
        }
        int slo = s.length() - i;
        int tlo = t.length() - j;
        if(slo == 0){
            //no delete ops on s. tlo should be exactly equal to k
            //i.e the no of chars to be appended to s is all remaining
            //chars from t - chars remaining after match.
            return (tlo == k)?"YES":"NO";
        }
        return ((slo + tlo)==k)?"YES":"NO";
    }
}

