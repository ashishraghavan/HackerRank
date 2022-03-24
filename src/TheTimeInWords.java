import java.util.HashMap;
import java.util.Map;

public class TheTimeInWords {
    public static void main(String[] args) {
        //12,40
        //12,0
        //12,45
        //5,28
        //5,47
        System.out.println(timeInWords(7,29));
    }

    static String timeInWords(int h, int m) {
        int next,curr,left;
        StringBuilder res = new StringBuilder();
        Map<Integer,String> wordsMap = integerToString();
        if(m == 0) {
            res.append(wordsMap.get(h)).append(" o' clock");
            return res.toString();
        }
        if(m > 30) {
            next = h + 1;
            if(next > 12) next = next % 12;
            if(m == 45) {
                res.append("quarter to ").append(wordsMap.get(next));
                return res.toString();
            }
            left = 60 - m;
            res.append(wordsMap.get(left)).append(" minutes to ").append(wordsMap.get(next));
        } else {
            curr = h;
            if(m == 15) {
                res.append("quarter past ").append(wordsMap.get(curr));
            } else if(m == 30) {
                res.append("half past ").append(wordsMap.get(curr));
            } else {
                res.append(wordsMap.get(m));
                if (m == 1) {
                    res.append(" minute past ");
                } else {
                    res.append(" minutes past ");
                }
                res.append(wordsMap.get(curr));
            }
        }
        return res.toString();
    }

    static Map<Integer,String> integerToString() {
        Map<Integer,String> intToStrMap = new HashMap<>();
        intToStrMap.put(1,"one");
        intToStrMap.put(2,"two");
        intToStrMap.put(3,"three");
        intToStrMap.put(4,"four");
        intToStrMap.put(5,"five");
        intToStrMap.put(6,"six");
        intToStrMap.put(7,"seven");
        intToStrMap.put(8,"eight");
        intToStrMap.put(9,"nine");
        intToStrMap.put(10,"ten");
        intToStrMap.put(11,"eleven");
        intToStrMap.put(12,"twelve");

        intToStrMap.put(13,"thirteen");
        intToStrMap.put(14,"fourteen");
        intToStrMap.put(16,"sixteen");
        intToStrMap.put(17,"seventeen");
        intToStrMap.put(18,"eighteen");
        intToStrMap.put(19,"nineteen");
        intToStrMap.put(20,"twenty");
        intToStrMap.put(21,"twenty one");
        intToStrMap.put(22,"twenty two");
        intToStrMap.put(23,"twenty three");
        intToStrMap.put(24,"twenty four");
        intToStrMap.put(25,"twenty five");
        intToStrMap.put(26,"twenty six");
        intToStrMap.put(27,"twenty seven");
        intToStrMap.put(28,"twenty eight");
        intToStrMap.put(29,"twenty nine");

        intToStrMap.put(31,"thirty one");
        intToStrMap.put(32,"thirty two");
        intToStrMap.put(33,"thirty three");
        intToStrMap.put(34,"thirty four");
        intToStrMap.put(35,"thirty five");
        intToStrMap.put(36,"thirty six");
        intToStrMap.put(37,"thirty seven");
        intToStrMap.put(38,"thirty eight");
        intToStrMap.put(39,"thirty nine");
        intToStrMap.put(40,"forty");
        intToStrMap.put(41,"forty one");
        intToStrMap.put(42,"forty two");
        intToStrMap.put(43,"forty three");
        intToStrMap.put(44,"forty four");
        intToStrMap.put(46,"forty six");
        intToStrMap.put(47,"forty seven");
        intToStrMap.put(48,"forty eight");
        intToStrMap.put(49,"forty nine");
        intToStrMap.put(50,"fifty");
        intToStrMap.put(51,"fifty one");
        intToStrMap.put(52,"fifty two");
        intToStrMap.put(53,"fifty three");
        intToStrMap.put(54,"fifty four");
        intToStrMap.put(55,"fifty five");
        intToStrMap.put(56,"fifty six");
        intToStrMap.put(57,"fifty seven");
        intToStrMap.put(58,"fifty eight");
        intToStrMap.put(59,"fifty nine");
        return intToStrMap;
    }
}
