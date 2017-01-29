package mob.tdd;

import org.junit.Test;

import static org.junit.Assert.fail;

public class CoordinateTest {

    @Test
    public void shouldNotAcceptValuesLowerThanOne() throws Exception {
        try {
            Coordinate coordinate = new Coordinate(0, 0);
            fail("Values should be higher than 0");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void shouldNotAcceptValuesHigherThanThree() throws Exception {
        try {
            Coordinate coordinate = new Coordinate(4, 4);
            fail("Values should be lower than 4");
        } catch (IllegalArgumentException e) {
        }
    }
}
