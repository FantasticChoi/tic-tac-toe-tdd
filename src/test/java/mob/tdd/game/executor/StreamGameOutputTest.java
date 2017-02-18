package mob.tdd.game.executor;

import mob.tdd.game.CellValue;
import mob.tdd.game.Classic2DBoard;
import mob.tdd.game.Coordinate;
import mob.tdd.game.executor.StreamGameOutput;
import mob.tdd.game.fake.FakePrintStream;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamGameOutputTest {

    @Test
    public void shouldFormatAndPrintEmptyBoard() throws Exception {
        FakePrintStream out = new FakePrintStream(System.out);
        StreamGameOutput gameOutput = new StreamGameOutput(out);
        gameOutput.print(new Classic2DBoard());

        assertThat(out.getPrintedString()).isEqualTo(" - - -\n - - -\n - - -\n");
    }

    @Test
    public void shouldPrintNotEmptyBoard() throws Exception {
        FakePrintStream out = new FakePrintStream(System.out);
        StreamGameOutput gameOutput = new StreamGameOutput(out);
        Classic2DBoard board = new Classic2DBoard();
        board.changeCellValue(new Coordinate(1, 1), CellValue.X);
        board.changeCellValue(new Coordinate(2, 2), CellValue.O);
        gameOutput.print(board);

        assertThat(out.getPrintedString()).isEqualTo(" X - -\n - O -\n - - -\n");
    }
}
