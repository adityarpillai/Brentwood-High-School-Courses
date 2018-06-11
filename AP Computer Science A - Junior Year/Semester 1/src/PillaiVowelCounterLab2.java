import javax.swing.*;

/**
 * Created by Aditya Pillai on 9/15/16.
 * hi
 */
public class PillaiVowelCounterLab2 {

    public static void main(String[] args) {

        //Menu Method
        Object[] options = {"Exit", "Vowel Counter"};
        int repeat = 0;
        do {
            int choice = JOptionPane.showOptionDialog(null, "Run the Program or Exit", "VowelCounter", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (choice == 0) {
                repeat = 1;
                System.out.println("Program closing...");
            } else {
                String userEString = JOptionPane.showInputDialog("Enter your string:");
                JOptionPane.showMessageDialog(null, "The result is: " + countVowelsInString(userEString));
            }
        } while (repeat == 0);


    }

    private static String countVowelsInString(String userEString) {
        String lowerCaseString = userEString.toLowerCase();
        int count = 0;
        int vowelCount = 0;
        String result = "";
        while (count < lowerCaseString.length()) {
            if (checkVowelAt(lowerCaseString.charAt(count))) {
                if (vowelCount == 10) vowelCount = 0;
                result += vowelCount;
                vowelCount++;
            } else {
                result += lowerCaseString.charAt(count);
            }
            count++;
        }
        return result;
    }

    private static boolean checkVowelAt(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
