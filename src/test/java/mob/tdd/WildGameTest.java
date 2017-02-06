package mob.tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WildGameTest {

    @Test
    public void shouldBeXTurnOnEmptyBoard() throws Exception {
        WildGame wildGame = new WildGame(new Classic2DBoard());
        assertThat(wildGame.getState()).isEqualTo(GameState.X_TURN);
    }
}
