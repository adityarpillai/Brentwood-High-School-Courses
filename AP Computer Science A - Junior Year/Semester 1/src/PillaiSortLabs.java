import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aditya Pillai on 10/18/16.
 * Sorter lab
 * APCS Period 3
 */
@SuppressWarnings("Duplicates")
public class PillaiSortLabs {

    public static void main(String[] args) {
        System.out.println("Enter 1 for the Number Sorter Lab, 2 for the Word Sorter Lab, and 3 to exit this program.");
        int i = 0;
        Scanner scan = new Scanner(System.in);
        while (i == 0) {
            //if there is an int
            if (scan.hasNextInt()) {
                i = scan.nextInt();
                scan.nextLine();
                if (i == 1) { //1 corresponds to number sorter
                    runNumberSorter();
                    break;
                }
                if (i == 2) { //2 corresponds to word sorter
                    runWordSorter();
                    break;
                }
                if (i == 3) break; //3 breaks program

                System.out.println("Error in input, retry.");
            } else { //if not an int, sets input = 0, reruns
                System.out.println("Error in input, retry.");
            }
        }

    }

    private static void runWordSorter() {
        Scanner scan = new Scanner(System.in);
        //asks for user input
        System.out.println("Enter the number of sentences you want to sort, or press 0 to exit.");
        int number = -5;
        //initial value for number is 5

        //unless number is changed, will continue to run program
        while (number == -5) {
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("\nError in input. Try Again.");
                scan.nextLine();
            }
        }

        //runs number of times the user asked
        for (int i = 0; i < number; i++) {
            sortArrays(scan.nextLine()); //goes through each sentence/line and sorts it, then moves on to next
        }
    }

    /**
     * @param str of string you wish to convert/sort to an array
     *            returns nothing. prints out sorted string with two spaces.
     */
    private static void sortArrays(String str) {

        //set array from string. split with a space
        String[] arr = str.split(" ");

        //Sort array and display foreach
        Arrays.sort(arr);
        for (String string : arr) {
            System.out.println(string);
        }

        //extra space
        System.out.println();
        System.out.println();
    }

    private static void runNumberSorter() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        System.out.println("Enter the number to sort all of it's digits.");
        //  Starts an infinite loop until they choose to exit by pressing an alternate number.
        while (number == 0) {
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("\nError in input. Try Again.");
                scan.nextLine();
            }
        }

        //gets an array
        int[] arr = sortNumbers(number);

        //sorts an array
        Arrays.sort(arr);

        //displays array separated by space
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * @param number input that is to be digitized
     * @return array that is every digit of the number in array form
     */
    private static int[] sortNumbers(int number) {
        //set array with checked length
        int[] arr = new int[length(number)];
        //noinspection SpellCheckingInspection
        int localnum = number;
        //will go through each digit adding it onto the array
        for (int i = 1; i <= length(number); i++) {
            int temp = localnum % 10;
            arr[length(number) - i] = temp;
            localnum = localnum / 10;
        }
        return arr;
    }

    /**
     * @param number input that will be counted
     * @return number of digits in param
     */
    private static int length(int number) {
        int count = 0;
        while (number / 10 > 0) {
            count++;
            number = number / 10;
        }
        count++;
        return count;
    }

}
