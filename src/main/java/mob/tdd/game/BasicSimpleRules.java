package mob.tdd.game;

import java.util.Optional;

public abstract class BasicSimpleRules implements Rules {

    @Override
    public GameState getGameState(GameState currentState, Board board) {
        return getGameWinner(board).orElse(getNextGameState(currentState, board));
    }

    protected abstract Optional<GameState> getGameWinner(Board board);

    private GameState getNextGameState(GameState currentState, Board board) {
        if (isGameDraw(board.getState())) {
            return GameState.DRAW;
        }
        if (currentState == GameState.X_TURN) {
            return GameState.O_TURN;
        }
        if (currentState == GameState.O_TURN) {
            return GameState.X_TURN;
        }
        return currentState;
    }

    private boolean isGameDraw(CellValue[][] state) {
        for (CellValue[] cellValues : state) {
            for (CellValue cellValue : cellValues) {
                if (cellValue.equals(CellValue.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }
}
