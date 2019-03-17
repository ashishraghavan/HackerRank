    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;
    import java.io.IOException;
    import java.math.BigInteger;
    import java.util.ArrayList;
    import java.util.List;

    public class BonAppetit {

        // Complete the bonAppetit function below.
        static void bonAppetit(List<Integer> billList, Integer avoidedItemIndex, Integer chargedToAnna) {
            List<BigInteger> billListBigInteger = new ArrayList<>();
            for(Integer bill : billList) {
                billListBigInteger.add(BigInteger.valueOf(bill));
            }
            BigInteger avoidedItem = BigInteger.valueOf(billList.get(avoidedItemIndex));
            BigInteger annasCharge = BigInteger.valueOf(chargedToAnna);
            BigInteger sum = BigInteger.ZERO;
            for(int i=0;i<billListBigInteger.size();i++) {
                if(i != avoidedItemIndex) {
                    sum = sum.add(billListBigInteger.get(i));
                }
            }
            //Since there are only two people
            BigInteger split = sum.divide(BigInteger.valueOf(2));
            if(split.equals(annasCharge)) {
                System.out.println("Bon Appetit");
            } else {
                System.out.println(annasCharge.subtract(split).intValue());
            }
        }

        public static void main(String[] args) throws IOException {
            List<Integer> billList = new ArrayList<>();
            File inputFile = new File("BonAppettitTestCase");
            if(!inputFile.exists()) {
                System.out.println("FIle not found, can't continue, exiting");
                return;
            }
            String line;
            BufferedReader fileBufferedReader = new BufferedReader(new FileReader(inputFile));
            while((line = fileBufferedReader.readLine()) != null) {
                String[] splitNumberString = line.split(",");
                for(String number : splitNumberString) {
                    billList.add(Integer.valueOf(number));
                }
            }
            bonAppetit(billList, 2814, 249990732);
        }
    }
