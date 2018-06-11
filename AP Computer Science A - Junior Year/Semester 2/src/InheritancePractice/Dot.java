package InheritancePractice;

/**
 * Created by adityapillai on 2/7/17.
 * Inheritance Quiz
 */
public class Dot implements Locatable {

    private int x;
    private int y;
    private int size;

    public Dot() {
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Dot(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }
}
