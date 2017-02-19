package mob.tdd.game;

import java.util.Optional;

public class WildRules extends BasicSimpleRules {

    @Override
    protected Optional<GameState> getGameWinner(Board board) {
        if (board.hasDrawnLineFor(CellValue.O)) {
            return Optional.of(GameState.X_WON);
        }
        if (board.hasDrawnLineFor(CellValue.X)) {
            return Optional.of(GameState.O_WON);
        }
        return Optional.empty();
    }
}
