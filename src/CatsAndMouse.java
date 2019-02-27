import java.io.IOException;

public class CatsAndMouse {

    /**
     * @param catAPosition  The positive position of the cat A
     * @param catBPosition  The positive position of cat B
     * @param mousePosition The positive position of the mouse
     * @return Cat A or Cat b, whoever reaches the mouse first, or mouse if both cats reach the mouse at the same time
     */
    static String catAndMouse(int catAPosition, int catBPosition, int mousePosition) {
        int catAMouseDifference = Math.abs(catAPosition - mousePosition);
        int catBMouseDifference = Math.abs(catBPosition - mousePosition);
        if (catAMouseDifference < catBMouseDifference) {
            return "Cat A";
        } else if (catAMouseDifference > catBMouseDifference) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(catAndMouse(1, 3, 2));
    }
}
