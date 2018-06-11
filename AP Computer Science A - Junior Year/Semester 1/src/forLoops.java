@SuppressWarnings("SpellCheckingInspection")
public class forLoops {

    public static void main(String[] args) {
        /* for loops are tools that we can use to repeat blocks of code
		 * while a given condition is met
		 * Typical template:
		 * for(int i = startvalue; i<>==startvalue; i++/i--){
		 * 		code that you want executed
		 	} */
		
		/* create a program that adds up the even numbers from 0 to 100 
		 * Example 1: Check if even w/ mod
		 * Example 2: Just count by 2
		 */
        int total = 0;
        System.out.println("Example 1:");
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(total + ", ");
                total += i;
            }
        }
        System.out.println("\n" + total);

        total = 0;
        for (int i = 0; i <= 100; i += 2) {
            System.out.print(total + ", ");
            total += i;
        }

        System.out.println("\n" + total);

        //creates a program that prints every other character in a string
        String truth = "I love computer science with Coach Sanford.";
        String result = "";
        for (int i = 0; i < truth.length(); i += 2) {
            result += truth.charAt(i);
        }
        System.out.println(result);

    }

}
