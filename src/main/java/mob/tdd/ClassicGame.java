package mob.tdd;

public class ClassicGame implements Game {

    private GameState gameState;
    private final Board board;

    public ClassicGame() {
        gameState = GameState.X_TURN;
        board = new Board();
    }

    @Override
    public GameState getState() {
        return gameState;
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
        if (gameState == GameState.X_TURN) {
            return Board.CellValue.X;
        } else {
            return Board.CellValue.O;
        }
    }

    private void changeState() {
        if (isGameDraw()) {
            gameState = GameState.DRAW;
        } else if (gameState.equals(GameState.X_TURN)) {
           gameState = board.hasDrawnLineFor(Board.CellValue.X) ? GameState.X_WON : GameState.O_TURN;
        } else {
            gameState = board.hasDrawnLineFor(Board.CellValue.O) ? GameState.O_WON : GameState.X_TURN;
        }
    }

}
