package mob.tdd.game.fake;

import mob.tdd.game.Board;
import mob.tdd.game.CellValue;
import mob.tdd.game.executor.GameOutput;

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
