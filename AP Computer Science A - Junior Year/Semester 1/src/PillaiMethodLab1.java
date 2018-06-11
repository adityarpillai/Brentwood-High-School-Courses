import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PillaiMethodLab1 {

    public static void main(String[] args) {
        int repeat = 0;
        try {
            //noinspection ConstantConditions
            while (repeat == 0) {
                String chooseProgram = JOptionPane.showInputDialog("Enter which program you wish to use "
                        + "(Average, Rectangle, Slope): ");
                System.out.println("DEBUGGING: String entered for chooseProgram is " + chooseProgram);

                if (chooseProgram.equalsIgnoreCase("average")) {
                    averageValues();
                }//end of first if

                else if (chooseProgram.equalsIgnoreCase("rectangle")) {
                    rectangleValues();
                }//end of first else if

                else if (chooseProgram.equalsIgnoreCase("slope")) {
                    slopeValues();
                }//end of second else if

                else {
                    JOptionPane.showMessageDialog(null, "Error: Please re-enter one of the options.");
                }//end of else
            }//end of while loop
        } catch (Throwable e) {//end of try
            System.out.println("Closing program...");
        }

    }//end of main method

    private static void slopeValues() {
        try {
            String pointsEntered = JOptionPane.showInputDialog("Enter the points as: X1 Y1 X2 Y2");
            System.out.println("DEBUGGING: String entered for slopeValues is " + pointsEntered);
            Scanner pointsEnteredScanner = new Scanner(pointsEntered);
            double firstXValue = pointsEnteredScanner.nextDouble();
            double firstYValue = pointsEnteredScanner.nextDouble();
            double secondXValue = pointsEnteredScanner.nextDouble();
            double secondYValue = pointsEnteredScanner.nextDouble();
            BigDecimal slopeAnswer = new BigDecimal((secondYValue - firstYValue) / (secondXValue - firstXValue));
            slopeAnswer = slopeAnswer.setScale(2, RoundingMode.HALF_EVEN);
            //noinspection RedundantStringFormatCall
            JOptionPane.showMessageDialog(null, String.format("The slope between (" + firstXValue
                    + ", " + firstYValue + ") and (" + secondXValue + ", " +
                    secondYValue + ") is " + slopeAnswer));
            pointsEnteredScanner.close();
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Error in Input, returning to Program Select");
        }

    }//end of slopeValues

    private static void rectangleValues() {

        try {
            String sidesEntered = JOptionPane.showInputDialog("Enter the points as: Side1 Side 2");
            System.out.println("DEBUGGING: String entered for rectangleValues is " + sidesEntered);
            Scanner sidesEnteredScanner = new Scanner(sidesEntered);
            double firstSide = sidesEnteredScanner.nextDouble();
            double secondSide = sidesEnteredScanner.nextDouble();
            BigDecimal perimeter = new BigDecimal((2 * secondSide) + (2 * firstSide));
            perimeter = perimeter.setScale(2, RoundingMode.HALF_EVEN);
            JOptionPane.showMessageDialog(null, "A rectangle with sides of " +
                    firstSide + " and " + secondSide + " has a perimeter of " + perimeter + ".");
            sidesEnteredScanner.close();
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Error in Input, returning to Program Select");
        }
    }//end of rectangleValues

    private static void averageValues() {
        try {
            String doublesEntered = JOptionPane.showInputDialog("Enter the two vales as: Value1 Value2");
            System.out.println("DEBUGGING: String entered for rectangleValues is " + doublesEntered);
            Scanner doublesEnteredScanner = new Scanner(doublesEntered);
            double firstDouble = doublesEnteredScanner.nextDouble();
            double secondDouble = doublesEnteredScanner.nextDouble();
            BigDecimal averageOfTwo = new BigDecimal((firstDouble + secondDouble) / 2);
            averageOfTwo = averageOfTwo.setScale(2, RoundingMode.HALF_EVEN);
            //noinspection RedundantStringFormatCall
            JOptionPane.showMessageDialog(null, String.format("The average is " + averageOfTwo));
            doublesEnteredScanner.close();
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Error in Input, returning to Program Select");
        }
    }//end of averageValues


}//end of class
