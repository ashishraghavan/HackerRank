//TODO : Resolve logic issue
public class ChocolateFeast {
    public static void main(String[] args) {
        //15,3,2
        //10,2,5
        //12,4,4
        //6,2,2
        //10000,260,50
        //10000, 10000, 2
        //50000,480,20

        //Failing
        //7,3,2
        System.out.println(chocolateFeast(7,3,2));
    }

    //2 <= n <= 100000
    //1 <= c <= n
    //2 <= m <= n
    static int chocolateFeast(int n, int c, int m) {
        int start = n/c;
        int wrap = n % c;
        int cnt = start;
        while ((start + wrap) >= m) {
            wrap += start;
            start = wrap/m;
            cnt += start;
            wrap = wrap % m;
        }
        return cnt;
    }
}
