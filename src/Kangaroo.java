import java.io.IOException;

public class Kangaroo {

    //kangaroo A initial position = 0
    //kangaroo A meters per jump  = 3
    //kangaroo B initial position = 4
    //kangaroo B meters per jump  = 2
    // 3 step vs 2 step,
    // step difference : 4,3,2,1,0
    //A : 0,3,6,9,12,15,18...
    //B : 4,6,8,10,12........

    // 6 step vs 2 step, after 1 jump,  LCM(6,2) = 2 x 3, 2 x 1 = 2 x 3 = 6
    //step difference : 4,0,4,8,12
    //A : 0,6,12,18,24,30....
    //B : 4,6,8,10,12,14,16,18.....

    //4 step vs 2 step, after 1 jump, we reach the same number LCM(4,2) = 2 x 2, 2 x 1 = 2 x 2 = 4
    //Step difference : 2,0
    //A : 0,4,8,12,16,20....
    //B : 2,4,6,8,10,12,14,16,18,20....

    //3 step vs 1 step count LCM(3,1) = 3 x 1, 1 x 1 = 3
    //Step difference : 4,2,0
    //A : 1,4,7,10,13
    //B : 5,6,7,8,9,

    // 5 step vs 3 step count LCM(5,3) = 5 x 1,3 x 1 = 5 x 3 = 15
    //Step difference : 1,1,3,4...
    //A : 6,11,16,21,26,31,36,41,46,51,56,61,66,71,76
    //B : 7,10,13,16,19,22,25,28,31,34,37,40,43,46,49

    // 6 vs 4 step count LCM(6,4) = 2 x 3, 2 x 2 = 2 x 2 x 3 = 12
    //Step difference : 7,5,3,1,1,3,6,7
    //A : 8, 14, 20, 26, 32, 38, 44, 50, 56, 62, 68, 74, 80
    //B :15, 19, 23, 27, 31, 35, 39, 43, 47, 51, 55, 59, 63

    // 4 vs 3 step count LCM(4,3) = 2 x 2, 3 x 1 = 2 x 2 x 3 = 12
    //Step difference : 2,1,0
    //A : 3,7,11,15,19,23,27,31,35,39,43,47,51
    //B : 5,8,11

    // 4 vs 4 step.
    // 0 < 5 <= 10
    //10 jumps
    //Step difference : 5,5,5...
    //A : 0,4,8,12,16
    //B : 5,9,13,17,21

    //current difference value has to be always less than the previous difference value for kangaroos to meet.
    private static String kangaroo(int kangarooAPos, int kangarooAMeterPerJump, int kangarooBPos, int kangarooBMeterPerJump) {
        //B position > A position
        //If B jump > A jump or B jump = A jump, answer is always no since they can never meet with same step difference
        //and kangaroo B initial position > kangaroo A initial position.
        if(kangarooBMeterPerJump >= kangarooAMeterPerJump) {
            return "NO";
        }
        long[] aArray = new long[10000];
        aArray[0] = kangarooAPos;
        long[] bArray = new long[10000];
        bArray[0] = kangarooBPos;
        //Create step count for kangaroo A
        for(int i=1; i < 10000;i++) {
            aArray[i] = aArray[i-1] + kangarooAMeterPerJump;
        }
        for(int j=1;j< 10000;j++) {
            bArray[j] = bArray[j-1] + kangarooBMeterPerJump;
        }
        //Check if any difference count is same
        for(int k=0;k<10000;k++) {
            if(aArray[k] == bArray[k]) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(kangaroo(0, 3, 4, 2));
    }
}

