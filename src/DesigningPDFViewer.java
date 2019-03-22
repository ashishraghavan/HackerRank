
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DesigningPDFViewer {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] alphabetHeightArray, String word) {
        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        int count = 0;
        for(char c = 'a';c<='z';c++) {
            characterIntegerMap.put(c,alphabetHeightArray[count++]);
        }
        char[] wordChar = word.toCharArray();
        int maxCharValue = Integer.MIN_VALUE;
        for(char x : wordChar) {
            int charValue = characterIntegerMap.get(x);
            if(charValue > maxCharValue) {
                maxCharValue = charValue;
            }
        }
        //Once we find the max char value, we multiple it by number of characters in the word
        //and find the area.
        return maxCharValue * wordChar.length;
    }

    public static void main(String[] args) throws IOException {
        String input = "1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5";
        String[] splitInput = input.split(" ");
        StringBuilder inputBuilder = new StringBuilder();
        for(String number : splitInput) {
            inputBuilder.append(number).append(",");
        }
        System.out.println(inputBuilder.toString().substring(0,inputBuilder.length() - 1));
        int[] alphabetHeightArray = new int[]{1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        String word = "abc";
        System.out.println(designerPdfViewer(alphabetHeightArray,word));

    }
}

