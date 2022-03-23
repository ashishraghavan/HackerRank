
public class ChocolateFeast {
    public static void main(String[] args) {
        //15,3,2
        //10,2,5
        //12,4,4
        //6,2,2
        //10000,260,50
        //10000, 10000, 2
        //50000,480,20
        //7,3,2
        System.out.println(chocolateFeastII(7,3,2));
    }

    /*
    * n = 7, c = 3, m = 2
    * 7/3 = 2 bars = 2 wrappers = 1 bar = 1 wrapper = end
    * 2 + 1 = 3 bars
    * wrap = n/c;
    * cnt = n/c;
    * while(wrap >= m) {
    *
    * n = 15, c = 3, m = 2
    * barsConsumed = 15/3 = 5;
    * wrappers = 5;
    * barsFromWrapper = 5/2 = 2
    * wrappers = (5%2) + 2 = 3
    * barsConsumed = 5 + 2 = 7
    * 3 >= 2
    * barsFromWrapper = 3/2 = 1
    * wrappers = (3%2) + 1 = 2
    * barsConsumed = 7 + 1 = 8
    * 2 >= 2
    * barsFromWrapper = 2/2 = 1
    * wrappers = (2%2) + 1 = 1
    * barsConsumed = 8 + 1 = 9
    * 1 !>= 2 return barsConsumed = 9
    * */
    static int chocolateFeastII(int n, int c, int m) {
        int barsConsumed = n/c;
        int wrappers = barsConsumed;
        int barsFromWrapper;
        while(wrappers >= m) {
            barsFromWrapper = wrappers/m;
            wrappers = (wrappers % m) + barsFromWrapper;
            barsConsumed += barsFromWrapper;
        }
        return barsConsumed;
    }
}
