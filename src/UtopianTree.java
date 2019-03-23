import java.io.IOException;

public class UtopianTree {

    // Complete the utopianTree function below.
    static int utopianTree(int growthCycles) {
        //assume i = 0;
        int i;
        //when i =0, treeHeight is 1
        int treeHeight = 1;
        if(growthCycles == 0) {
            return treeHeight;
        }
        for(i = 1;i <=growthCycles; i++) {
            int temp;
            //2 growth cycles.
            //1st growth cycle, the tree doubles in size
            //second growth cycle, the tree increase by 1 meter.
            //If it's odd cycle, it will be treeHeight * 2
            //If it's even cycle, it will be treeHeight + 1
            if(i % 2 != 0) {
                temp = treeHeight * 2;
            } else {
                temp = treeHeight + 1;
            }
            treeHeight = temp;
        }
        return treeHeight;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(utopianTree(4));
    }
}

