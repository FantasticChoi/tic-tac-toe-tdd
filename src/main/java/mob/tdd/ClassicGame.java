package mob.tdd;

import lombok.Getter;

public class ClassicGame implements Game {

    private final Board board;

    @Getter
    private GameState state;

    public ClassicGame() {
        state = GameState.X_TURN;
        board = new Board();
    }

    @Override
    public void turn(int row, int column) {
        board.changeCellValue(new Coordinate(row, column), calculateCellValue());
        changeState();

    }

    private boolean isGameDraw() {
        Board.CellValue[][] state = board.getState();
        for (Board.CellValue[] cellValues : state) {
            for (Board.CellValue cellValue : cellValues) {
                if (cellValue.equals(Board.CellValue.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Board.CellValue calculateCellValue() {
        if (state == GameState.X_TURN) {
            return Board.CellValue.X;
        } else {
            return Board.CellValue.O;
        }
    }

    private void changeState() {
        if (isGameDraw()) {
            state = GameState.DRAW;
        } else if (state.equals(GameState.X_TURN)) {
           state = board.hasDrawnLineFor(Board.CellValue.X) ? GameState.X_WON : GameState.O_TURN;
        } else {
            state = board.hasDrawnLineFor(Board.CellValue.O) ? GameState.O_WON : GameState.X_TURN;
        }
    }

}
