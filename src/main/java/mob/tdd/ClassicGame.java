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
        Classic2DBoard.CellValue[][] state = board.getState();
        for (Classic2DBoard.CellValue[] cellValues : state) {
            for (Classic2DBoard.CellValue cellValue : cellValues) {
                if (cellValue.equals(Classic2DBoard.CellValue.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Classic2DBoard.CellValue calculateCellValue() {
        if (state == GameState.X_TURN) {
            return Classic2DBoard.CellValue.X;
        } else {
            return Classic2DBoard.CellValue.O;
        }
    }

    private void changeState() {
        if (isGameDraw()) {
            state = GameState.DRAW;
        } else if (state.equals(GameState.X_TURN)) {
           state = board.hasDrawnLineFor(Classic2DBoard.CellValue.X) ? GameState.X_WON : GameState.O_TURN;
        } else {
            state = board.hasDrawnLineFor(Classic2DBoard.CellValue.O) ? GameState.O_WON : GameState.X_TURN;
        }
    }

}
