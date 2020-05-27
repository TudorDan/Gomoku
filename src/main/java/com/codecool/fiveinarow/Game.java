package com.codecool.fiveinarow;

import com.codecool.termlib.Terminal;

public class Game implements GameInterface {

    private int[][] board;
    private int nRows;
    private int nCols;
    private Terminal terminal = new Terminal();

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

    public int[] getMove(int player) {
        return null;
    }

    public int[] getAiMove(int player) {
        return null;
    }

    public void mark(int player, int row, int col) {
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

    public void play(int howMany) {
    }
}
