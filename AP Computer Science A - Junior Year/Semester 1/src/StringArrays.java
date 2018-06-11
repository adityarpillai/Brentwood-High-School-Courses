import java.util.Arrays;

public class StringArrays {

    public static void main(String[] args) {
        String begin = "I love computer science...";
        begin = begin.toLowerCase();// may need to make lowercase to sort correctly
        String[] s = begin.split(" ");// split uses some identifier to separate words in a string and store them in an array
        for (String it : s) {
            System.out.println(it);
        }// printing out s
        Arrays.sort(s);// Arrays.sort(name) sorts the array and stores it in the same location
        System.out.println(Arrays.toString(s));// Arrays.toString(name) puts the array in a string format


        String numbers = "1?2?3?4?5?6?7?8?9";
        String[] arr = numbers.split("\\?");
        //We are going to find the average of these numbers
        int sum = 0;

        for (String anArr : arr) {
            sum += Integer.parseInt(anArr);
        }
        double avg = sum / arr.length;
        System.out.println("The average of " + Arrays.toString(arr) + " is " + avg + ".");

    }//end of args

}//end of StringArrays