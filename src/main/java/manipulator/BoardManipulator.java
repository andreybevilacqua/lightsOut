package manipulator;

import model.Board;
import model.Piece;

public class BoardManipulator {

    private PieceManipulator pieceManipulator;

    public BoardManipulator(){
        pieceManipulator = new PieceManipulator();
    }

    public Board createAndPrepareNewBoard(Board board, Piece piece, int coordinatePosition){
        Board newBoard = new Board(board.getLineSize(), board.getColumnSize(), board.getDepth());

        newBoard.setBoard(copyAllValuesFromPreviousBoardToAnotherBoard(newBoard, board.getBoard()));

        pieceManipulator.applyPieceInBoardInDesiredCoordinate(piece, newBoard, piece.getCoordinates().get(coordinatePosition));

        return newBoard;
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
