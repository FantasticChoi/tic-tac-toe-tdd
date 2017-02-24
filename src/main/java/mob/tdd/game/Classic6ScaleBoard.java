package mob.tdd.game;

public class Classic6ScaleBoard implements Board {

    private final CellValue[][] state;

    public Classic6ScaleBoard() {
        state = new CellValue[][]{
            {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY},
            {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY},
            {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY},
            {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY},
            {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY},
            {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY}
        };
    }

    @Override
    public CellValue[][] getState() {
        return state;
    }

    @Override
    public void changeCellValue(Coordinate coordinate, CellValue cellValue) {
        int row = coordinate.getRow() - 1;
        int column = coordinate.getColumn() - 1;
        state[row][column] = cellValue;
    }

    @Override
    public boolean hasDrawnLineFor(CellValue cellValue) {
        return false;
    }
}
