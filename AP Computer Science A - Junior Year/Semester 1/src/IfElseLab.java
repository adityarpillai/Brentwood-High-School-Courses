public class IfElseLab {

    //The purpose of this lab is to demonstrate the use of
    //if statements, if/else statements, and nested if/else statements
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        int num = 59;

        //Basic if statement
        //noinspection ConstantConditions
        if (num > 50) {
            System.out.println("Num is big.");
        }

        //Nested if and if/else statement
        //noinspection ConstantConditions
        if (num < 100) {
            if (num % 2 != 0) {
                System.out.println("Num is odd but not too big.");
            }//end of if
            else {
                System.out.println("Num is even but not too big.");
            }//end of else
        }//end of if

        int bob = 24;

        if (bob % 2 == 0) {
            System.out.println("Bob is a multiple of 2.");
        } else if (bob % 3 == 0) {
            System.out.println("Bob is a multiple of 3.");
        } else if (bob % 5 == 0) {
            System.out.println("Bob is a multiple of 5.");
        } else {
            System.out.println("Bob is none of these.");
        }

        //switches
        int month = 3;
        switch (month) {
            case 1:
                System.out.print("The month is January.");
                break;
            case 2:
                System.out.print("The month is February.");
                break;
            case 3:
                System.out.print("The month is March.");
                break;
            case 4:
                System.out.print("The month is April.");
                break;
            case 5:
                System.out.print("The month is May.");
                break;
            case 6:
                System.out.print("The month is June.");
                break;
            case 7:
                System.out.print("The month is July.");
                break;
            case 8:
                System.out.print("The month is August.");
                break;
            case 9:
                System.out.print("The month is September.");
                break;
            case 10:
                System.out.print("The month is October.");
                break;
            case 11:
                System.out.print("The month is November.");
                break;
            case 12:
                System.out.print("The month is December.");
                break;

            default:
                System.out.println("Not a month.");
                break;
        }


    }//end of main

}//end of IfElseLab class
