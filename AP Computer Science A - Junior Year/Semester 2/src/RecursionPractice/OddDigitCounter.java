package RecursionPractice;

import java.util.Scanner;

/**
 * Created by adityapillai on 2/7/17.
 * Odd Digit Counter APCS
 */
public class OddDigitCounter {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.close();
        int num = 2354875;

        //noinspection ConstantConditions
        if (num < Integer.MAX_VALUE) {
            int result = oddCounter(num);
            System.out.println("The number of odd digits in " + num + " is " + result);
        } else {
            System.out.println("Larger than integer value.");
        }

    }

    //return the number of odd digits in an integer
    //strategy: beginning -> end
    //other strategy: end -> beginning
        //start at the ones digit, and count from there
    private static int oddCounter(int num) {
        //EXIT CONDITION


        if (num == 0) {
            return 0;
        }

        //RECURSIVE STATEMENT
        //Algorithm:
        //  1. Get the ones digit
        //  2. Is it odd or even?
        //    a) if odd, add to sum count
        //    b) if even, don't add
        // oddCounter(num) = oddCounter(num/10) + (0 or 1 depending on odd)

        int ones = num % 10;
        if (ones % 2 != 0) {
            return oddCounter(num/10) + 1;
        } else {
            return oddCounter(num / 10);
        }

        /* FIRST CALL OF 2354875
         * Calls oddCounter of 2354875
         * Calls oddCounter of 235487
         * Calls oddCounter of 23548
         * Calls oddCounter of 2354
         * Calls oddCounter of 235
         * Calls oddCounter of 23
         * Calls oddCounter of 2
         * Calls oddCounter of 0
         *
         * REACHED ESCAPE LOGIC:
         * => oddCounter of 0 returns 0
         *
         * RETURNS BACK THROUGH RECURSIONS:
         * => oddCounter of 2 returns 0
         * => oddCounter of 23 returns 1
         * => oddCounter of 235 returns 2
         * => oddCounter of 2354 returns 2
         * => oddCounter of 23548 returns 2
         * => oddCounter of 235487 returns 3
         * => oddCounter of 2354875 returns 4
         */
    }

}
