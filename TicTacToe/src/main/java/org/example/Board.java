// src/main/java/org/example/Board.java
package org.example;

public class Board {
    private final char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = ' ';
    }

    public boolean isCellEmpty(int row, int col) {
        return cells[row][col] == ' ';
    }

    public void place(int row, int col, char marker) {
        cells[row][col] = marker;
    }

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
}
