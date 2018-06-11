import java.util.Scanner;

/**
 * Created by Aditya Pillai on 9/27/16.
 * String Chopper Lab to Learn About Cutting Strings w/ Scanner
 * APCS Aditya Pillai
 */
public class PillaiStringChopperDogFoodLab {


    public static void main(String[] args) {

        //Scanner for while loop, repeats whether or not user wants to use the program
        Scanner scChoice = new Scanner(System.in);
        String choice;

        //do-while ensures the program runs at least once.
        do {
            System.out.println("Press \"1\" if you want to enter.");
            System.out.println("Press any other key to exit.");
            choice = scChoice.nextLine();
            if (!choice.equals("1")) break;
            runProgram();
        } while (choice.equals("1"));  //if they enter anything other than "1", then the program will exit

        //confirmation for end of main method
        System.out.println("Program exited.");


    }//end of main

    private static void runProgram() { //actual "main" method after the loop, doesn't return anything, just runs once

        //asks for user input. cleaner than having separate scanner here.
        String input = getUserInput();

        //Scanner to chop up the input string
        Scanner scInput = new Scanner(input);
        scInput.useDelimiter(", "); //comma space makes the entry easier to read

        //initializes two variables at zero, will add up from here
        int weekCount = 0; //tells user how many weeks they have entered in correctly
        double totalFood = 0;

        //while loop that checks if the integer has a next int, then proceeds to calculate
        while (scInput.hasNextInt()) {
            weekCount++; //week counter to tell the user how many inputs have been accounted for
            totalFood += (convertValues(scInput.nextInt(), weekCount)) * 7; //*7 for cups per week rather than per day
            //adds on calculations to total food. also prints out specific for the week in convertValues
        }

        System.out.println("Total Cups = " + totalFood); //after every week has been accounted for, while loop ends, prints out total

        System.out.println("You will need to buy " + getBagInt(totalFood) + ", 10 lb bags of food for " +
                weekCount + " weeks.\n\n"); //tell user, end runProgram(), leave extra space
    }//end of runProgram()

    private static int getBagInt(double totalFood) {
        //input: totalFood Necessary
        //output: bags necessary based off total food w/ 60cups per 10lb bag
        if (totalFood % 60 == 0) {
            return (int) totalFood / 60;
        }
        return (int) ((totalFood / 60) + 1);
    }//end of getBagInt()

    private static double convertValues(int i, int weekCount) {
        //input:
        //int i: weight at certain week
        //int weekCount: what week it is (needed to print out specifics)

        //2 functions
        //1: Prints out the week and cups needed for that week
        //2: Returns numbers of cups needed for a specific weight to add on to total for main method
        double cupsForWeight = returnCupsNeeded(i);
        System.out.println("Week " + weekCount + " at " + i + " lbs -> " + cupsForWeight + " cups of dog food.");
        return cupsForWeight;
    }//end of ConvertValues

    private static double returnCupsNeeded(int weight) {
        //input: weight of dog
        //output: (double) cups needed for that weight
        if (weight >= 2 && weight <= 4) {
            return 0.5;
        }
        if (weight >= 5 && weight <= 7) {
            return 1.0;
        }
        if (weight >= 8 && weight <= 9) {
            return 1.5;
        }
        if (weight >= 10 && weight <= 19) {
            return 2.0;
        }
        if (weight >= 20 && weight <= 39) {
            return 3.5;
        }
        if (weight >= 40 && weight <= 59) {
            return 4.5;
        }
        if (weight >= 60 && weight <= 79) {
            return 6.0;
        }
        if (weight >= 80) {
            return 7.5;
        }
        return 0;

    }//end of ConvertCupsNeeded


    private static String getUserInput() {
        //input: none
        //output: User Entered String

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the weight of the puppy for any number of weeks separated by a comma and space, \n" +
                "EX: X, X, X, X, X, X");
        return userInput.nextLine();
    }//end of GetUserInput

}//end of class

