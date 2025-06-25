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
}
