package InheritancePractice;

/**
 * Created by adityapillai on 1/30/17.
 * Video game store
 */
public class VideoGameStore {

    public static void main(String[] args) {

        // create some video games
        OnlineVideoGame game1 = new OnlineVideoGame("Call of Duty (online)", 50.00);
        PhysicalVideoGame game2 = new PhysicalVideoGame("Call of Duty (physical)", 50.00);

        // display the sales prices of each
        game1.calculateSalesPrice();
        game2.calculateSalesPrice();

    }

}
