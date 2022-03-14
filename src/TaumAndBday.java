public class TaumAndBday {
    public static void main(String[] args) {
        //3,6,9,1,1
        //5,9,2,3,4
        //1000000000,989889876,1000000000,940284783,999999999
        System.out.println(taumBday(1000000000,989889876,1000000000,940284783,999999999));
    }

    //0 <= b,w,bc,wc,z <= 10^9
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long totalCost = (long) b * bc + (long) w * wc;
        long allWhites = (long) b * wc + (long) w * wc + (long) z * b;
        long allBlacks = (long)b * bc + (long)w * bc + (long)z * w;
        return (Math.min(Math.min(allWhites,allBlacks),totalCost));
    }
}
