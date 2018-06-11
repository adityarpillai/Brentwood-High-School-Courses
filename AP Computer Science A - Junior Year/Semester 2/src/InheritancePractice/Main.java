package InheritancePractice;

/**
 * Created by adityapillai on 2/7/17.
 * main method for dot class
 */
public class Main {

    public static void main(String[] args) {
        Dot dotOne = new Dot();
        Dot dotTwo = new Dot(1, 1);
        Dot dotThree = new Dot(1, 1, 2);

        System.out.println(dotOne.getXPos());
    }

}
