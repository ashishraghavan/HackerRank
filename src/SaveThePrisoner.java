import java.io.IOException;

public class SaveThePrisoner {

    // Complete the saveThePrisoner function below.
    // 1 < numberOfPrisoners < 10 ^ 9
    // 1 < numberOfSweets    < 10 ^ 9
    //      1 <= s <= n
    // no of prisoners = 4, start = 2, when reach 4 reset back to 1 i.e 4 - 4 + 1 = currentIndex - prisonerNo + 1
    // 100 - 50
    static int saveThePrisoner(int numberOfPrisoners, int numberOfSweets, int startingChairNumber) {
        //remainderSweets is the number of sweets left after distributing to all the prisoners.
        Long remainderSweets = 0L;
        Long _numberOfPrisoners = (long) numberOfPrisoners;
        Long initialSweets = 0L;
        Long currentPrisonerIndex = (long)startingChairNumber;
        Long _numberOfSweets = (long)numberOfSweets;
        boolean isNumberOfSweetsMore = false;
        if(_numberOfSweets > _numberOfPrisoners) {
            isNumberOfSweetsMore = true;
            remainderSweets = _numberOfSweets % _numberOfPrisoners;
        }
        Long warningPrisoner;
        if(isNumberOfSweetsMore) {
            for(initialSweets = 1L;initialSweets <= numberOfSweets;initialSweets++) {
                if(currentPrisonerIndex == numberOfPrisoners) {
                    //set the currentPrisonerIndex to roll over to
                    //the first value.
                    currentPrisonerIndex = currentPrisonerIndex - _numberOfPrisoners + 1;
                } else {
                    currentPrisonerIndex++;
                }
            }
            //Because we are incrementing the value of currentPrisonerIndex after the last operation.
            warningPrisoner = currentPrisonerIndex -1 + remainderSweets;
        } else {
            while(_numberOfSweets > 0) {
                if(currentPrisonerIndex == numberOfPrisoners) {
                    //set the currentPrisonerIndex to roll over to
                    //the first value.
                    currentPrisonerIndex = currentPrisonerIndex - numberOfPrisoners + 1;
                } else {
                    currentPrisonerIndex++;
                }
                _numberOfSweets--;
            }
            warningPrisoner = currentPrisonerIndex - 1;
        }
        //start distributing from array index startingChairNumber.
        return warningPrisoner.intValue();
    }

    //cnt = 384, curr = 94731253
    //4294967295
    //2147483648
    //1000000000
    //499999999 999999997 2
    //499999999 999999998 2
    //999999999 999999999 1
    static int saveThePrisonerUpdated(int n, int m, int s) {
        long cnt = 1,curr = s;
        while(cnt < m) {
            if(curr > n) {
                curr = 1;
                continue;
            }
            cnt++;
            curr++;
            //System.out.println("cnt = "+cnt+", curr = "+curr);
        }
        return (int)curr;
    }

    public static void main(String[] args) throws IOException {
        //352926151,380324688,94730870
        //4,6,2
        //5,2,1
        //5,2,2
        //7,19,2
        //3,7,3
        //499999999, 999999997, 2 - 499999999
        //499999999, 999999998, 2 - 1
        //999999999 999999999 1 - 999999999
        System.out.println(saveThePrisonerUpdated(499999999, 999999998, 2));
    }
}
