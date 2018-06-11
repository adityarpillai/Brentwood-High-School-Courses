import java.util.Arrays;

/**
 * Created by Aditya Pillai on 10/5/16.
 * Board Class for the Runner
 */

class PillaiTheBigRaceArrayLab1ClassBoard {

    private int[] board = new int[18];
    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    private int positionOne = 0;
    private int positionTwo = 0;

    PillaiTheBigRaceArrayLab1ClassBoard() {
        board = new int[18];
        playerOneWins = 0;
        playerTwoWins = 0;
    }

    void setUpBoard() {
        board = new int[18];
        int one = 0;
        int two = 0;
        while (one == two) {
            one = (int) (Math.random() * 17);
            positionOne = one;
            two = (int) (Math.random() * 17);
            positionTwo = two;
        }
        board[one] = 1;
        board[two] = 2;

    }

    void displayBoard() {
        System.out.print(Arrays.toString(board));
        System.out.println(" one count = " + getPlayerOneWins() + " two count = " + getPlayerTwoWins());
    }

    void playerOneMoves() {
        int randomNum = (int) (Math.random() * (17 - positionOne) + 1);
        int tempPositionOne = positionOne + randomNum;
        if (tempPositionOne == positionTwo) {
            positionTwo = 0;
            board[positionTwo] = 2;
        }
        board[positionOne] = 0;
        board[tempPositionOne] = 1;
        positionOne = tempPositionOne;

    }

    void playerTwoMoves() {
        int randomNum = (int) (Math.random() * (17 - positionTwo) + 1);
        int tempPositionTwo = positionTwo + randomNum;
        if (tempPositionTwo == positionOne) {
            positionOne = 0;
            board[positionOne] = 1;
        }
        board[positionTwo] = 0;
        board[tempPositionTwo] = 2;
        positionTwo = tempPositionTwo;
    }

    int getPlayerOneWins() {
        return playerOneWins;
    }

    int getPlayerTwoWins() {
        return playerTwoWins;
    }

    boolean getWinCondition() {
        if (positionOne == 17) {
            playerOneWins++;
            return true;
        } else if (positionTwo == 17) {
            playerTwoWins++;
            return true;
        } else return false;
    }

}
