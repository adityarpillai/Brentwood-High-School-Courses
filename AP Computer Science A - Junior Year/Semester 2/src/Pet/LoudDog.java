package Pet;

/**
 * Created by adityapillai on 4/17/17.
 */
public class LoudDog extends Dog {

    public LoudDog(String name) {
        super(name);
    }

    public String speak() {
        return super.speak() + super.speak();
    }
    
}
