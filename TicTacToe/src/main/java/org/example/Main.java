package org.example;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        board.print();
        board.place(1,1, 'X');
        board.print();
        board.place(1,1, 'O');
    }
}