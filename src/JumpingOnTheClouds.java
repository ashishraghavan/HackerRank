import java.io.IOException;



public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] cloudArray) {
        if(cloudArray.length == 0) {
            System.out.println("No elements in the cloud array");
            return -1;
        }
        if(cloudArray.length == 1) {
            if(cloudArray[0] == 0) {
                return 1;
            } else {
                //It is 1, no steps possible with one element.
                return -1;
            }
        }
        int cloudJumpCount = 0;
        for(int arrayCount=0;arrayCount<cloudArray.length;) {
            int oneStepJump = arrayCount + 1;
            int twoStepJump = arrayCount + 2;
            if(twoStepJump < cloudArray.length && cloudArray[twoStepJump] == 0) {
                //We found a two step progress towards the end
                //increment step count
                arrayCount = twoStepJump;
                cloudJumpCount++;
            } else if (oneStepJump < cloudArray.length && cloudArray[oneStepJump] == 0) {
                arrayCount = oneStepJump;
                cloudJumpCount++;
            } else {
                arrayCount++;
            }
        }
        return cloudJumpCount;
    }



    public static void main(String[] args) throws IOException {
        System.out.println(jumpingOnClouds(new int[]{0,0,0,0,1,0}));
    }
}

