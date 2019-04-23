import java.io.IOException;

public class LibraryFine {

    // Complete the libraryFine function below.
    static int libraryFine(int returnedDay, int returnedMonth, int returnedYear,
                           int expectedDay, int expectedMonth, int expectedYear) {
        //First check the year.
        //If the returnedYear and expectedYear are different (returnedYear is more than expectedYear), we fine 10000 Hackos
        if(returnedYear > expectedYear) {
            return 10000;
        } else if(returnedYear < expectedYear) {
            return 0;
        }
        if(returnedMonth > expectedMonth) {
            return (500 * (returnedMonth - expectedMonth));
        } else if(returnedMonth < expectedMonth) {
            return 0;
        }
        if(returnedDay > expectedDay) {
            return (15 * (returnedDay - expectedDay));
        } else if(returnedDay <= expectedDay) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        int fine = libraryFine(2, 7, 2014, 31, 7, 2014);
        System.out.println("The fine is "+fine);
    }
}

