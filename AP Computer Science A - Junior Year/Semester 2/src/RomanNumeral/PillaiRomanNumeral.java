package RomanNumeral;

public class PillaiRomanNumeral implements Comparable<PillaiRomanNumeral> {

    //will store number as integer for easy compareTo
    private Integer number;

    //String is stored as soon as initialized
    private String romanNumeral;

    PillaiRomanNumeral(int number) {
        this.number = number;
        romanNumeral = toRomanNumeral(number);
    }

    //will compare integers and return the integer difference
    public int compareTo(PillaiRomanNumeral romanNumeral) {
        return this.getNumber() - romanNumeral.getNumber();
    }

    private String toRomanNumeral(int number) {
        StringBuilder result = new StringBuilder();
        //if greater than 4k, will start out with a parentheses to note that you must multiply by 1000
        boolean greater4K = (number >= 4000);
        if (greater4K) {
            result.append("(");
        }

        //simple algorithm where it finds the largest number that will fit, subtracts, and continues until that large number no longer fits
        while (number >= 100000) {
            result.append("C");
            number -= 100000;
        }
        while (number >= 90000) {
            result.append("XC");
            number -= 90000;
        }
        while (number >= 50000) {
            result.append("L");
            number -= 50000;
        }
        while (number >= 40000) {
            result.append("XL");
            number -= 40000;
        }
        while (number >= 10000) {
            result.append("X");
            number -= 10000;
        }
        while (number >= 9000) {
            result.append("IX");
            number -= 9000;
        }
        while (number >= 5000) {
            result.append("V");
            number -= 5000;
        }
        while (number >= 4000) {
            result.append("IV");
            number -= 4000;
        }

        //end parentheses if previous condition was satified
        if (greater4K) {
            result.append(")");
        }

        //starts algorithm below 4000
        while (number >= 1000) {
            result.append("M");
            number -= 1000;
        }
        while (number >= 900) {
            result.append("CM");
            number -= 900;
        }
        while (number >= 500) {
            result.append("D");
            number -= 500;
        }
        while (number >= 400) {
            result.append("CD");
            number -= 400;
        }
        while (number >= 100) {
            result.append("C");
            number -= 100;
        }
        while (number >= 90) {
            result.append("XC");
            number -= 90;
        }
        while (number >= 50) {
            result.append("L");
            number -= 50;
        }
        while (number >= 40) {
            result.append("XL");
            number -= 40;
        }
        while (number >= 10) {
            result.append("X");
            number -= 10;
        }
        while (number >= 9) {
            result.append("IX");
            number -= 9;
        }
        while (number >= 5) {
            result.append("V");
            number -= 5;
        }
        while (number >= 4) {
            result.append("IV");
            number -= 4;
        }
        while (number >= 1) {
            result.append("I");
            number -= 1;
        }

        //returns result which is the final string
        return result.toString();
    }

    Integer getNumber() {
        return number;
    }

    String getRomanNumeral() {
        return romanNumeral;
    }
}
