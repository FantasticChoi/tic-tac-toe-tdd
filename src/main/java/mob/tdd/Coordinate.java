package mob.tdd;

public class Coordinate {

    private final int row;
    private final int column;

    public Coordinate(int row, int column) {
        validateValues(row, column);
        this.row = row;
        this.column = column;
    }

    private void validateValues(int row, int column) {
        if (row < 1 || row > 3) {
            throw new IllegalArgumentException("Accepted values from row are not in range of [1, 3]");
        }
        if (column < 1 || column > 3) {
            throw new IllegalArgumentException("Accepted values from column are not in range of [1, 3]");
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
