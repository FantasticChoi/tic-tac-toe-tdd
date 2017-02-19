package mob.tdd.game;

public class ClassicRules implements Rules {

    @Override
    public GameState getGameState(GameState gameState, Board board) {
        if (board.hasDrawnLineFor(CellValue.X)) {
            return GameState.X_WON;
        }
        if (board.hasDrawnLineFor(CellValue.O)) {
            return GameState.O_WON;
        }
        if (isGameDraw(board.getState())) {
            return GameState.DRAW;
        }
        if (gameState == GameState.X_TURN) {
            return GameState.O_TURN;
        }
        if (gameState == GameState.O_TURN) {
            return GameState.X_TURN;
        }
        return gameState;
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
