package mob.tdd.game;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SimpleCoordinate implements Coordinate {

    @Getter
    private final int row;

    @Getter
    private final int column;

    public SimpleCoordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
