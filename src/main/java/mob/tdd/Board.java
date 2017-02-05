package mob.tdd;

public interface Board {
    Classic2DBoard.CellValue[][] getState();

    void changeCellValue(Coordinate coordinate, Classic2DBoard.CellValue cellValue);

    boolean hasDrawnLineFor(Classic2DBoard.CellValue cellValue);
}
