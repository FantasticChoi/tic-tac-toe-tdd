package mob.tdd;

import lombok.Getter;

public class WildGame implements Game {

    @Getter
    private GameState state = GameState.X_TURN;

    public WildGame(Board board) {
    }

    @Override
    public void turn(int row, int column) {
        if (state == GameState.O_TURN) {
            state = GameState.X_TURN;
        } else if (state == GameState.X_TURN) {
            state = GameState.O_TURN;
        }
    }

    @Override
    public Board getBoard() {
        return null;
    }
}
