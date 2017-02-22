package mob.tdd.game;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static mob.tdd.game.CellValue.*;

public class Classic6ScaleBoardTest {

    @Test
    public void shouldReturnInitialState() throws Exception {
        Board board = new Classic6ScaleBoard();
        CellValue[][] state = board.getState();
        Assertions.assertThat(state).isEqualTo(new CellValue[][]{
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}
        });
    }

    @Test
    public void shouldChangeCellValue() throws Exception {
        Board board = new Classic6ScaleBoard();
        board.changeCellValue(new SimpleCoordinate(1, 1), O);
        CellValue[][] state = board.getState();

        Assertions.assertThat(state).isEqualTo(new CellValue[][]{
                {O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}
        });
    }

    @Test
    public void shouldHaveAcceptChangingLastCellValue() throws Exception {
        Board board = new Classic6ScaleBoard();
        board.changeCellValue(new SimpleCoordinate(6, 6), X);
        CellValue[][] state = board.getState();

        Assertions.assertThat(state).isEqualTo(new CellValue[][]{
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, X}
        });
    }
}
