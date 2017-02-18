package mob.tdd;

import lombok.Getter;

public class ClassicGame implements Game {

    @Getter
    private final Board board;

    @Getter
    private GameState state;

    public ClassicGame(Board board) {
        state = GameState.X_TURN;
        this.board = board;
    }

    @Override
    public void turn(int row, int column) {
        board.changeCellValue(new Coordinate(row, column), calculateCellValue());
        changeState();
    }

    private boolean isGameDraw() {
        CellValue[][] state = board.getState();
        for (CellValue[] cellValues : state) {
            for (CellValue cellValue : cellValues) {
                if (cellValue.equals(CellValue.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private CellValue calculateCellValue() {
        if (state == GameState.X_TURN) {
            return CellValue.X;
        } else {
            return CellValue.O;
        }
    }

    private void changeState() {
        if (isGameDraw()) {
            state = GameState.DRAW;
        } else if (state.equals(GameState.X_TURN)) {
           state = board.hasDrawnLineFor(CellValue.X) ? GameState.X_WON : GameState.O_TURN;
        } else {
            state = board.hasDrawnLineFor(CellValue.O) ? GameState.O_WON : GameState.X_TURN;
        }
    }

}
