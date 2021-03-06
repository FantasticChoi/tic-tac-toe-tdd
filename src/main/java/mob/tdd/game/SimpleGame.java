package mob.tdd.game;

import lombok.Getter;

public class SimpleGame implements Game {

    @Getter
    private final Board board;

    @Getter
    private GameState state;

    private final Rules rules;

    public SimpleGame(Board board, Rules rules) {
        state = GameState.X_TURN;
        this.board = board;
        this.rules = rules;
    }

    @Override
    public void turn(int row, int column) {
        board.changeCellValue(new SimpleCoordinate(row, column), calculateCellValue());
        state = rules.getGameState(state, board);
    }

    private CellValue calculateCellValue() {
        if (state == GameState.X_TURN) {
            return CellValue.X;
        } else {
            return CellValue.O;
        }
    }
}
