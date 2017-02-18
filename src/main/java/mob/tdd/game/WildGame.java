package mob.tdd.game;

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
        board.changeCellValue(new Coordinate(row, column), calculateCellValue());
        changeState();
    }

    private void changeState() {
        if (board.hasDrawnLineFor(CellValue.O)) {
            state = GameState.X_WON;
        } else if (board.hasDrawnLineFor(CellValue.X)) {
            state = GameState.O_WON;
        } else if (isGameDraw()) {
            state = GameState.DRAW;
        } else if (state == GameState.O_TURN) {
            state = GameState.X_TURN;
        } else if (state == GameState.X_TURN) {
            state = GameState.O_TURN;
        }
    }

    private CellValue calculateCellValue() {
        if (state == GameState.X_TURN) {
            return CellValue.X;
        } else {
            return CellValue.O;
        }
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

}
