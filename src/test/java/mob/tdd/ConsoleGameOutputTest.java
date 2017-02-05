package mob.tdd;

import mob.tdd.fake.FakePrintStream;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleGameOutputTest {

    @Test
    public void shouldFormatAndPrintEmptyBoard() throws Exception {
        FakePrintStream out = new FakePrintStream(System.out);
        ConsoleGameOutput gameOutput = new ConsoleGameOutput(out);
        gameOutput.print(new Classic2DBoard());

        assertThat(out.getPrintedString()).isEqualTo(" - - -\n - - -\n - - -\n");
    }

    @Test
    public void shouldPrintNotEmptyBoard() throws Exception {
        FakePrintStream out = new FakePrintStream(System.out);
        ConsoleGameOutput gameOutput = new ConsoleGameOutput(out);
        Classic2DBoard board = new Classic2DBoard();
        board.changeCellValue(new Coordinate(1, 1), Classic2DBoard.CellValue.X);
        board.changeCellValue(new Coordinate(2, 2), Classic2DBoard.CellValue.O);
        gameOutput.print(board);

        assertThat(out.getPrintedString()).isEqualTo(" X - -\n - O -\n - - -\n");
    }
}
