public class AppleAndOrange {
    //              Apples    Oranges
    //7, 10, 4, 12, {2,3,-4}, {3,-2,-4}
    static void countApplesAndOranges(int houseStartingPoint, int houseEndingPoint, int appleTreeStartAndEndPoint,
                                      int orangeTreeStartAndEndPoint, int[] apples, int[] oranges) {
        //Apple tree is x units away from the left co-ordinate of the house.
        int appleTreeFromHouse = Math.abs(houseStartingPoint - appleTreeStartAndEndPoint);
        int orangeTreeFromHouse = Math.abs(houseEndingPoint - orangeTreeStartAndEndPoint);
        //Calculate apple to house distance array
        int applesOnHouse = 0;
        int orangesOnHouse = 0;
        for(int i=0;i<apples.length;i++) {
            apples[i] += appleTreeStartAndEndPoint;
            if(apples[i] >= houseStartingPoint) {
                applesOnHouse++;
            }
        }
        for(int j=0;j<oranges.length;j++) {
            oranges[j] += orangeTreeStartAndEndPoint;
            if(oranges[j] <= houseEndingPoint) {
                orangesOnHouse++;
            }
        }
        System.out.println(applesOnHouse);
        System.out.println(orangesOnHouse);
    }


    public static void main(String[] args) {
        countApplesAndOranges(39824, 64275, 867,
                94784, new int[]{-2,2,1}, new int[]{5,-6});
    }
}

