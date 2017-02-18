package mob.tdd;

import org.junit.Before;
import org.junit.Test;

import static mob.tdd.CellValue.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Classic2DBoardTest {

    private static final int BOARD_SIZE = 3;

    private Board board;

    @Before
    public void createBoard() {
        board = new Classic2DBoard();
    }

    @Test
    public void shouldBeEmptyOnStart() throws Exception {

        CellValue[][] expectedState = new CellValue[][]{
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
        assertThat(board.getState()).isEqualTo(expectedState);
    }

    @Test
    public void shouldChangeCellValueOnTurn() throws Exception {
        final Coordinate coordinate = new Coordinate(1, 1);
        board.changeCellValue(coordinate, X);

        CellValue[][] expectedState = new CellValue[][]{
                {X, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };

        assertThat(board.getState()).isEqualTo(expectedState);
    }

    @Test
    public void shouldNotOverrideNotEmptyCell() throws Exception {
        final Coordinate coordinate = new Coordinate(1, 1);
        board.changeCellValue(coordinate, X);
        try {
            board.changeCellValue(coordinate, O);
            fail("You should not be able to override not EMPTY cell");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldContainHorizontalLineOnBoard() throws Exception {
        board.changeCellValue(new Coordinate(1, 1), X);
        board.changeCellValue(new Coordinate(1, 2), X);
        board.changeCellValue(new Coordinate(1, 3), X);

        assertTrue(board.hasDrawnLineFor(X));
    }

    @Test
    public void shouldContainVerticalLineOnBoard() throws Exception {
        board.changeCellValue(new Coordinate(1, 1), O);
        board.changeCellValue(new Coordinate(2, 1), O);
        board.changeCellValue(new Coordinate(3, 1), O);

        assertTrue(board.hasDrawnLineFor(O));
    }

    @Test
    public void shouldContainLeftToRightDiagonalLineOnBoard() throws Exception {
        board.changeCellValue(new Coordinate(1, 1), O);
        board.changeCellValue(new Coordinate(2, 2), O);
        board.changeCellValue(new Coordinate(3, 3), O);

        assertTrue(board.hasDrawnLineFor(O));
    }


    @Test
    public void shouldContainRightToLeftDiagonalLineOnBoard() throws Exception {
        board.changeCellValue(new Coordinate(1, 3), O);
        board.changeCellValue(new Coordinate(2, 2), O);
        board.changeCellValue(new Coordinate(3, 1), O);

        assertTrue(board.hasDrawnLineFor(O));
    }

    @Test
    public void shouldNotContainLineOnEmptyBoard() throws Exception {
        assertFalse(board.hasDrawnLineFor(X));
    }

    @Test
    public void shouldReturnUnmodifiableState() throws Exception {
        CellValue[][] state = board.getState();
        state[0][0] = X;

        CellValue[][] expectedState = new CellValue[][]{
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
        assertThat(board.getState()).isEqualTo(expectedState);
    }
}
