package mob.tdd.game;

import java.util.Arrays;

public class Classic2DBoard implements Board {

    private static final int BOARD_SIZE = 3;

    private final CellValue[][] boardState;

    public Classic2DBoard() {
        boardState = new CellValue[][] {
                {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY},
                {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY},
                {CellValue.EMPTY, CellValue.EMPTY, CellValue.EMPTY}
        };
    }

    @Override
    public CellValue[][] getState() {
        CellValue[][] boardStateCopy = new CellValue[BOARD_SIZE][BOARD_SIZE];
        for(int i = 0; i< boardState.length; i++) {
            boardStateCopy[i] = Arrays.copyOf(boardState[i], boardState[i].length);
        }
        return boardStateCopy;
    }

    @Override
    public void changeCellValue(Coordinate coordinate, CellValue cellValue) {
        final Coordinate validCoordinate = new LimitedSizeCoordinate(coordinate, BOARD_SIZE);
        final int row = validCoordinate.getRow() - 1;
        final int column = validCoordinate.getColumn() - 1;
        if (!boardState[row][column].equals(CellValue.EMPTY)) {
            throw new IllegalArgumentException("You are not be able to override not EMPTY cell");
        }
        boardState[row][column] = cellValue;
    }

    @Override
    public boolean hasDrawnLineFor(CellValue cellValue) {
        final CellValue[] line = {cellValue, cellValue, cellValue};
        return checkOrthogonalLines(line) || checkDiagonalLines(line);
    }

    private boolean checkDiagonalLines(CellValue[] line) {
        CellValue[] diagonalLine = new CellValue[BOARD_SIZE];
        int j = 0;
        for(int i = 0; i < boardState.length; i++) {
            diagonalLine[i] = boardState[i][j++];
        }
        if(Arrays.equals(diagonalLine, line)) {
            return true;
        } else {
            diagonalLine = new CellValue[BOARD_SIZE];
            j = 2;
            for(int i = 0; i < boardState.length; i++) {
                diagonalLine[i] = boardState[i][j--];
            }
        }
        return Arrays.equals(diagonalLine, line);
    }

    private boolean checkOrthogonalLines(CellValue[] line) {
        for (int j = 0; j < BOARD_SIZE; j++) {
            CellValue[] row = boardState[j];
            if(Arrays.equals(row, line)) {
                return true;
            }

            CellValue[] column = new CellValue[BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                column[i] = boardState[i][j];
            }
            if (Arrays.equals(column, line)) {
                return true;
            }
        }
        return false;
    }
}
