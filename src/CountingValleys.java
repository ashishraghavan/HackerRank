public class CountingValleys {

    // Complete the countingValleys function below.
    private static int countingValleys(int n, String s) {

        char[] charCount = s.toCharArray();
        int valleyCount = 0;
        int currLevel = 0;
        for(int i=0;i<n;i++) {
            if(charCount[i] == 'U' || charCount[i] == 'u') {
                currLevel++;
            } else if(charCount[i] == 'D' || charCount[i] == 'd') {
                currLevel--;
            }
            if(currLevel == 0 && (charCount[i] == 'U' || charCount[i] == 'u')) {
                valleyCount++;
            }
        }
        return valleyCount;
    }

    public static void main(String[] args) {
        System.out.println("The valley count is "+countingValleys(12,"DDUUDDUDUUUD"));
    }
}