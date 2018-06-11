package Dogs;

/**
 * Created by adityapillai on 1/31/17.
 * Dog Runner Class
 */
public class Main {

    public static void main(String[] args) {

        Dog sam = new Corgi("Sam", 1);
        Dog joe = new Husky("Joe", 5);

        sam.bark();
        joe.bark();

        ((Corgi) sam).useRamp();
        ((Corgi) sam).wagTail();

    }

}
