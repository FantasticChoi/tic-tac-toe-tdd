package mob.tdd.game;

public interface Game {
    GameState getState();

    void turn(int row, int column);

    Board getBoard();
}
