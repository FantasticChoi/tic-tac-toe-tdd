package mob.tdd.game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicRulesTest {

    private Rules rules;

    @Before
    public void createRules() throws Exception {
        rules = new ClassicRules();
    }

    @Test
    public void shouldReturnOTurnAsNextState() throws Exception {
        GameState gameState = rules.getGameState(GameState.X_TURN, new Classic2DBoard());
        assertThat(gameState).isEqualTo(GameState.O_TURN);
    }

    @Test
    public void shouldReturnXTurnAsNextState() throws Exception {
        GameState gameState = rules.getGameState(GameState.O_TURN, new Classic2DBoard());
        assertThat(gameState).isEqualTo(GameState.X_TURN);
    }

    @Test
    public void shouldDetectDrawResult() throws Exception {
        Board board = new Classic2DBoard();
        board.changeCellValue(new SimpleCoordinate(1, 1), CellValue.O);
        board.changeCellValue(new SimpleCoordinate(1, 2), CellValue.O);
        board.changeCellValue(new SimpleCoordinate(1, 3), CellValue.X);
        board.changeCellValue(new SimpleCoordinate(2, 1), CellValue.X);
        board.changeCellValue(new SimpleCoordinate(2, 2), CellValue.X);
        board.changeCellValue(new SimpleCoordinate(2, 3), CellValue.O);
        board.changeCellValue(new SimpleCoordinate(3, 1), CellValue.O);
        board.changeCellValue(new SimpleCoordinate(3, 2), CellValue.X);
        board.changeCellValue(new SimpleCoordinate(3, 3), CellValue.X);

        GameState gameState = rules.getGameState(GameState.O_TURN, board);
        assertThat(gameState).isEqualTo(GameState.DRAW);
    }

    @Test
    public void shouldDetectXAsWinner() throws Exception {
        Board board = new Classic2DBoard();
        board.changeCellValue(new SimpleCoordinate(1, 1), CellValue.X);
        board.changeCellValue(new SimpleCoordinate(1, 2), CellValue.X);
        board.changeCellValue(new SimpleCoordinate(1, 3), CellValue.X);

        GameState gameState = rules.getGameState(GameState.O_TURN, board);
        assertThat(gameState).isEqualTo(GameState.X_WON);
    }

    @Test
    public void shouldDetectOAsWinner() throws Exception {
        Board board = new Classic2DBoard();
        board.changeCellValue(new SimpleCoordinate(1, 1), CellValue.O);
        board.changeCellValue(new SimpleCoordinate(1, 2), CellValue.O);
        board.changeCellValue(new SimpleCoordinate(1, 3), CellValue.O);

        GameState gameState = rules.getGameState(GameState.O_TURN, board);
        assertThat(gameState).isEqualTo(GameState.O_WON);
    }
}
