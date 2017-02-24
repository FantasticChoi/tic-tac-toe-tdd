package mob.tdd.game;

import lombok.ToString;

@ToString
public class LimitedSizeCoordinate implements Coordinate {

    private final Coordinate coordinate;
    private final int maxSize;

    public LimitedSizeCoordinate(Coordinate coordinate, int maxSize) {
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
            throw new IllegalArgumentException("Accepted values of the row are not in range of [1, " + maxSize +"]");
        }
        if (coordinate.getColumn() < 1 || coordinate.getColumn() > maxSize) {
            throw new IllegalArgumentException("Accepted values of the column are not in range of [1, " + maxSize +"]");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() == o.getClass()) {
            LimitedSizeCoordinate that = (LimitedSizeCoordinate) o;
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
