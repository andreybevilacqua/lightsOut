package manipulator;

import model.Board;
import model.Coordinate;
import model.Piece;

public class PieceManipulator {

    public void applyPieceInBoard(Piece piece, Board board, Coordinate desiredCoordinate) {

        int boardLine = desiredCoordinate.getX();
        int boardColumn = desiredCoordinate.getY();

        for(int line = 0; line < piece.getLineSize(); line++){
            for (int column = 0; column < piece.getColumnSize(); column++){
                if(piece.getCellValue(line, column) == 'X' ){
                    board.incrementCell(boardLine, boardColumn);
                }
                boardColumn++;
            }
            boardColumn = desiredCoordinate.getY();
            boardLine++;
        }
    }
}
