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

    public static void main(String[] args) throws IOException {
            System.out.println(saveThePrisoner(352926151,380324688,94730870));
    }
}
