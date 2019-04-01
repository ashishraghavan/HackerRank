import java.io.IOException;

public class JumpingOnTheCloudsRevisited {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] array, int jumpStep) {
        int position = 0;
        int energy = 100;
        while(true) {
            //Do the jump
            int preJumpStep = position + jumpStep;
            int jump = preJumpStep % array.length;
            //decrement the energy
            energy--;
            //Check if we have enough energy left.
            if(energy <= 0) {
                //If not, we return a -1 since we don't
                //have enough energy to make any more
                //jumps
                return -1;
            }
            //Assign new value of jump
            //to position
            position = jump;
            //Now check if this position has
            //value of 1. If it does, we decrement
            //energy by 2 more before quitting
            //the while loop.
            if(array[position] == 1) {
                energy = energy - 2;
            }
            //Same as before check
            //if energy is less than or
            //equal to 0.
            //If it is, return a -1
            //because we can't make
            //any more jumps.
            if(energy <= 0) {
                return -1;
            }
            //Check for final position
            if(position <= 0) {
                //We reached the final position
                //So break from the loop
                //and return the current
                //energy
                break;
            }
            if(preJumpStep >= array.length) {
                break;
            }
        }
        return energy;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(jumpingOnClouds(new int[]{0,0,1,0,0,1,1,0}, 2));
    }
}
