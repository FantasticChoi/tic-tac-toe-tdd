package mob.tdd.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleCoordinateTest {

    @Test
    public void shouldImplementEqualsAndHashCode() throws Exception {
        Coordinate coordinate = new SimpleCoordinate(1, 3);
        assertThat(coordinate).isEqualTo(new SimpleCoordinate(1, 3));
        assertThat(coordinate.hashCode()).isEqualTo(new SimpleCoordinate(1, 3).hashCode());
    }

    @Test
    public void shouldNotBeEqualWithDifferentCoordinate() throws Exception {
        Coordinate coordinate = new SimpleCoordinate(1, 3);
        assertThat(coordinate).isNotEqualTo(new SimpleCoordinate(2, 3));
    }
}