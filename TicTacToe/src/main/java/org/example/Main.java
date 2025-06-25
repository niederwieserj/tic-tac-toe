package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner s = new Scanner(System.in);
        char marker = 'x';

        System.out.println("====================================");
        System.out.println("Welcome to tic-tac-toe!");
        System.out.println("====================================");
        System.out.println();
        board.print();
        System.out.println("Place a marker to start");

        while(true) {
            System.out.println("Please enter the row number: ");
            System.out.print("> ");
            try {
                int row = Integer.parseInt(s.next());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid row number");
            }

            System.out.println("Please enter the column number: ");
            System.out.print("> ");
            int col = Integer.parseInt(s.next());

            board.place(row, col, marker);
            board.print();

            if(board.checkForWinner()) {
                System.out.println(Character.toUpperCase(marker) + " won!");
                break;
            }

            marker = marker == 'x' ? 'o' : 'x';
        }
    }
}