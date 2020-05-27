package com.codecool.fiveinarow;

import com.codecool.termlib.Terminal;

import java.util.Scanner;

public class Game implements GameInterface {

    private int[][] board;
    private int nRows;
    private int nCols;
    private Terminal terminal = new Terminal();
    private int player;

    /**
     * Build new board with nRows x nCols dimensions
     *
     * @param nRows rows number
     * @param nCols cols number
     */
    public Game(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.board = new int[nRows][nCols];
        player = 1;

        for (int row = 0; row < nRows; ++row) {
            for (int col = 0; col < nCols; ++col) {
                this.board[row][col] = 0;
            }
        }

    }

    /**
     * Board getter
     *
     * @return game board
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Board setter
     *
     * @param board // game board
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * Asks for user input and returns the coordinates of a valid move on board.
     *
     * @param player number of player (1 or 2)
     * @return array of 2 int [row, col]
     */
    public int[] getMove(int player) {
        int[] move = new int[2]; // move[0] = row; move[1] = col
        boolean wrongUserInput = true;
        Scanner scan = new Scanner(System.in);

        while (wrongUserInput) {
            System.out.printf("Player %d choice: ", player);
            String userInput = scan.nextLine();

            wrongUserInput = false;

            //get valid row
            char rowChar = Character.toUpperCase(userInput.charAt(0));
            if (rowChar >= 'A' && rowChar <= 'Z') {
                move[0] = rowChar - 'A';
            } else {
                wrongUserInput = true;
            }

            //get valid col
            try {
                move[1] = Integer.parseInt(userInput.substring(1)) - 1;
            } catch (Exception e) {
                wrongUserInput = true;
            }

            //check if move on board
            if (move[0] < 0 || move[0] > nRows - 1 || move[1] < 0 || move[1] > nCols - 1) {
                wrongUserInput = true;
            }

            //check if position free
            if (board[move[0]][move[1]] == 0) {
                wrongUserInput = true;
            }
            if (wrongUserInput) {
                System.out.println("Wrong coordinates! Please try again!");
            }
        }
        scan.close();

        return move;
    }

    public int[] getAiMove(int player) {
        return null;
    }

    /**
     * Writes the value of player (a 1 or 2) into the row & col element of the board
     *
     * @param player number of player (1 or 2)
     * @param row    line number
     * @param col    column number
     */
    public void mark(int player, int row, int col) {
        if (row >= 0 && row < nRows && col >= 0 && col < nCols && board[row][col] == 0) {
            board[row][col] = player;
        }
    }

    public boolean hasWon(int player, int howMany) {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    /**
     * Prints the board to the screen
     */
    public void printBoard() {
        this.terminal.clearScreen();
        this.terminal.moveTo(0, 0);

        for (int col = 0; col < this.nCols; ++col) {
            System.out.printf("%3d", col + 1);
        }

        for (int row = 0; row < this.nRows; ++row) {
            System.out.printf("\n%c", 'A' + row);

            for (int col = 0; col < this.nCols; ++col) {
                if (this.board[row][col] == 0) {
                    System.out.print(" . ");
                } else if (this.board[row][col] == 1) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" O ");
                }
            }
        }

        System.out.println("\n");
    }

    public void printResult(int player) {
    }

    public void enableAi(int player) {
    }

    /**
     * Runs a whole 2-players game. Parameter howMany sets the win condition of the game
     * @param howMany elements in a winning line
     */
    public void play(int howMany) {
        int[] move;
        int winner = 0;
        boolean win = false;

        // game loop
        while (!isFull()) {
            printBoard();

            // get player next move
            move = getMove(player);
            mark(player, move[0], move[1]);

            // check winning
            win = hasWon(player, howMany);
            if(win) {
                winner = player;
                break;
            }

            // change player
            if(player == 1) {
                player = 2;
            } else {
                player = 1;
            }
        }

        // check win conditions
        if(win) {
            System.out.println("The winner is player " + winner + "!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
