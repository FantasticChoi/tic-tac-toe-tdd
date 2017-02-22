package mob.tdd.game;

import lombok.ToString;

@ToString
public class ValidSizeCoordinate implements Coordinate {

    private final Coordinate coordinate;
    private final int maxSize;

    public ValidSizeCoordinate(Coordinate coordinate, int maxSize) {
        this.maxSize = maxSize;
        validateValues(coordinate);
        this.coordinate = coordinate;
    }

    @Override
    public int getRow() {
        return coordinate.getRow();
    }

    @Override
    public int getColumn() {
        return coordinate.getColumn();
    }

    private void validateValues(Coordinate coordinate) {
        if (coordinate.getRow() < 1 || coordinate.getRow() > maxSize) {
            throw new IllegalArgumentException("Accepted values from row are not in range of [1, " + maxSize +"]");
        }
        if (coordinate.getColumn() < 1 || coordinate.getColumn() > maxSize) {
            throw new IllegalArgumentException("Accepted values from column are not in range of [1, " + maxSize +"]");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() == o.getClass()) {
            ValidSizeCoordinate that = (ValidSizeCoordinate) o;
            return coordinate.equals(that.coordinate);
        } else {
            return coordinate.equals(o);
        }
    }

    @Override
    public int hashCode() {
        return coordinate.hashCode();
    }
}
