@SuppressWarnings("SpellCheckingInspection")
public class Mathmethods {

    public static void main(String[] args) {

        //Method: floor
        //Returns: double
        //Purpose: round the double parameter down to the nearest integer
        double f = 2.3;
        int fresult = (int) Math.floor(f);
        double fresult2 = Math.floor(2.3);
        System.out.println(f + " , " + fresult + " , " + fresult2);

        //Method: ceil
        //Returns: double
        //Purpose: round the double parameter up to the nearest integer
        fresult = (int) Math.ceil(f);
        fresult2 = Math.ceil(f);
        System.out.println(f + " , " + fresult + " , " + fresult2);

        //Method: pow
        //Returns: double
        //Purpose: return the first parameter to the power of the second
        fresult = (int) Math.pow(f, 3);
        fresult2 = Math.pow(f, 3);
        System.out.println(f + " , " + fresult + " , " + fresult2);


        //Method: abs
        //Returns: double
        //Purpose: return the absolute value of the parameter
        fresult = (int) Math.abs(-1 * f);
        fresult2 = Math.abs(-1 * f);
        System.out.println(-1 * f + " , " + fresult + " , " + fresult2);

        //Method: sqrt
        //Returns: double/int
        //Purpose: return the square root of the parameter
        fresult = (int) Math.sqrt(f);
        fresult2 = Math.sqrt(f);
        System.out.println(f + " , " + fresult + " , " + fresult2);

        //Method: round
        //Parameter: double
        //Returns: double
        //Purpose: round the parameter to the nearest integer
        fresult = (int) Math.round(f);
        fresult2 = Math.round(f);
        System.out.println(f + " , " + fresult + " , " + fresult2);

        //Method: min
        //Parameter: 2 int/double
        //Returns: double
        //Purpose: return the minimum of two numbers
        fresult = (int) Math.min(f, -7);
        fresult2 = Math.min(f, -7);
        System.out.println(f + " , " + fresult + " , " + fresult2);

        //Method: max
        //Parameter: 2 int/double
        //Returns: double
        //Purpose: return the maximum of two numbers
        fresult = (int) Math.max(f, -7);
        fresult2 = Math.max(f, -7);
        System.out.println(f + " , " + fresult + " , " + fresult2);

        //Math.random returns a double 0.0<=d<1.0
        //The formula to return a number in a given set x<=d<=y
        //y-x=z,  Math.random()*(z+2)+(x+1);
        //Lets try to find a Random Value between 2,8
        for (int i = 0; i <= 19; i++) {
            int result = (int) (Math.random() * 7 + 2);
            if (i < 19) {
                System.out.print(result + ", ");
            } else {
                System.out.print("and " + result + ".");
            }
        }

        //Try to find random values between -58 and 45
        double max = 0.0, min = 0.0;
        for (int i = 0; i < 10; i++) {
            int result = (int) Math.round((Math.random() * 103 - 58));
            max = Math.max(max, result);
            min = Math.min(min, result);
        }
        System.out.println("\nMax: " + max + ", Min: " + min);

    }//end of main method


}//end of class