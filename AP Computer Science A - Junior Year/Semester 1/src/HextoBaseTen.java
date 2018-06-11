import javax.swing.*;


@SuppressWarnings("SpellCheckingInspection")
public class HextoBaseTen {

    public static void main(String[] args) {
        //noinspection InfiniteLoopStatement
        while (true) {
            String hexEntered = JOptionPane.showInputDialog("Enter your hexadecimal number:");
            int finalAnswer = convertValuetoHex(hexEntered);
            JOptionPane.showMessageDialog(null, hexEntered + " in Base 10 is " + finalAnswer);
        }
    }//end of main method

    private static int convertValuetoHex(String hexEntered) {
        int finalDecimal = 0;
        for (int place = 0; place < hexEntered.length(); place++) {
            finalDecimal = singleDigitConversion(hexEntered, finalDecimal, place);
        }//end of for loop
        return finalDecimal;
    }//end of method convertValuetoHex

    private static int singleDigitConversion(String hexEntered, int finalDecimal, int place) {
        char p = hexEntered.toUpperCase().charAt(place);
        int power = hexEntered.length() - place - 1;
        int pInt = Character.getNumericValue(p);
        int singleValue = (int) Math.pow(16, power) * pInt;
        finalDecimal = finalDecimal + singleValue;
        return finalDecimal;
    }

}//end of class
