package mob.tdd.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class CoordinateTest {

    @Test
    public void shouldNotAcceptValueOnRowLowerThanOne() throws Exception {
        try {
            new Coordinate(0, 1);
            fail("Value of row should be higher than 0");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldNotAcceptValueOnColumnLowerThanOne() throws Exception {
        try {
            new Coordinate(1, 0);
            fail("Value of column should be higher than 0");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldNotAcceptValueOnRowHigherThanThree() throws Exception {
        try {
            new Coordinate(4, 1);
            fail("Value on row should be lower than 4");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldNotAcceptValueOnColumnHigherThanThree() throws Exception {
        try {
            new Coordinate(1, 4);
            fail("Value on column should be lower than 4");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldImplementEqualsAndHashCode() throws Exception {
        Coordinate coordinate = new Coordinate(1, 3);
        assertThat(coordinate).isEqualTo(new Coordinate(1, 3));
        assertThat(coordinate.hashCode()).isEqualTo(new Coordinate(1, 3).hashCode());
    }
}