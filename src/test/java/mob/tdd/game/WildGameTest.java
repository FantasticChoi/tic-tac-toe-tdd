package mob.tdd.game;

import org.junit.Test;

import static mob.tdd.game.CellValue.O;
import static mob.tdd.game.CellValue.X;
import static org.assertj.core.api.Assertions.assertThat;

public class WildGameTest {

    @Test
    public void shouldBeXTurnOnEmptyBoard() throws Exception {
        WildGame wildGame = new WildGame(new Classic2DBoard());
        assertThat(wildGame.getState()).isEqualTo(GameState.X_TURN);
    }

    @Test
    public void shouldChangePlayerAfterEachTurn() throws Exception {
        WildGame wildGame = new WildGame(new Classic2DBoard());
        wildGame.turn(1, 1);

        assertThat(wildGame.getState()).isEqualTo(GameState.O_TURN);

        wildGame.turn(2, 2);
        assertThat(wildGame.getState()).isEqualTo(GameState.X_TURN);
    }

    @Test
    public void shouldHaveXAsWinnerIfODrawsAline() throws Exception {
        Classic2DBoard classic2DBoard = new Classic2DBoard();
        classic2DBoard.changeCellValue(new Coordinate(1, 1), O);
        classic2DBoard.changeCellValue(new Coordinate(1, 2), O);
        classic2DBoard.changeCellValue(new Coordinate(1, 3), O);

        WildGame wildGame = new WildGame(classic2DBoard);
        wildGame.turn(2, 2);

        assertThat(wildGame.getState()).isEqualTo(GameState.X_WON);
    }

    @Test
    public void shouldHaveOAsWinnerIfXDrawsALine() throws Exception {
        Classic2DBoard classic2DBoard = new Classic2DBoard();
        classic2DBoard.changeCellValue(new Coordinate(1, 1), X);
        classic2DBoard.changeCellValue(new Coordinate(1, 2), X);
        classic2DBoard.changeCellValue(new Coordinate(1, 3), X);

        WildGame wildGame = new WildGame(classic2DBoard);
        wildGame.turn(2, 2);

        assertThat(wildGame.getState()).isEqualTo(GameState.O_WON);
    }

    @Test
    public void shouldHaveADrawStateIfNoWinnerAndNoEmptyCellsRemains() throws Exception {
        Classic2DBoard classic2DBoard = new Classic2DBoard();
        classic2DBoard.changeCellValue(new Coordinate(1, 1), X);
        classic2DBoard.changeCellValue(new Coordinate(1, 2), X);
        classic2DBoard.changeCellValue(new Coordinate(1, 3), O);
        classic2DBoard.changeCellValue(new Coordinate(2, 1), O);
        classic2DBoard.changeCellValue(new Coordinate(2, 2), O);
        classic2DBoard.changeCellValue(new Coordinate(2, 3), X);
        classic2DBoard.changeCellValue(new Coordinate(3, 1), X);
        classic2DBoard.changeCellValue(new Coordinate(3, 2), O);

        WildGame wildGame = new WildGame(classic2DBoard);
        wildGame.turn(3, 3);
        assertThat(wildGame.getState()).isEqualTo(GameState.DRAW);
    }
}
