package mob.tdd;

import lombok.Getter;

public class WildGame implements Game {

    @Getter
    private GameState state = GameState.X_TURN;

    @Getter
    private final Board board;

    public WildGame(Board board) {
        this.board = board;
    }

    @Override
    public void turn(int row, int column) {
        if (board.hasDrawnLineFor(Classic2DBoard.CellValue.O)) {
            state = GameState.X_WON;
        } else if (board.hasDrawnLineFor(Classic2DBoard.CellValue.X)) {
            state = GameState.O_WON;
        } else if (state == GameState.O_TURN) {
            state = GameState.X_TURN;
        } else if (state == GameState.X_TURN) {
            state = GameState.O_TURN;
        }
    }
}
