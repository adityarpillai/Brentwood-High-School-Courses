package RecursionPractice;
/**
 * Created by adityapillai on 2/6/17.
 * factorials using recursion
 */
public class Factorial {

    public static void main(String[] args) {
        int num = 5;
        int result = factorial(num);
        System.out.println("The factorial of " + num + " is " + result);
    }

    private static int factorial(int num) {

        System.out.println("Calculating factorial of " + num);

        // exit condition is N == 0
        if (num == 0) {
            //0! is always 1
            System.out.println("Returning 1");
            return 1;
        }

        // recursively call factorial
        // with a smaller number (N­1)
        int smallerFactorial = factorial(num - 1);

        // return smaller factorial times this number N
        int thisFactorial = num * smallerFactorial;

        //once the factorial is completed, will return this multiplied by the next lowest factorial
        System.out.println("Returning " + thisFactorial);
        return thisFactorial;

    }

}