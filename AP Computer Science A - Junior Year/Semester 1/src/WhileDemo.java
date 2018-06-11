public class WhileDemo {

    public static void main(String[] args) {
        //while loops repeat code until the condition is false
        //while(some condition){
        //	some code being executed
        //} end while

        //create a program to add up the digits of a number
        int num = 3937058;
        int total = 0;
        while (num != 0) {
            total += (num % 10);
            num /= 10;
        }
        System.out.print(total);

        //reverse the number;
        num = 3937058;
        total = 0;
        while (num != 0) {
            total *= 10;
            total += (num % 10);
            num /= 10;
        }
    }

}
