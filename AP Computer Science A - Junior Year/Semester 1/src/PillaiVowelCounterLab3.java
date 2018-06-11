import javax.swing.*;

/**
 * Created by Aditya Pillai on 9/16/16
 * Pillai Vowel Counter Lab
 */
public class PillaiVowelCounterLab3 {

    public static void main(String[] args) {
        //just keeping it small in main
        repeatableMethod();
        System.exit(0);
    }//end of main

    private static void repeatableMethod() {

        //options for JOptionPane.showOptionDialog
        Object[] optionsForMenu = {"Exit", "Enter"};
        int choice;

        //while loop for program
        do {
            choice = JOptionPane.showOptionDialog(null, "Do you want to use PillaiVowelCounter?", "Pillai Vowel Counter Lab",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsForMenu, optionsForMenu[1]);
            if (choice == 0)
                break; //choice of '0' is the "Exit" option, break needed to not run code below w/o if statement
            //if choice isn't 0, then the program can run as below
            String userInput = JOptionPane.showInputDialog("Enter the string:");
            JOptionPane.showMessageDialog(null, "The result of " + userInput + " is " + vowelCounter(userInput));
        } while (choice == 1);
    }

    private static String vowelCounter(String userInput) {
        //basically, go through each character of the string. if it's a vowel, then change it. use a bool for t/f
        int stringLength = userInput.length();
        int lengthCounter = 0;
        int vowelCounter = 0;
        String result = "";
        while (lengthCounter < stringLength) {
            //if statement check if vowel is true at that specified index
            if (checkVowel(userInput.charAt(lengthCounter))) {
                if (vowelCounter == 10) vowelCounter = 0;
                result += vowelCounter;
                vowelCounter++;
                //if it's true, then it adds on the vowelCounter number to the string then adds 1 to vowel counter
            } else result += userInput.charAt(lengthCounter); //otherwise, it just adds what was existing.
            lengthCounter++; //then moves on to the next index
        }
        return result; //returns solution after string finished
    }

    private static boolean checkVowel(char c) {
        String str = ("" + c).toLowerCase(); //converts to lower case just to simplify code. doesn't modify actual string.
        return str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u"); //returns a true/false. if true, lowercase doesn't matter,
        //if false, then it just returns false, so the program can use the orig letters
    }


}//end of class
