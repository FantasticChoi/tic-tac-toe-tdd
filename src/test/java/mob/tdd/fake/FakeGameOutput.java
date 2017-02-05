package mob.tdd.fake;

import mob.tdd.Board;
import mob.tdd.Classic2DBoard;
import mob.tdd.GameOutput;

import java.util.LinkedList;
import java.util.Queue;

public class FakeGameOutput implements GameOutput {

    private Queue<Classic2DBoard.CellValue[][]> printedBoard = new LinkedList<>();

    public Classic2DBoard.CellValue[][] getNextPrintedBoard() {
        return printedBoard.poll();
    }

    @Override
    public void print(Board board) {
        if (board != null) {
            printedBoard.add(board.getState());
        }
    }
}
