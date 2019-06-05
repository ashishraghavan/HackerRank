import java.io.*;

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        //The total we get before we include the month february
        int runningCount = 215;
        int noOfFebDays;
        int septDate;
        if(year == 1918 ) {
            //We know this is not a leap year
            noOfFebDays = 28;
            //Calculate the running total
            //We add 1 to the running count because 1918 was the
            //transition year and February started from 14th February
            //This year, the first date in February was 14th February
            //and last date was 28th February. The total number of
            //days in February were therefore (28 - 14 + 1). The 1
            //is added to get the correct total.
            runningCount += (noOfFebDays - 14) + 1;
            //find the date in september
            septDate = 256 - runningCount;
            return septDate + ".09" + "." + year;
        }

        if(year < 1918) {
            //This is julian calendar
            if(year % 4 == 0) {
                //this is a leap year
                noOfFebDays = 29;
            } else {
                noOfFebDays = 28;
            }
            //calculate the running total
            runningCount += noOfFebDays;
            septDate = 256 - runningCount;
            return septDate + ".09" + "." + year;
        } else {
            //This year is from gregorian calendar. leap year calculation is different
            if(year % 400 == 0 || ((year % 4 == 0) && (year % 100 !=0))) {
                noOfFebDays = 29;
            } else {
                noOfFebDays = 28;
            }
            runningCount += noOfFebDays;
            septDate = 256 - runningCount;
            return septDate + ".09" + "." + year;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(dayOfProgrammer(1918));
    }
}
