import java.io.IOException;

public class AngryProfessor {

    // Complete the angryProfessor function below.
    static String angryProfessor(int studentThreshold, int[] studenttimeArray) {
        int onTimeStudents = 0;
        //If studenttimeArray element is greater than 0, they came late
        //If studenttimeArray element is less than or equal to 0, they came early or on time.
        for (int aStudenttimeArray : studenttimeArray) {
            //If a student comes on time
            if (aStudenttimeArray <= 0) {
                onTimeStudents = onTimeStudents + 1;
            }
        }
        if(onTimeStudents >= studentThreshold) {
            return "NO";
        } else {
            return "YES";
        }
    }

    public static void main(String[] args) throws IOException {
            System.out.println(angryProfessor(4, new int[]{-93,-86,49,-62,-90,-63,40,72,11,67}));
        }
    }


/*

    YES
*/

