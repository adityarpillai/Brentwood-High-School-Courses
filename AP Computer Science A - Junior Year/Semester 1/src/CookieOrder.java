/**
 * Created by Aditya Pillai on 10/13/16.
 * http://apcentral.collegeboard.com/apc/public/repository/ap10_frq_computer_science_a.pdf
 */
@SuppressWarnings({"unused", "WeakerAccess"})

public class CookieOrder {

    private String variety;
    private int numBoxes;

    public CookieOrder() {
        variety = "null";
        numBoxes = 0;
    }

    public CookieOrder(String variety, int numBoxes) {
        this.variety = variety;
        this.numBoxes = numBoxes;
    }

    public String getVariety() {
        return variety;
    }

    public int getNumBoxes() {
        return numBoxes;
    }

}
