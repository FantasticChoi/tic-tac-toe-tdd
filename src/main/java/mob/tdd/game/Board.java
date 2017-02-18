package mob.tdd.game;

public interface Board {
    CellValue[][] getState();

    void changeCellValue(Coordinate coordinate, CellValue cellValue);

    boolean hasDrawnLineFor(CellValue cellValue);
}
