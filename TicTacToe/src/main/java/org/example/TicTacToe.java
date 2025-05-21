// src/main/java/org/example/TicTacToe.java
package org.example;

import java.util.Scanner;

public class TicTacToe {
    private final Player player = new Player('X');
    private final Board board = new Board();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();
        board.print();

        System.out.println("Erster Zug – setze deinen '" + player.getMarker() + "'.");

        int row, col;
        // so lange wiederholen, bis ein gültiges, freies Feld gewählt wurde
        while (true) {
            System.out.print("Zeile (0–2): ");
            row = scanner.nextInt();
            System.out.print("Spalte (0–2): ");
            col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Ungültige Koordinaten, bitte 0 bis 2 eingeben.");
            } else if (!board.isCellEmpty(row, col)) {
                System.out.println("Feld besetzt, wähle ein anderes.");
            } else {
                break;
            }
        }

        board.place(row, col, player.getMarker());
        board.print();

        System.out.println("Dein Stein wurde gesetzt. (Ende der ersten User Story.)");
        scanner.close();
    }
}
