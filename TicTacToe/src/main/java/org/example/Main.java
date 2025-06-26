package org.example;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("====================================");
        System.out.println("Welcome to tic-tac-toe!");
        System.out.println("====================================");
        System.out.println();
        board.print();
        System.out.println("Place a marker to start");

        while (true) {
            gameLoop(board);

            int choice = -1;

            do {
                System.out.println("Wanna play again? (1=yes/0=no)");
                System.out.print("> ");
                choice = board.inputNumber();
            }
            while(choice != 0 && choice != 1);

            if (choice == 0) {
                break;
            }

            board.clear();
            board.print();
        }
    }

    /**
     * Run a game until it's finished
     * @param board Board instance
     */
    public static void gameLoop(Board board) {
        char marker = 'x';

        while (true) {
            System.out.println("Please enter the row number: ");
            System.out.print("> ");
            int row = board.inputNumber();

            System.out.println("Please enter the column number: ");
            System.out.print("> ");
            int col = board.inputNumber();

            board.place(row, col, marker);
            board.print();

            if (board.checkForWinner()) {
                System.out.println(Character.toUpperCase(marker) + " won!");
                break;
            } else if (board.checkForDraft()) {
                System.out.println("It's a draft!");
                break;
            }

            marker = marker == 'x' ? 'o' : 'x';
        }
    }
}