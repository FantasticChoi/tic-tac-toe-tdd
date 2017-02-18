package mob.tdd.fake;

import mob.tdd.Board;
import mob.tdd.CellValue;
import mob.tdd.GameOutput;

import java.util.LinkedList;
import java.util.Queue;

public class FakeGameOutput implements GameOutput {

    private Queue<CellValue[][]> printedBoard = new LinkedList<>();

    public CellValue[][] getNextPrintedBoard() {
        return printedBoard.poll();
    }

    @Override
    public void print(Board board) {
        if (board != null) {
            printedBoard.add(board.getState());
        }
    }
}
