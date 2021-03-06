package mob.tdd.game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicSimpleGameTest {

    private SimpleGame game;

    @Before
    public void createGame() {
        game = new SimpleGame(new Classic2DBoard(), new ClassicRules());
    }

    @Test
    public void shouldBeXTurnOnNewGame() throws Exception {
        assertThat(game.getState()).isEqualTo(GameState.X_TURN);
    }

    @Test
    public void shouldChangePlayerOnTurn() throws Exception {
        game.turn(1, 1);
        assertThat(game.getState()).isEqualTo(GameState.O_TURN);
    }

    @Test
    public void shouldDetectDrawState() throws Exception {
        game.turn(2, 2);
        game.turn(1, 1);
        game.turn(3, 1);
        game.turn(1, 3);
        game.turn(1, 2);
        game.turn(3, 2);
        game.turn(2, 3);
        game.turn(2, 1);
        game.turn(3, 3);

        assertThat(game.getState()).isEqualTo(GameState.DRAW);
    }

    @Test
    public void shouldHaveXAsWinner() throws Exception {
        game.turn(1, 1);
        game.turn(2, 1);
        game.turn(1, 2);
        game.turn(2, 2);
        game.turn(1, 3);

        assertThat(game.getState()).isEqualTo(GameState.X_WON);
    }

    @Test
    public void shoulDetectWinnerWhenLineIsDrawOnLastPossibleMove() throws Exception {
        game.turn(2, 2);
        game.turn(1, 1);
        game.turn(1, 2);
        game.turn(3, 1);
        game.turn(2, 1);
        game.turn(2, 3);
        game.turn(1, 3);
        game.turn(3, 3);
        game.turn(3, 2);

        assertThat(game.getState()).isEqualTo(GameState.X_WON);
    }
}
