import java.io.IOException;
import java.util.*;

public class ClimbingTheLeaderboard {

    // Complete the migratoryBirds function below.
    static int[] climbingTheLeaderboard(int[] scoreArray,int[] aliceList) {
        List<Integer> rankList = new ArrayList<>(scoreArray.length);
        rankList.add(1);
        int currentScore = 1;
        for(int i =1;i<scoreArray.length;i++) {
            if(scoreArray[i] == scoreArray[i-1]) {
                rankList.add(currentScore);
            } else {
                currentScore += 1;
                rankList.add(currentScore);
            }
        }
        int[] result = new int[aliceList.length];
        int count = 0;
        for(int j=0;j<aliceList.length;j++) {
            for(int k =0;k<scoreArray.length;k++) {
                if(aliceList[j] >= scoreArray[k]) {
                    if(aliceList[j] > scoreArray[k]) {
                        if(k == 0) {
                            result[count++] = 1;
                        } else {
                            result[count++] = rankList.get(k) + 1;
                        }
                        break;
                    } else if(aliceList[j] == scoreArray[k]) {
                        result[count++] = rankList.get(k);
                        break;
                    }
                }
            }
            if(count == 0) {
                result[count++] = rankList.get(rankList.size() - 1) + 1;
            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int[] scoreList = new int[]{100,100,50,40,40,20,10};
        int[] aliceArray = new int[]{5,25,50,120};
        //System.out.println(Arrays.toString();
        System.out.println(Arrays.toString(climbingTheLeaderboard(scoreList,aliceArray)));
    }
}

