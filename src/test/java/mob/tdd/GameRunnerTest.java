package mob.tdd;

import mob.tdd.fake.FakeBufferedReader;
import mob.tdd.fake.FakeGame;
import org.junit.Test;

import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRunnerTest {

    @Test
    public void shouldParseAndSendCommandToGame() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        FakeGame game = new FakeGame();
        new GameRunner(game, br);

        assertThat(game.getLastCoordinate()).isEqualTo(new Coordinate(1, 1));
    }


    @Test
    public void shouldReadTheSecondCommandAndMakeATurn() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        br.addCommandToQueue("2 2");
        FakeGame game = new FakeGame();
        new GameRunner(game, br);

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

        new GameRunner(game, br);

        assertThat(game.getLastCoordinate()).isNotEqualTo(new Coordinate(1, 1));
    }

    @Test
    public void shouldNotAcceptAnyOtherCommandsIfOWon() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        FakeGame game = new FakeGame();
        game.setGameState(GameState.O_WON);

        new GameRunner(game, br);

        assertThat(game.getLastCoordinate()).isNotEqualTo(new Coordinate(1, 1));
    }

    @Test
    public void shouldNotAcceptAnyOtherCommandsForDrawGame() throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        FakeBufferedReader br = new FakeBufferedReader(inputStreamReader);
        br.addCommandToQueue("1 1");
        FakeGame game = new FakeGame();
        game.setGameState(GameState.DRAW);

        new GameRunner(game, br);

        assertThat(game.getLastCoordinate()).isNotEqualTo(new Coordinate(1, 1));
    }

    @Test
    public void shouldPrintToUserOutputGameBoardOnStartingGame() throws Exception {
    }
}
