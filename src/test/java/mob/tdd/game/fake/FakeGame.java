package mob.tdd.game.fake;

import lombok.Getter;
import lombok.Setter;
import mob.tdd.game.Board;
import mob.tdd.game.Coordinate;
import mob.tdd.game.Game;
import mob.tdd.game.GameState;

import java.util.LinkedList;
import java.util.Queue;

public class FakeGame implements Game {

    private Queue<Coordinate> turns = new LinkedList<>();

    @Getter @Setter
    private GameState gameState = GameState.X_TURN;

    @Override
    public GameState getState() {
        return gameState;
    }

    @Override
    public void turn(int row, int column) {
        turns.add(new Coordinate(row, column));
    }

    @Override
    public Board getBoard() {
        return null;
    }

    public Coordinate getLastCoordinate() {
        return turns.poll();
    }
}
