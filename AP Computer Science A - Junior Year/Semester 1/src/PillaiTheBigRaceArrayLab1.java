/**
 * Created by Aditya Pillai on 10/3/16.
 * Pillai Array Lab
 */
public class PillaiTheBigRaceArrayLab1 {
    public static void main(String[] args) {


        //uses Board Class
        PillaiTheBigRaceArrayLab1ClassBoard playerBoard = new PillaiTheBigRaceArrayLab1ClassBoard();

        //Program will continue to run as long as neither player has five wins
        while (playerBoard.getPlayerOneWins() < 5 && playerBoard.getPlayerTwoWins() < 5) {

            //will reset board each time & set initial player position
            playerBoard.setUpBoard();

            //will display board before players move
            playerBoard.displayBoard();

            while (!playerBoard.getWinCondition()) { //this while loop will continue to run until there is a win condition
                //format:
                //player one moves, display board, check board
                //player two moves, display board, check board
                //repeat
                playerBoard.playerOneMoves();
                playerBoard.displayBoard();
                if (playerBoard.getWinCondition()) break;
                playerBoard.playerTwoMoves();
                playerBoard.displayBoard();
                if (playerBoard.getWinCondition()) break;
            }

        }

        //displays board to show that a player has won
        playerBoard.displayBoard();

        //tells who won by checking who has the 5 wins
        if (playerBoard.getPlayerOneWins() == 5) {
            System.out.println("Player One Won.");
        } else {
            System.out.println("Player Two Won.");
        }

        //end of program
    }//end of main
}//end of class
