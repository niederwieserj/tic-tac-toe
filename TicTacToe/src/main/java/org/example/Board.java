package org.example;

import java.util.Scanner;

/**
 * Stores game state and methods for tic-tac-toe game
 */
public class Board {
    private final char[][] cells = new char[3][3];
    private Scanner scanner = new Scanner(System.in);

    /**
     * Initialize board
     */
    public Board() {
        clear();
    }

    /**
     * Getter for board cells
     * @return Cells
     */
    public char[][] getCells() {
        return cells;
    }

    /**
     * Set board array to space character (=empty)
     */
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /**
     * Place a marker on the board at a position defined by params row, col
     * @param row Row into which the marker should be placed
     * @param col Column into which the marker should be placed
     * @param marker Marker to be placed. Possible values: x, X, o, O
     */
    public void place(int row, int col, char marker) {
        marker = Character.toUpperCase(marker);

        if (row > 2 || row < 0) {
            System.out.print("Invalid row. Must be between 0 and 2");
            return;
        }

        if (col > 2 || col < 0) {
            System.out.print("Invalid column. Must be between 0 and 2");
            return;
        }

        if (marker != 'X' && marker != 'O') {
            System.out.print("Only characters 'X' and 'O' can be placed");
            return;
        }

        if (cells[row][col] != ' ') {
            System.out.print("That character is already placed");
            return;
        }

        cells[row][col] = marker;
    }

    /**
     * Get number from terminal StdIn
     * @return Number
     */
    public int inputNumber() {
        int number = -1;

        try {
            number = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }

        return number;
    }

    /**
     * Print the board to the console
     */
    public void print() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Check if there are three symbols in a line
     * @return True if winner found
     */
    public boolean checkForWinner() {
        for (int i = 0; i < 3; i++) {
            // Check row
            if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                return true;
            }

            // Check col
            if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                return true;
            }
        }

        // Check main diagonal
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return true;
        }

        // Check anti diagonal
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return true;
        }

        return false;
    }

    /**
     * Check for draft (board is full)
     * @return True if draft
     */
    public boolean checkForDraft() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cells[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
