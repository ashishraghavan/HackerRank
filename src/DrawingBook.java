import java.io.IOException;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int pageCount, int pageToFetch) {
        int forwardPageCount = 0;
        int backwardPageCount = 0;
        //forward page count starts
        int turns = 0;
        int currentPage = 1;
        if(currentPage == pageToFetch) {
            forwardPageCount = turns;
        }
        //current page will be 2 at this point
        //turns will be 2 at this point.
        //First time, we open the book, it will open page no 1
        //from second time onwards we keep opening the pages
        //till we reach the page that we want.
        int previousPage = currentPage;
        for(turns = turns + 1;turns<pageCount;turns++) {
            currentPage = previousPage + 1;
            int nextPage = currentPage + 1;
            if(currentPage == pageToFetch || nextPage == pageToFetch) {
                forwardPageCount = turns;
                break;
            }
            previousPage = nextPage;
        }

        //Backward page count starts
        turns = 0;
        //If page count is odd,
        if(pageCount %2 != 0) {
            currentPage = pageCount - 1;
        } else {
            currentPage = pageCount;
        }
        int previousPageBackward;
        if(currentPage == pageToFetch) {
            backwardPageCount = turns;
        } else {
            int futurePage = currentPage;
            for(turns = turns + 1;turns<pageCount;turns++){
                previousPageBackward = futurePage - 1;
                currentPage = previousPageBackward - 1;
                if(currentPage == pageToFetch || previousPageBackward == pageToFetch) {
                    backwardPageCount = turns;
                    break;
                }
                futurePage = currentPage;
            }
        }

        return Math.min(forwardPageCount,backwardPageCount);
    }

    public static void main(String[] args) throws IOException {//83246    //78132
        System.out.println("The minimum page count is "+pageCount(83246, 78132));
    }
}

