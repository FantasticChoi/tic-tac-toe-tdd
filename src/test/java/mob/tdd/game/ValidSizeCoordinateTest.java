package mob.tdd.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class ValidSizeCoordinateTest {

    @Test
    public void shouldNotAcceptValueOnRowLowerThanOne() throws Exception {
        try {
            new ValidSizeCoordinate(new SimpleCoordinate(0, 1), 3);
            fail("Value of row should be higher than 0");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldNotAcceptValueOnColumnLowerThanOne() throws Exception {
        try {
            new ValidSizeCoordinate(new SimpleCoordinate(1, 0), 3);
            fail("Value of column should be higher than 0");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldNotAcceptValueOnRowHigherThanThree() throws Exception {
        try {
            new ValidSizeCoordinate(new SimpleCoordinate(4, 1), 3);
            fail("Value on row should be lower than 4");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldNotAcceptValueOnColumnHigherThanThree() throws Exception {
        try {
            new ValidSizeCoordinate(new SimpleCoordinate(0, 4), 3);
            fail("Value on column should be lower than 4");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldBeEqualToCoordinateWithTheSameValues() throws Exception {
        Coordinate coordinate = new ValidSizeCoordinate(new SimpleCoordinate(1, 3), 3);
        Coordinate expected = new ValidSizeCoordinate(new SimpleCoordinate(1, 3), 3);

        assertThat(coordinate).isEqualTo(expected);
    }

    @Test
    public void shouldBeEqualToObjectThatItDecorates() throws Exception {
        Coordinate decorates = new SimpleCoordinate(1, 3);
        Coordinate coordinate = new ValidSizeCoordinate(decorates, 3);

        assertThat(coordinate.hashCode()).isEqualTo(decorates.hashCode());
        assertThat(coordinate).isEqualTo(decorates);
    }
}
