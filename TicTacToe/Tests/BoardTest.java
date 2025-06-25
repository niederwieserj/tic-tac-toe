import org.example.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class BoardTest {
    @Test
    public void testIfBoardIsEmpty(){
        //Arrange
        Board board = new Board();
        board.place(2, 2, 'X');
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        //Act
        board.clear();

        //Assert
        assertTrue(Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testIfBoardIsNotEmpty(){
        //Arrange
        Board board = new Board();
        board.place(2, 2, 'X');
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        //Act
        board.clear();
        board.place(1, 2, 'X');

        //Assert
        assertTrue(!Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testIfMarkerIsPlaced(){
        //Arrange
        Board board = new Board();
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', 'X'}};

        //Act
        board.place(2, 2, 'x');

        // Assert
        assertTrue(Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testIfMarkerIsMisplaced(){
        //Arrange
        Board board = new Board();
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', 'X'}};

        //Act
        board.place(2, 1, 'X');

        // Assert
        assertTrue(!Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testIfWrongMarkerCanBePlaced(){
        //Arrange
        Board board = new Board();
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        //Act
        board.place(2, 2, 'q');

        // Assert
        assertTrue(Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testIfMarkerCanBePlacedTwice(){
        //Arrange
        Board board = new Board();
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', 'X'}};

        //Act
        board.place(2, 2, 'x');
        board.place(2, 2, 'o');

        // Assert
        assertTrue(Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testPlaceMarkerRowOutOfBounds(){
        //Arrange
        Board board = new Board();
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        //Act
        board.place(3, 0, 'x');

        // Assert
        assertTrue(Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testPlaceMarkerColOutOfBounds(){
        //Arrange
        Board board = new Board();
        char[][] cells = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        //Act
        board.place(0, 3, 'x');

        // Assert
        assertTrue(Arrays.deepEquals(cells, board.getCells()));
    }

    @Test
    public void testCheckMainDiagonalWinner(){
        //Arrange
        Board board = new Board();

        //Act
        board.place(0, 0, 'x');
        board.place(1, 1, 'x');
        board.place(2, 2, 'x');

        // Assert
        assertTrue(board.checkForWinner());
    }

    @Test
    public void testCheckAntiDiagonalWinner(){
        //Arrange
        Board board = new Board();

        //Act
        board.place(0, 2, 'x');
        board.place(1, 1, 'x');
        board.place(2, 0, 'x');

        // Assert
        assertTrue(board.checkForWinner());
    }

    @Test
    public void testCheckRowWinner(){
        //Arrange
        Board board = new Board();

        //Act
        board.place(0, 0, 'x');
        board.place(0, 1, 'x');
        board.place(0, 2, 'x');

        // Assert
        assertTrue(board.checkForWinner());
    }

    @Test
    public void testCheckColWinner(){
        //Arrange
        Board board = new Board();

        //Act
        board.place(0, 0, 'o');
        board.place(1, 0, 'o');
        board.place(2, 0, 'o');

        // Assert
        assertTrue(board.checkForWinner());
    }

    @Test
    public void testCheckNoWinner(){
        //Arrange
        Board board = new Board();

        //Act

        // Assert
        assertFalse(board.checkForWinner());
    }

    @Test
    public void testCheckDraft(){
        //Arrange
        Board board = new Board();

        //Act
        board.place(0, 0, 'o');
        board.place(1, 0, 'x');
        board.place(2, 0, 'o');

        board.place(0, 1, 'x');
        board.place(1, 1, 'o');
        board.place(2, 1, 'x');

        board.place(0, 2, 'o');
        board.place(1, 2, 'x');
        board.place(2, 2, 'o');

        // Assert
        assertTrue(board.checkForDraft());
    }

    @Test
    public void testCheckNoDraft(){
        //Arrange
        Board board = new Board();

        // Assert
        assertFalse(board.checkForDraft());
    }
}
