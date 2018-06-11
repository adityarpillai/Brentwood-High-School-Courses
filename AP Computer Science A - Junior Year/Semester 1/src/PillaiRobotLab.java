/**
 * Created by Aditya Pillai on 11/2/16.
 * APCS 2004 FRQ Part 4
 */
@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class PillaiRobotLab {


    private int[] hall;
    private int pos; // current position(tile number) of Robot
    private boolean facingRight; // true means this Robot is facing right

    public PillaiRobotLab(int[] hall) {
        this.hall = hall;
    }

    // constructor not shown

    // postcondition: returns true if this Robot has a wall immediately in

    // front of it, so that it cannot move forward;

    // otherwise, returns false

    private boolean forwardMoveBlocked() {
        if (facingRight) {
            if (pos == hall.length - 1) {
                return true;
            }
        } else { //noinspection ConstantConditions
            if (!facingRight) {
                if (pos == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // postcondition: one move has been made according to the

    // specifications above and the state of this

    // Robot has been updated

    private void move() {
        //if thing exists, will remove
        if (hall[pos] > 0) {
            hall[pos]--;
        }
        if (hall[pos] == 0) {
            if (facingRight && !forwardMoveBlocked()) {
                pos++;
            } else if (!facingRight && !forwardMoveBlocked()) {
                pos--;
            } else {
                facingRight = !facingRight;
            }
        }

    }


    // postcondition: no more items remain in the hallway;

    // returns the number of moves made

    public int clearHall() {
        int moveCount = 0;
        while (!hallIsClear()) {
            move();
            moveCount++;
        }
        return moveCount;
    }

    // postcondition: returns true if the hallway contains no items;

    // otherwise, returns false

    private boolean hallIsClear() {
        int numberSpots = 0;
        for (int aHall : hall)
            if (aHall > 0) {
                numberSpots++;
                break;
            }
        return ((numberSpots) > 0);
    }

}