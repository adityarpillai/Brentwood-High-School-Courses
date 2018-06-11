package InheritancePractice;

/**
 * Created by adityapillai on 1/30/17.
 * Online video game
 */
public class OnlineVideoGame extends AbstractVideoGame{


    // constructor will initialize name and price
    OnlineVideoGame(String n, double pr) {

        name = n;
        price = pr;

    }

    @Override
    public double calculateTax() {
        return 0;
    }

}
