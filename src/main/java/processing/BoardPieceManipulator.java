package processing;

import model.Board;
import model.Coordinate;
import model.Piece;

public class BoardPieceManipulator {

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

    public int[][] copyAllValuesFromPreviousBoardToAnotherBoard(Board newBoard, int[][] matrixToBeCopied){
        int[][] copyMatrix = new int[newBoard.getLineSize()][newBoard.getColumnSize()];

        for(int i = 0; i < matrixToBeCopied.length; i++){
            for(int j = 0; j < matrixToBeCopied[0].length; j++){
                copyMatrix[i][j] = matrixToBeCopied[i][j];
            }
        }
        return copyMatrix;
    }

}
