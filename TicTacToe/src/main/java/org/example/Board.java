package org.example;

/**
 * Stores game state and methods for tic-tac-toe game
 */
public class Board {
    private final char[][] cells = new char[3][3];

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
     * Check if a cell is empty
     * @param row Row coordinate
     * @param col Column coordinate
     * @return True if empty
     */
    public boolean isCellEmpty(int row, int col) {
        return cells[row][col] == ' ';
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
        char marker;

        // Check rows
        for (int row = 0; row < 3; row++) {
            marker = cells[row][0];

            if (cells[row][1] == marker && cells[row][2] == marker && marker != ' ') {
                return true;
            }
        }

        // Check cols
        for (int col = 0; col < 3; col++) {
            marker = cells[0][col];

            if (cells[1][col] == marker && cells[2][col] == marker && marker != ' ') {
                return true;
            }
        }

        // Check main diagonal
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return true;
        }

        // Check main diagonal
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return true;
        }

        return false;
    }
}
