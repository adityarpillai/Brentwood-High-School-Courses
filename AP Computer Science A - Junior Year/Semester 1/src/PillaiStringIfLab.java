import javax.swing.*;
import java.awt.*;

public class PillaiStringIfLab {

    public static void main(String[] args) {
        int repeat = 0;
        while (repeat == 0) {
            System.out.println("Repeat is: ");
            try {
                Object[] options = {"Exit", "StringRipper", "Social Security Chomper"};
                Component frame = null;
                int choice = JOptionPane.showOptionDialog(null, "Choose one of the two programs",
                        "Program Selector", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                System.out.println(choice);
                if (choice == 1) { //String Ripper
                    String strEntered = JOptionPane.showInputDialog("Enter the string to be ripped: ");
                    int firstIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the first index: "));
                    int lastIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the second index: "));
                    JOptionPane.showMessageDialog(null, "The ripped string is: " + ripString(strEntered, firstIndex, lastIndex));
                }
                if (choice == 2) {//Social Security Chomper
                    String strEntered = JOptionPane.showInputDialog("Enter the SS# to be chomped: ");
                    JOptionPane.showMessageDialog(null, "SS#: " + strEntered + " has a total of " + chompSS(strEntered));
                } else if (choice == 0) {
                    repeat = 1;
                }
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }
    }

    private static String chompSS(String strEntered) {
        try {
            int firstBreak = strEntered.indexOf("-");
            int lastBreak = strEntered.lastIndexOf("-");
            int firstNumber = Integer.parseInt(strEntered.substring(0, firstBreak));
            int middleNumber = Integer.parseInt(strEntered.substring(firstBreak + 1, lastBreak));
            int lastNumber = Integer.parseInt(strEntered.substring(lastBreak + 1, strEntered.length()));
            int result = firstNumber + middleNumber + lastNumber;
            return "" + result;
        } catch (Exception e) {
            return "Error";
        }
    }


    private static String ripString(String strEntered, int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && strEntered.length() > lastIndex) {
            return strEntered.substring(firstIndex, lastIndex + 1);
        } else return "Error in Input";
    }

}
