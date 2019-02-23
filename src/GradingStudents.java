import java.io.IOException;
import java.util.Arrays;

public class GradingStudents {


    private static int[] gradingStudents(int[] grades) {
        if(grades.length == 0) {
            return new int[]{};
        }
        for(int i =0;i<grades.length;i++) {
            int score = grades[i];
            //Formula?
            //|score - next multiple of 5| < 3
            //Next multiple of 5?
            //(5 * n) > score
            //For example if score = 73,
            //n will have to be 15
            //so that 5 * 15 = 75 and 75 > 73
            //n > score / 5
            int nextMultipleOfFive = ((score/5) + 1) * 5;
            if(score < 38 || Math.abs(score - nextMultipleOfFive) >= 3) {
                grades[i] = score;
            } else {
                grades[i] = nextMultipleOfFive;
            }
        }
        return grades;
    }

    public static void main(String[] args) throws IOException {
        int[] result = gradingStudents(new int[]{73,67,38,33});
        System.out.println(Arrays.toString(result));
    }
}

