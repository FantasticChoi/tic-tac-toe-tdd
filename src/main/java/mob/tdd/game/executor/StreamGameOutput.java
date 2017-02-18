package mob.tdd.game.executor;

import mob.tdd.game.Board;
import mob.tdd.game.CellValue;

import java.io.PrintStream;

public class StreamGameOutput implements GameOutput {
    private PrintStream out;

    public StreamGameOutput(PrintStream out) {
        this.out = out;
    }

    @Override
    public void print(Board board) {
        CellValue[][] state = board.getState();
        StringBuilder sb = new StringBuilder();
        for (CellValue[] row : state) {
            for (CellValue cell : row) {
                sb.append(" ");
                sb.append(getCellValueToPrint(cell));
            }
            sb.append("\n");
        }
        out.print(sb.toString());
    }

    private char getCellValueToPrint(CellValue cellValue) {
        switch (cellValue) {
            case X: return 'X';
            case O: return 'O';
            default: return '-';
        }
    }
}
