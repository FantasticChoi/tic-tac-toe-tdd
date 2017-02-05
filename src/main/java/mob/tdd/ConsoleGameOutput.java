package mob.tdd;

import java.io.PrintStream;

public class ConsoleGameOutput implements GameOutput {
    private PrintStream out;

    public ConsoleGameOutput(PrintStream out) {
        this.out = out;
    }

    @Override
    public void print(Board board) {
        Classic2DBoard.CellValue[][] state = board.getState();
        StringBuilder sb = new StringBuilder();
        for (Classic2DBoard.CellValue[] row : state) {
            for (Classic2DBoard.CellValue cell : row) {
                sb.append(" ");
                sb.append(getCellValueToPrint(cell));
            }
            sb.append("\n");
        }
        out.print(sb.toString());
    }

    private char getCellValueToPrint(Classic2DBoard.CellValue cellValue) {
        switch (cellValue) {
            case X: return 'X';
            case O: return 'O';
            default: return '-';
        }
    }
}
