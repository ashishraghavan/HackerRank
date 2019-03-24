import java.io.IOException;

public class ViralAdvertising {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int noOfDays) {
        Long cumulativeLikes = 0L;
        long peopleSharedWith;
        long peopleWhoLiked = 1L;
        for(int i = 1;i<=noOfDays;i++) {
            if(i == 1) {
                peopleSharedWith = 5L;
            } else {
                peopleSharedWith = peopleWhoLiked * 3;
            }
            peopleWhoLiked = ((long) Math.floor(peopleSharedWith / 2));
            cumulativeLikes += peopleWhoLiked;
        }
        return cumulativeLikes.intValue();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(viralAdvertising(5));
    }
}

