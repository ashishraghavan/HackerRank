public class HalloweenSale {
    public static void main(String[] args) {
        //20,3,6,80
        System.out.println(howManyGames(20 ,3, 6, 85));
    }

    //p = starting price of game
    //d = decrease in price of each game after first
    //m = price after p < m
    //s = total starting units available to buy games
    static int howManyGames(int p, int d, int m, int s) {
        int price = p,sum = 0, count = 0;
        while(price > m) {
            sum += price;
            if(sum > s) {
                return count;
            }
            count++;
            price -= d;
        }
        while((sum+m) < s) {
            count++;
            sum += m;
        }
        return count;
    }
}
