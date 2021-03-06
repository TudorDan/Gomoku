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
     * @param var1 rows number
     * @param var2 cols number
     */
    public Game(int var1, int var2) {
        this.nRows = var1;
        this.nCols = var2;
        this.board = new int[var1][var2];

        for (int var3 = 0; var3 < var1; ++var3) {
            for (int var4 = 0; var4 < var2; ++var4) {
                this.board[var3][var4] = 0;
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

        int var1;
        for (var1 = 0; var1 < this.nCols; ++var1) {
            System.out.printf("%3d", var1 + 1);
        }

        for (var1 = 0; var1 < this.nRows; ++var1) {
            System.out.printf("\n%c", 65 + var1);

            for (int var2 = 0; var2 < this.nCols; ++var2) {
                if (this.board[var1][var2] == 0) {
                    System.out.print(" . ");
                } else if (this.board[var1][var2] == 1) {
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
