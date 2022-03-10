import java.util.*;

public class AcmIcpcTeam {
    public static void main(String[] args) {
        //"10101","11100","11010","00101"
        //
        List<Integer> result = acmTeam(Arrays.asList("10101", "11110", "00010"));
        System.out.println("max = "+result.get(0)+", no_of_teams = "+result.get(1));
    }

    static List<Integer> acmTeam(List<String> topic) {
        int teams = topic.size();
        int max = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        List<Integer> noOfOnes = new ArrayList<>();
        int ones;
        int teamWithMax = 0;
        for(int i=0;i<teams;i++) {
            for(int j=i+1;j<teams;j++) {
                ones = 0;
                for(int k=0;k<topic.get(i).length();k++) {
                    if(topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1') {
                        ones++;
                    }
                }
                if(ones > max) {
                    max = ones;
                }
                noOfOnes.add(ones);
            }
        }
        result.add(0,max);
        for(Integer noOfOne : noOfOnes) {
            if(noOfOne == max) {
                teamWithMax++;
            }
        }
        result.add(1,teamWithMax);
        return result;
    }
}
