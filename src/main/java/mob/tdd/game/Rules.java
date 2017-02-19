package mob.tdd.game;

public interface Rules {
    GameState getGameState(GameState currentState, Board board);
}
