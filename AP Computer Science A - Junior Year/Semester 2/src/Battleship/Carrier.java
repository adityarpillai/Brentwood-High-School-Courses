package Battleship;

/**
 * Created by adityapillai on 1/26/17.
 * Battleship.Carrier
 */
@SuppressWarnings("unused")
public class Carrier implements Locatable, Shootable {

    //x and y represent the front of the boat
    private int x;
    private int y;

    private int[] hits;
    private String direction;


    public Carrier(int x, int y) {
        this.x = x;
        this.y = y;
        String direction = this.direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int isHit(int x, int y) {

        //return -1 miss
        //return 0 hit already hit
        //return 1 hit new spot
        int xChange;
        int yChange;

        String NORTH = "NORTH";
        String SOUTH = "SOUTH";
        String WEST = "WEST";
        if (direction.equals(NORTH)) {
            xChange = 0;
            yChange = 1;
        } else if (direction.equals(SOUTH)) {
            xChange = 0;
            yChange = -1;
        } else if (direction.equals(WEST)) {
            xChange = 1;
            yChange = 0;
        } else {
            xChange = -1;
            yChange = 0;
        }

        int LENGTH = 5;
        for (int i = 0; i < LENGTH; i++) {
            if (this.x == (i * xChange) + x && this.y == (y * yChange) + y) {
                if (hits[i] == 0) {
                    hits[i]++;
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        return -1;

    }
}
