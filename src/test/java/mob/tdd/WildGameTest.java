package mob.tdd;

import org.junit.Test;

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
}
