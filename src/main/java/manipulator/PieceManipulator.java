package manipulator;

import model.Board;
import model.Coordinate;
import model.Piece;

import java.util.ArrayList;

public class PieceManipulator {

    public void applyPieceInBoardInDesiredCoordinate(Piece piece, Board board, Coordinate coordinate) {

        int boardLine = coordinate.getXCoordinate();
        int boardColumn = coordinate.getYCoordinate();

        for(int line = 0; line < piece.getLineSize(); line++){
            for (int column = 0; column < piece.getColumnSize(); column++){
                if(piece.getCellValue(line, column) == 'X' ){
                    board.incrementBoardCell(boardLine, boardColumn);
                }
                boardColumn++;
            }
            boardColumn = coordinate.getYCoordinate();
            boardLine++;
        }
    }

    public void populateDefaultPositionOfEachPiece(ArrayList<Piece> pieces, int[] defaultPositionOfEachPiece){
        for(int i = 0; i < pieces.size(); i++){
            defaultPositionOfEachPiece[i] = 0;
        }
    }
}
