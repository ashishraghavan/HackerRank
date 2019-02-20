import java.io.IOException;

public class TimeConversion {

    /**
     * Depending on whether it is AM or PM, we decide how to proceed
     * Since 24 hour format is divided into two 12 hour parts, we
     * should use the appropriate time interval for AM and PM correspondingly.
     * If AM - we use 0 - 12 example: 05:30:00AM would be the same except the AM
     * If PM - we use 12 -24 example: 07:45:00PM would be 12 + 7 = 19:45:00
     * Correct format is ##:##:##AM and ##:##:##PM
     * 2:2:4 characters.
     * @param twelveHourTimeStr The input time string.
     */
    private static void timeConversion(String twelveHourTimeStr) {
        //sanity checks
        //separate by :
        if(twelveHourTimeStr == null) {
            System.out.println("Null string found, expecting a valid input time string");
            return;
        }
        String[] splitTime = twelveHourTimeStr.split(":");
        if(splitTime.length != 3) {
            System.out.println("There was an error processing the input string, could not split the time correctly, invalid input time string");
            return;
        }
        //It is the correct length of 3.
        //Check all digits and AM or PM correctly.
        if(splitTime[0].toCharArray().length != 2) {
            System.out.println("Hours is not correct. Expected 2 digit input, but found "+splitTime[0].toCharArray().length);
            return;
        }
        if(splitTime[1].toCharArray().length != 2) {
            System.out.println("minutes is not correct. Expected 2 digit input, but found "+splitTime[0].toCharArray().length);
            return;
        }
        if(splitTime[2].toCharArray().length != 4) {
            System.out.println("minutes is not correct. Expected 4 digit input, but found "+splitTime[0].toCharArray().length);
            return;
        }
        //Check if last two letters are AM or PM. Anything else, throw an error and return.
        char[] ampm = splitTime[2].toCharArray();
        if(ampm[2] != 'A' && ampm[2] != 'P' && (ampm[2] != 'a' && ampm[2] != 'p')) {
            System.out.println("Time identifier is neither AM or PM. Incorrect input string");
            return;
        }
        if(ampm[3] != 'M' && ampm[3] != 'm') {
            System.out.println("Time identifier is neither AM or PM. Incorrect input string");
            return;
        }
        int hours = Integer.parseInt(splitTime[0]);
        int minutes = Integer.parseInt(splitTime[1]);
        int seconds = Integer.parseInt(splitTime[2].substring(0,2));
        if(splitTime[2].substring(2,4).equals("PM") && hours < 12) {
            hours += 12;
        }
        if(splitTime[2].substring(2,4).equals("AM") && hours == 12) {
            hours = 0;
        }
        StringBuilder outputTimeStr = new StringBuilder();
        outputTimeStr.append(String.valueOf(hours).length() != 2? "0"+hours : hours)
                .append(":")
                .append(String.valueOf(minutes).length() != 2?"0"+minutes : minutes)
                .append(":")
                .append(String.valueOf(seconds).length() != 2?"0"+seconds : seconds);
        System.out.println(outputTimeStr);
    }


    public static void main(String[] args) throws IOException {
        timeConversion("12:45:54PM");
    }
}

