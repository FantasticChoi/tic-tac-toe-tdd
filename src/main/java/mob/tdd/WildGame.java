package mob.tdd;

public class WildGame implements Game {

    public WildGame(Classic2DBoard classic2DBoard) {
    }

    @Override
    public GameState getState() {
        return GameState.X_TURN;
    }

    @Override
    public void turn(int row, int column) {

    }

    @Override
    public Board getBoard() {
        return null;
    }
}
