package InheritancePractice;

/**
 * Created by adityapillai on 1/30/17.
 * abstract video game
 */
abstract public class AbstractVideoGame {


    //these class member variables are available to all derived classes
    protected String name;
    protected double price;


    //calculate and display final sales price
    public void calculateSalesPrice() {
        double salesPrice = price + calculateTax();
        System.out.println(name + " costs \t$" + salesPrice);
    }

    //all derived classes must implement this method
    abstract public double calculateTax();

}
