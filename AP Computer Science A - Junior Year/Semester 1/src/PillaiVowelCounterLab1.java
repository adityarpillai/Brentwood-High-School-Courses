import javax.swing.*;

/**
 * Created by aditya on 9/15/16.
 */
@SuppressWarnings("DefaultFileTemplate")
public class PillaiVowelCounterLab1 {


    public static void main(String[] args) {
        Object[] options = {"Exit", "Vowel Counter"};
        int repeat = 0;
        do {
            int choice = JOptionPane.showOptionDialog(null, "Run the Program or Exit", "VowelCounter", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (choice == 0) {
                repeat = 1;
            } else {
                String userEString = JOptionPane.showInputDialog("Enter your string:");
                JOptionPane.showMessageDialog(null, "The result is: " + countVowelsInString(userEString));
            }
        } while (repeat == 0);


    }


    private static String countVowelsInString(String userEString) {
        String lowerCaseString = userEString.toLowerCase();
        int i = 0;
        String result = "";
        int count = 0;
        while (i < lowerCaseString.length()) {
            if (changeVowelsToNumbers(lowerCaseString.charAt(i)).equals("-5")) {
                if (count == 10) {
                    count = 0;
                }
                result += count;
                count++;
            } else result += lowerCaseString.charAt(i);
            i++;
        }
        return result;
    }

    private static String changeVowelsToNumbers(char charAtValue) {

        if (charAtValue == 'a' || charAtValue == 'e' || charAtValue == 'i' || charAtValue == 'o' || charAtValue == 'u') {
            return "-5";
        }
        return "" + charAtValue;
    }


}
