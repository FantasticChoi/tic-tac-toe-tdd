package mob.tdd.game;

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
        if (board.hasDrawnLineFor(CellValue.X)) {
            state = GameState.X_WON;
        } else if (board.hasDrawnLineFor(CellValue.O)) {
            state = GameState.O_WON;
        } else if (isGameDraw()) {
            state = GameState.DRAW;
        } else if (state.equals(GameState.X_TURN)) {
           state = GameState.O_TURN;
        } else {
            state = GameState.X_TURN;
        }
    }

}
