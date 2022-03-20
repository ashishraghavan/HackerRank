/**
 * Not yet submitted,
 * tested for all below cases except for L after removing spaces = perfect square (81,25 etc...)
 */
public class Encryption {
    public static void main(String[] args) {
        //"if man was meant to stay on the ground god would have given us roots"
        //"haveaniceday"
        //"feedthedog"
        //"chillout"
        //"vsmejghtukjklwoaglqa vsmejghtukjklwoaglqa vsmejghtukjklwoaglqa vsmejghtukjklwoaglqab"
        //"bqepfnwndcdbaibfftha bqepfnwndcdbaibfftha bqepfnwndc"
        System.out.println(encryption("ab"));
    }

    static String encryption(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.trim();
        int L = 0;
        for (int i=0;i<s.length();i++) {
            if(!Character.isSpaceChar(s.charAt(i))) {
                L++;
                builder.append(s.charAt(i));
            }
        }
        s = builder.toString();
        double sqrt = Math.sqrt(L);
        int row = (int)Math.floor(sqrt);
        int col = (int)Math.ceil(sqrt);
        if((row * col) < L) {
            int max = Math.max(row,col);
            row = max;
            col = max;
        }
        int idx = 0, start = 0;
        int leftOver = L % col;
        String[] strArr = new String[row];
        for(int i = 0; i < row - 1; i++) {
            strArr[idx++] = s.substring(start,start+col);
            start += col;
        }
        //strArr[idx] = s.substring(start,start + (col - leftOver));
        builder.setLength(0);
        builder.append(s.substring(start));
        if(builder.length() != col) {
            //last string length is less than col, append 0?
            builder.append("0".repeat(Math.max(0, col - leftOver)));
        }
        strArr[idx] = builder.toString();
        builder.setLength(0);
        for(int i = 0; i< col; i++) {
            for(int j = 0; j<row;j++) {
                if(strArr[j].charAt(i) != '0') {
                    builder.append(strArr[j].charAt(i));
                }
            }
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
