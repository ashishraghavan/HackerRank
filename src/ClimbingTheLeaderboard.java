import java.io.IOException;
import java.util.*;

public class ClimbingTheLeaderboard {

    // Complete the migratoryBirds function below.
    static int[] climbingTheLeaderboard(List<Integer> leaderBoardPlayers,List<Integer> aliceList) {
        int[] result =  new int[aliceList.size()];
        Collections.sort(leaderBoardPlayers,Collections.<Integer>reverseOrder());
        List<Score> leaderScores = new ArrayList<>(leaderBoardPlayers.size());
        int rank = 1;
        int index = 0;
        //Insert the first maximum player with score as rank 1.
        leaderScores.add(index,new Score(leaderBoardPlayers.get(0),rank));
        //Iterate over other players and assign rank accordingly.
        for(int i=1;i<leaderBoardPlayers.size();i++)  {
            if(leaderBoardPlayers.get(i).equals(leaderBoardPlayers.get(i-1))) {
                leaderScores.add(i,new Score(leaderBoardPlayers.get(i),leaderScores.get(i-1).getRank()));
            } else if(leaderBoardPlayers.get(i) < leaderBoardPlayers.get(i-1)){
                //increase rank by 1 and add to leaderScores list
                leaderScores.add(i,new Score(leaderBoardPlayers.get(i),leaderScores.get(i-1).getRank() + 1));
            }
        }

        // 1  2  3  4  5  6
        //100,90,90,80,75,60
        //50,65,77,90,102
        //102,90,77,65,50
        for(int i=0;i<aliceList.size();i++) {
            int j;
            for (j = 0; j < leaderScores.size() + i;j++) {
                //If alice list score is not greater than leader board score list item
                if(!(aliceList.get(i) > leaderScores.get(j).getScore())) {
                    continue;
                } else {
                    if(aliceList.get(i) == leaderScores.get(j).getScore()) {
                        //If scores are equal, rank is equal
                        //Get the score object
                        Score equalScore = new Score(aliceList.get(i));
                        leaderScores.add(j,equalScore);
                        //Set the rank
                        int equalRank = leaderScores.get(j-1).getRank();
                        equalScore.setRank(equalRank);
                        result[i] = equalRank;
                    } else {
                        //Get the score first
                        Score greaterScore = new Score(aliceList.get(i));
                        //Add the score to the leaderBoardScores list
                        leaderScores.add(j,greaterScore);
                        //Set the rank
                        int greaterRank = leaderScores.get(j-1).getRank() + 1;
                        greaterScore.setRank(greaterRank);
                        result[i] = greaterRank;
                    }
                    break;
                }
            }
            if(j == leaderScores.size()) {
                //Insert element at the end of the list
                Score leaderScore = new Score(aliceList.get(i));
                leaderScores.add(j,leaderScore);
                int endRank = leaderScores.get(j-1).getRank() + 1;
                leaderScore.setRank(endRank);
                result[i] = endRank;
            }
        }
        //Assign rank 1 to the highest element.
        leaderScores.get(0).setRank(1);
        for(int i = 1;i<leaderScores.size();i++) {
            if(leaderScores.get(i).getScore() == leaderScores.get(i-1).getScore()) {
                leaderScores.get(i).setRank(leaderScores.get(i-1).getRank());
            } else if(leaderScores.get(i).getScore() < leaderScores.get(i-1).getScore()) {
                leaderScores.get(i).setRank(leaderScores.get(i-1).getRank() + 1);
            }
        }
        //Final calculation about alice scores.
        return result;
    }

    static class Score {
        private int score;
        private int rank;

        public Score(int score,int rank) {
            this.rank = rank;
            this.score = score;
        }

        public Score(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public int getRank() {
            return rank;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> scoreList = new ArrayList<>();
        Collections.addAll(scoreList,100,90,90,80,75,60);
        List<Integer> aliceArray = new ArrayList<>();
        Collections.addAll(aliceArray,50,65,77,90,102);
        System.out.println(Arrays.toString(climbingTheLeaderboard(scoreList,aliceArray)));
    }

    //Loop over each element of alice list
    //for each element (i) of alice list
    //  for each element of leaderboardplayers
    //      if(alice list -> i > leaderboardplayers -> j) {
    //          arraylist.add(j,alicelist -> i)
    //          result[count++] = j;
}

