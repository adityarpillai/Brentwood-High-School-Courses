package RomanNumeral;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by adityapillai on 1/23/17.
 * Roman Numeral runner
 */
public class PillaiRomanNumeralRunner {

    public static void main(String[] args) {
        int repeat = 1;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter 1 to exit the program and 0 to enter.");
            if (scan.hasNextInt()) {
                repeat = scan.nextInt();
                if (repeat == 0) {
                    runProgram();
                }
            } else {
                System.out.println("Not a number.");
                scan.next();
            }

        } while (repeat == 1);
    }

    private static void runProgram() {
        //asks for values
        Scanner scan = new Scanner(System.in);
        int testCases = 0;

        //ensures entered value is an integer
        while (testCases == 0) {
            System.out.println("Enter the number of numbers you're entering.");
            if (scan.hasNextInt()) {
                testCases = scan.nextInt();
            } else {
                System.out.println("Not a number.");
                scan.next();
            }
        }

        //after number of numbers entered, will create an arraylist and ask for each individual number
        ArrayList<PillaiRomanNumeral> arr = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            System.out.println("Enter number " + (i+1) + ".");
            if (scan.hasNextInt()) {
                arr.add(new PillaiRomanNumeral(scan.nextInt()));
            } else{
                System.out.println("Not a number.");
                i--;
                scan.next();
            }

        }

        //starts to display values to user

        //displays numbers
        System.out.println("Numbers:");
        for (int i = 0; i < arr.size()-1; i++) {
            System.out.print(arr.get(i).getNumber() + ", ");
        }
        System.out.println(arr.get(arr.size() - 1).getNumber());

        //displays roman numerals
        System.out.println("Roman Numerals:");
        for (int i = 0; i < arr.size()-1; i++) {
            System.out.print(arr.get(i).getRomanNumeral() + ", ");
        }
        System.out.println(arr.get(arr.size() - 1).getRomanNumeral());

        //sorts, then displays roman numerals
        sort(arr);
        System.out.println("Sorted Roman Numerals:");
        for (int i = 0; i < arr.size()-1; i++) {
            System.out.print(arr.get(i).getRomanNumeral() + ", ");
        }
        System.out.println(arr.get(arr.size() - 1).getRomanNumeral());

        //then, if any one of the numbers they entered was more than 4k, will tell them the special case for numbers greater than 4k
        if (arr.get(arr.size() - 1).getNumber() >= 4000) {
            System.out.println("Note: Multiply Roman Numerals in Parentheses by 10000.");
        }

    }

    private static void sort(ArrayList<PillaiRomanNumeral> list) {
        //uses sorting algorithm, goes through first number and moves it to its correct place, then goes to the next one and so on.
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    PillaiRomanNumeral temp = new PillaiRomanNumeral(list.get(i).getNumber());
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

    }

}
