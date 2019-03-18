import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int pageCount, int pageToFetch) {
        int minPageNo = Integer.MAX_VALUE;
        for(int times=0;times<pageCount;times++) {
            List<Integer> noOfPages = new ArrayList<>();
            int firstPage = times * 2;
            int secondPage = firstPage + 1;
            noOfPages.add(firstPage);
            noOfPages.add(secondPage);
            if(noOfPages.contains(pageToFetch)) {
                if(times < minPageNo) {
                    minPageNo = times;
                }
            }
        }
        //If page count is odd
        if(pageCount % 2 != 0) {
            int times = 0;
            int pageNoCount = 0;
            List<Integer> pageCountList = new ArrayList<>();
            pageCountList.add(pageCount);
            pageCountList.add(pageCount - 1);
            while(pageNoCount != pageToFetch && (pageNoCount <= pageCount)) {
                pageCountList.add(pageCount - (times * 2));
                pageCountList.add(pageCount - ((times * 2)+1));
                if(pageCountList.contains(pageToFetch)) {
                    if(times < minPageNo) {
                        minPageNo = times;
                    }
                }
                pageNoCount++;
                times++;
            }
        }
        //If page count is even
        if(pageCount %2 == 0) {
            int times = 0;
            int pageNoCount = 0;
            List<Integer> pageCountList = new ArrayList<>();
            pageCountList.add(pageCount);
            while(pageNoCount != pageToFetch && (pageNoCount <= pageCount)) {
                pageCountList.add(pageCount - times);
                pageCountList.add(pageCount - times - 1);
                if(pageCountList.contains(pageToFetch)) {
                    if(times < minPageNo) {
                        minPageNo = times;
                    }
                }
                pageNoCount++;
                times++;
            }
        }
        return minPageNo;
    }

    public static void main(String[] args) throws IOException {//83246    //78132
        System.out.println("The minimum page count is "+pageCount(83246, 78132));
    }
}

