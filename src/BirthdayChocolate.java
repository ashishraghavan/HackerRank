import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BirthdayChocolate {

    // Complete the birthday function below.
    //birthday cannot be greater than 31
    //birth month cannot be greater than 12.
    //birth month is the length of such a sub sequence within the array.
    //birth day is the addition of sub sequence in above step.
    private static int birthday(List<Integer> chocolateList, int birthDay, int birthMonth) {
        if(birthDay > 31) {
            System.out.println("Birth day cannot be greater than 31 as no month has more than 31 days");
            return -1;
        }
        if(birthMonth > 12) {
            System.out.println("Birth month cannot be greater than 12 as there are only 12 months in an year");
            return -1;
        }
        // 2,2,1,3,2
        int finalCount = 0;
        for(int i=0;i<chocolateList.size();i++) {
            //Sum of the sub sequence should be equal to the birthMonth.
            int finalLength = i + birthMonth;
            int birthDayCount = 0;
            //length of the sub sequence should be less than the length of the array.
            if(finalLength <= chocolateList.size()) {
                for(int j=i;j<finalLength;j++) {
                    birthDayCount += chocolateList.get(j);
                }
                if(birthDayCount == birthDay) {
                    finalCount++;
                }
            }
        }
        return finalCount;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> array = new ArrayList<>();
        //2,2.1.3.2
        //1,2,1,3,2 | 3,2 birth day = 3, birth month = 2
        // 1,2 | 2,1 | 1,3 | 3,2 |
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(3);
        array.add(2);
        System.out.println(birthday(array, 3,2));
    }
}

