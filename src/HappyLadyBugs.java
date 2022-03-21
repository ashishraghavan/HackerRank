import java.util.HashMap;
import java.util.Map;

/**
 * 2 failing test cases - 1, 7
 * Check ~/Development/HackerRank-downloaded-test-cases/HappyLadyBugs-testcase#7 to debug
 */
public class HappyLadyBugs {
    public static void main(String[] args) {
        //DD__FQ_QQF
        //AABCBC
        System.out.println(happyLadybugs("AABBC_C"));
    }

    /**
     * Instead of using a Map, we can use an int[26] array for all
     * uppercase characters from A-Z. Using ASCII value of each
     * character, we can keep a track of frequency of each
     * character.
     */
    static String happyLadybugs(String b) {
        int empty = 0;
        boolean isHappy = true;
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i =0; i< b.length(); i++) {
            Character ch = b.charAt(i);
            if(ch == '_') {
                empty++;
                continue;
            }
            if(freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch,1);
            }
        }
        if(empty == b.length()) {
            return "YES";
        }
        for(Character ch : freqMap.keySet()) {
            if(freqMap.get(ch) < 2) {
                return "NO";
            }
        }
        //AABBBCC_ -> 0:8 -> 0:7
        //AABCBC -> length() = 6, j: 0 -> 5
        //_A_AA??
        for(int j=1; j<= b.length()-1; j++) {
            if(b.charAt(j) != b.charAt(j-1) && b.charAt(j) != b.charAt(j+1)) {
                isHappy = false;
                break;
            }
        }
        if(isHappy) {
            return "YES";
        }
        if(empty == 0) {
            return "NO";
        }
        return "YES";
    }
}
