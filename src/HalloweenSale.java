public class HalloweenSale {
    public static void main(String[] args) {
        //20,3,6,80
        System.out.println(howManyGamesII(55,7,13,9864));
    }

    //p = starting price of game
    //d = decrease in price of each game after first
    //m = price after p < m
    //s = total starting units available to buy games
    /*
    * amount = 70
    * pricePerGame = 20
    * d = decrease in price per game after first = 3
    * m = price after pricePerGame < m = 6
    * 20 > 6 && 70 >= 20 : amount = 50, games = 1, pricePerGame = 17
    * 17 > 6 && 50 >= 17 : amount = 33, games = 2, pricePerGame = 14
    * 14 >= 6 && 37 >= 14 : amount = 19, games = 3, pricePerGame = 11
    * 11 >= 6 && 23 >= 11 : amount = 8, games = 4, pricePerGame = 8
    * 8 >= 6 && 8 >= 8 : amount = 0, games = 5, pricePerGame = 5
    * 5 !>= 6
    * amount < pricePerGame return games = 5
    *
    * 1 <= m <= p <= 100
    * 1 <= d <= 100
    * 1 <= s <= 10000
    * 55,7,13,9864
    * */
    static int howManyGamesII(int p, int d, int m, int s) {
        int amount = s;
        int pricePerGame = p;
        int games = 0;
        while(pricePerGame >= m && amount >= pricePerGame) {
            amount -= pricePerGame;
            games++;
            pricePerGame -= d;
        }
        if(amount < pricePerGame) {
            return games;
        }
        while(amount >= m) {
            amount -= m;
            games++;
        }
        return games;
    }
}
