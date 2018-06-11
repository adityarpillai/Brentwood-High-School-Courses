import java.util.Arrays;

/******************************************************************************
 *  Name:    Aditya Pillai
 *  Date:    31 May 2017
 *
 *  Description:    Connect Four Board object
 *
 *  Copyright 2017 Aditya Pillai
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a
 *  copy of this software and associated documentation files (the "Software"),
 *  to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  and/or sell copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following conditions:
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 *  IN THE SOFTWARE.
 ******************************************************************************/
public class Board {

    private Slot[][] gridBoard;

    char playerTurn;

    Board() {

        playerTurn = 'Y';
        int columns = 7;
        int rows = 6;
        gridBoard = new Slot[rows][columns];
        for (int row = 0; row < 6; row++) {
            for(int col = 0; col < 7; col++) {
                gridBoard[row][col] = new Slot('O');
            }
        }

    }

    //return true if move was made, return false if move couldn't be made
    //will take move
    void takeTurn(int column) {
        for (int i = 5; i >= 0; i--) {
            if (!gridBoard[i][column].isFilled()) {
                System.out.println("Is not filled");
                gridBoard[i][column] = new Slot(playerTurn);
                    if(playerTurn == 'Y') {
                        playerTurn = 'R';
                    } else playerTurn = 'Y';
                return;
            }
            System.out.println("Is filled");
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Slot row[] : gridBoard) {
            result.append(Arrays.toString(row)).append("\n");
        }
        return result.toString();
    }

    Slot[][] getGridBoard() {
        return gridBoard;
    }

    boolean checkWin() {
        return (checkWinHorizontal() || checkWinVertical() || checkWinDiagonalLeft() || checkWinDiagonalRight());
    }
    private boolean checkWinVertical() {
        for (int c = 0; c < 7; c++) {
            for (int r = 0; r < 3; r++) {
                if (gridBoard[r][c].getColor()=='R' && gridBoard[r + 1][c].getColor() == 'R' && gridBoard[r + 2][c].getColor() == 'R' && gridBoard[r + 3][c].getColor() == 'R') {
                    return true;
                }
            }
        }
        for (int c = 0; c < 7; c++) {
            for (int r = 0; r < 3; r++) {
                if (gridBoard[r][c].getColor() == 'Y' && gridBoard[r + 1][c].getColor() == 'Y' && gridBoard[r + 2][c].getColor() == 'Y' && gridBoard[r + 3][c].getColor() == 'Y') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWinHorizontal() {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 4; c++) {
                if (gridBoard[r][c].getColor() == 'R' && gridBoard[r][c + 1].getColor() == 'R' && gridBoard[r][c + 2].getColor() == 'R' && gridBoard[r][c + 3].getColor() == 'R') {
                    return true;
                }
            }
        }
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 4; c++) {
                if (gridBoard[r][c].getColor() == 'Y' && gridBoard[r][c + 1].getColor() == 'Y' && gridBoard[r][c + 2].getColor() == 'Y' && gridBoard[r][c + 3].getColor() == 'Y') {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean checkWinDiagonalLeft() {
        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 7; col++) {
                if (gridBoard[row][col].getColor() == 'R' && gridBoard[row - 1][col - 1].getColor() == 'R' && gridBoard[row - 2][col - 2].getColor() == 'R' && gridBoard[row - 3][col - 3].getColor() == 'R') {
                    return true;
                }
            }
        }
        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 7; col++) {
                if (gridBoard[row][col].getColor() == 'Y' && gridBoard[row - 1][col - 1].getColor() == 'Y' && gridBoard[row - 2][col - 2].getColor() == 'Y' && gridBoard[row - 3][col - 3].getColor() == 'Y') {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean checkWinDiagonalRight() {
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (gridBoard[row][col].getColor() == 'R' && gridBoard[row - 1][col + 1].getColor() == 'R' && gridBoard[row - 2][col + 2].getColor() == 'R' && gridBoard[row - 3][col + 3].getColor() == 'R') {
                    return true;
                }
            }
        }
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (gridBoard[row][col].getColor() == 'Y' && gridBoard[row - 1][col + 1].getColor() == 'Y' && gridBoard[row - 2][col + 2].getColor() == 'Y' && gridBoard[row - 3][col + 3].getColor() == 'Y') {
                    return true;
                }
            }
        }

        return false;
    }

    /*private boolean checkWinDiagonalRight() {
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (gridBoard[row][col].getColor() == 'R' && gridBoard[row - 1][col + 1].getColor() == 'R' && gridBoard[row - 2][col + 2].getColor() == 'R' && gridBoard[row - 3][col + 3].getColor() == 'R') {
                    return true;
                }
            }
        }
        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 4; col++) {
                if (gridBoard[row][col].getColor() == 'Y' && gridBoard[row - 1][col + 1].getColor() == 'Y' && gridBoard[row - 2][col + 2].getColor() == 'Y' && gridBoard[row - 3][col + 3].getColor() == 'Y') {
                    return true;
                }
            }
        }

        return false;
    }*/

}
