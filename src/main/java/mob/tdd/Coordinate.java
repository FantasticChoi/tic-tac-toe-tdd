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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (row != that.row) return false;
        return column == that.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
