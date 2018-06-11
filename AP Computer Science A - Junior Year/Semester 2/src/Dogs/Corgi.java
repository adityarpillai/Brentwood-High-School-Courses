package Dogs;

/**
 * Created by adityapillai on 1/31/17.
 * Corgi sub Dog
 */
public class Corgi extends Dog {

    Corgi(String name, int age) {
        super(name, age);
        tail = true;
    }

    @Override
    public void bark() {
        System.out.println("Woof, I'm a Corgi!");
    }

    void useRamp() {
        System.out.println("I'm long and use a ramp.");
    }

    void wagTail() {
        System.out.println(tail);
    }
}
