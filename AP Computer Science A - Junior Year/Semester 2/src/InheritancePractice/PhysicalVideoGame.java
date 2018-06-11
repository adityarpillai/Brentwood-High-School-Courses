package InheritancePractice;

/**
 * Created by adityapillai on 1/30/17.
 * Physical Video Game
 */
public class PhysicalVideoGame extends AbstractVideoGame{

    //constructor will initialize name and price
    public PhysicalVideoGame(String name, double price) {

        this.name = name;
        this.price = price;

    }

    @Override
    public double calculateTax() {
        return price * 0.095;
    }


}
