package mob.tdd.game.executor;

import mob.tdd.game.*;
import mob.tdd.game.executor.GameRunner;
import mob.tdd.game.fake.FakeBufferedReader;
import mob.tdd.game.fake.FakeGame;
import mob.tdd.game.fake.FakeGameOutput;
import org.junit.Test;

import java.io.InputStreamReader;

import static mob.tdd.game.CellValue.EMPTY;
import static mob.tdd.game.CellValue.X;
import static org.assertj.core.api.Assertions.assertThat;

public class GameRunnerTest {

    @Test
    public void shouldParseAndSendCommandToGame() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        FakeGame game = new FakeGame();
        new GameRunner(game, br, new FakeGameOutput());

        assertThat(game.getLastCoordinate()).isEqualTo(new Coordinate(1, 1));
    }


    @Test
    public void shouldReadTheSecondCommandAndMakeATurn() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        br.addCommandToQueue("2 2");
        FakeGame game = new FakeGame();
        new GameRunner(game, br, new FakeGameOutput());

        assertThat(game.getLastCoordinate()).isEqualTo(new Coordinate(1, 1));
        assertThat(game.getLastCoordinate()).isEqualTo(new Coordinate(2, 2));
    }

    @Test
    public void shouldNotAcceptAnyOtherCommandsIfXWon() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        FakeGame game = new FakeGame();
        game.setGameState(GameState.X_WON);

        new GameRunner(game, br, new FakeGameOutput());

        assertThat(game.getLastCoordinate()).isNotEqualTo(new Coordinate(1, 1));
    }

    @Test
    public void shouldNotAcceptAnyOtherCommandsIfOWon() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        FakeGame game = new FakeGame();
        game.setGameState(GameState.O_WON);

        new GameRunner(game, br, new FakeGameOutput());

        assertThat(game.getLastCoordinate()).isNotEqualTo(new Coordinate(1, 1));
    }

    @Test
    public void shouldNotAcceptAnyOtherCommandsForDrawGame() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        FakeGame game = new FakeGame();
        game.setGameState(GameState.DRAW);

        new GameRunner(game, br, new FakeGameOutput());

        assertThat(game.getLastCoordinate()).isNotEqualTo(new Coordinate(1, 1));
    }

    @Test
    public void shouldPrintToUserOutputGameBoardOnStartingGame() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        FakeGameOutput gameOutput = new FakeGameOutput();
        ClassicGame game = new ClassicGame(new Classic2DBoard());
        new GameRunner(game, br, gameOutput);

        CellValue[][] emptyBoard = {
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
        assertThat(gameOutput.getNextPrintedBoard()).isEqualTo(emptyBoard);
    }

    @Test
    public void shouldPrintAllBoardChanges() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");

        FakeGameOutput gameOutput = new FakeGameOutput();
        ClassicGame game = new ClassicGame(new Classic2DBoard());
        new GameRunner(game, br, gameOutput);

        CellValue[][] lastState = {
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
        CellValue[][] lastPrintedBoard = gameOutput.getNextPrintedBoard();
        assertThat(lastPrintedBoard).isNotNull();
        assertThat(lastPrintedBoard).isEqualTo(lastState);

        CellValue[][] firstState = {
                {X, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
        CellValue[][] firstPrintedBoard = gameOutput.getNextPrintedBoard();
        assertThat(firstPrintedBoard).isNotNull();
        assertThat(firstPrintedBoard).isEqualTo(firstState);
    }
}
