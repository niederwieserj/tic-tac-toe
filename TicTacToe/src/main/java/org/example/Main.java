package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
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
            int row = board.inputNumber();

            System.out.println("Please enter the column number: ");
            System.out.print("> ");
            int col = board.inputNumber();

            board.place(row, col, marker);
            board.print();

            if(board.checkForWinner()) {
                System.out.println(Character.toUpperCase(marker) + " won!");
                break;
            } else if(board.checkForDraft()) {
                System.out.println("It's a draft!");
                break;
            }

            marker = marker == 'x' ? 'o' : 'x';
        }
    }
}