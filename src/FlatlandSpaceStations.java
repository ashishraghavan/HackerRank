import java.util.HashSet;
import java.util.Set;

//19/20 passing test cases
public class FlatlandSpaceStations {
    public static void main(String[] args) {
        //5,new int[]{0,4}
        System.out.println(flatlandSpaceStations(6,new int[]{0,1,2,3,4,5}));
    }

    //n cities, array c contains city indexes with space stations.
    //input format is
    //5 2
    //0 4
    //where 5 is no of cities, 2 is no of cities with space station, [0,4] are the indexes of cities
    //containing the space stations.
    static int flatlandSpaceStations(int n, int[] c) {
        if(n == c.length) {
            return 0;
        }
        Set<Integer> ss = new HashSet<>();
        for (int j : c) {
            ss.add(j);
        }
        int[] result = new int[n - c.length];
        int idx = 0;
        for(int i = 0;i<n;i++) {
            if(ss.contains(i)) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (Integer s : ss) {
                int d = (i > s)?(i - s):(s-i);
                if (d < min) {
                    min = d;
                }
            }
            result[idx++] = min;
        }
        int max = Integer.MIN_VALUE;
        for (int j : result) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
