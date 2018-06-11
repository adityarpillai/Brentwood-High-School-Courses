package Battleship;

/**
 * Created by adityapillai on 1/26/17.
 * shootable interface
 */


@SuppressWarnings("unused")
public interface Shootable {


    //returns -1 if missed,
    //returns 0 if already been hit in that place
    //returns 1 when hit occurs in a new place
    int isHit(int x, int y);


}
