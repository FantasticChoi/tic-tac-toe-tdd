package mob.tdd.game;

import org.junit.Test;

import static mob.tdd.game.CellValue.O;
import static mob.tdd.game.CellValue.X;
import static org.assertj.core.api.Assertions.assertThat;

public class WildSimpleGameTest {

    @Test
    public void shouldBeXTurnOnEmptyBoard() throws Exception {
        Game wildGame = new SimpleGame(new Classic2DBoard(), new WildRules());
        assertThat(wildGame.getState()).isEqualTo(GameState.X_TURN);
    }

    @Test
    public void shouldChangePlayerAfterEachTurn() throws Exception {
        Game wildGame = new SimpleGame(new Classic2DBoard(), new WildRules());
        wildGame.turn(1, 1);

        assertThat(wildGame.getState()).isEqualTo(GameState.O_TURN);

        wildGame.turn(2, 2);
        assertThat(wildGame.getState()).isEqualTo(GameState.X_TURN);
    }

    @Test
    public void shouldHaveXAsWinnerIfODrawsAline() throws Exception {
        Classic2DBoard classic2DBoard = new Classic2DBoard();
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 1), O);
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 2), O);
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 3), O);

        Game wildGame = new SimpleGame(classic2DBoard, new WildRules());
        wildGame.turn(2, 2);

        assertThat(wildGame.getState()).isEqualTo(GameState.X_WON);
    }

    @Test
    public void shouldHaveOAsWinnerIfXDrawsALine() throws Exception {
        Classic2DBoard classic2DBoard = new Classic2DBoard();
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 1), X);
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 2), X);
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 3), X);

        Game wildGame = new SimpleGame(classic2DBoard, new WildRules());
        wildGame.turn(2, 2);

        assertThat(wildGame.getState()).isEqualTo(GameState.O_WON);
    }

    @Test
    public void shouldHaveADrawStateIfNoWinnerAndNoEmptyCellsRemains() throws Exception {
        Classic2DBoard classic2DBoard = new Classic2DBoard();
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 1), X);
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 2), X);
        classic2DBoard.changeCellValue(new SimpleCoordinate(1, 3), O);
        classic2DBoard.changeCellValue(new SimpleCoordinate(2, 1), O);
        classic2DBoard.changeCellValue(new SimpleCoordinate(2, 2), O);
        classic2DBoard.changeCellValue(new SimpleCoordinate(2, 3), X);
        classic2DBoard.changeCellValue(new SimpleCoordinate(3, 1), X);
        classic2DBoard.changeCellValue(new SimpleCoordinate(3, 2), O);

        Game wildGame = new SimpleGame(classic2DBoard, new WildRules());
        wildGame.turn(3, 3);
        assertThat(wildGame.getState()).isEqualTo(GameState.DRAW);
    }
}
