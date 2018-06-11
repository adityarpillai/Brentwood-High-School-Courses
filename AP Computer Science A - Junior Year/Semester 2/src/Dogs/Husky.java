package Dogs;

/**
 * Created by adityapillai on 1/31/17.
 * Husky sub Dog
 */
public class Husky extends Dog {

    Husky(String name, int age) {
        super(name, age);
        tail = true;
    }

    public void bark() {
        System.out.println("Woof, I'm a Husky.");
    }



}
