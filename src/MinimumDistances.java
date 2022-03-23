import java.util.*;

public class MinimumDistances {
    public static void main(String[] args) {
        //7, 1, 3, 4, 1, 7
        //3,2,1,2,3
        //7, 6, 6, 10, 2, 5, 2, 2, 3, 5
        System.out.println(minimumDistances(Arrays.asList(5209, 5202, 1198, 1348, 8584, 1980, 7622, 2793, 5748, 4370, 7183, 4954, 7986, 5085, 5438, 7515, 9583, 9143, 3242, 1313, 9113, 1773, 9484, 7811, 6876, 4015, 1878, 3478, 6880, 9830, 5811, 4589, 3362, 9972, 5411, 8715, 6203, 3519, 5111, 4215, 1827, 6074, 2037, 7410, 4298, 9292, 2959, 3442, 2053, 5427, 6652, 2188, 1338, 3885, 7774, 5515, 4631, 4115, 9612, 9830, 5464, 1662, 1723, 2784, 8752, 8613, 6188, 7283, 5136, 3404, 2001, 6872, 1278, 6039, 4099, 4127, 6666, 9119, 8325, 7376, 3551, 3346, 8394, 5832, 7131, 8483, 4378, 9166, 8915, 3913, 3434, 9744, 8117, 7551, 9694, 3417, 1837, 5075, 7570, 2492)));
    }

    //1 <= a.size() <= 1000
    //1 <= a[i] <= 100000
    static int minimumDistances(List<Integer> a) {
        Map<Integer,Integer> map = new HashMap<>();
        int diff = Integer.MAX_VALUE;
        int currDiff;
        for(int i=0; i<a.size();i++) {
            if(map.containsKey(a.get(i))) {
                currDiff = Math.abs(i - map.get(a.get(i)));
                if(currDiff<diff){
                    diff = currDiff;
                }
                map.put(a.get(i),i);
            } else {
                map.put(a.get(i),i);
            }
        }
        return (diff == Integer.MAX_VALUE)?-1:diff;
    }
}
