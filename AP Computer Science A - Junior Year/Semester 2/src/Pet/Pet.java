package Pet;

/**
 * Created by adityapillai on 4/17/17.
 */
public abstract class Pet {

    private String myName;

    public Pet(String myName) {
        this.myName = myName;
    }

    public String getName() {
        return myName;
    }

    public abstract String speak();

}
