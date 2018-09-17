package manipulator;

import model.Board;
import model.Piece;

import java.util.Arrays;

public class BoardManipulator {

    private PieceManipulator pieceManipulator;

    public BoardManipulator(){
        pieceManipulator = new PieceManipulator();
    }

    public Board createNewBoard(Board board, Piece piece, int coordinatePosition){
        Board newBoard = new Board(board.getLineSize(), board.getColumnSize(), board.getDepth());

        prepareNewBoard(board, newBoard);

        pieceManipulator.applyPieceInBoard(piece, newBoard, piece.getCoordinates().get(coordinatePosition));

        return newBoard;
    }

    private void prepareNewBoard(Board board, Board newBoard){
        newBoard.setBoard(copyAllValuesFromPreviousBoardToAnotherBoard(newBoard, board.getBoard()));
    }

    public int[][] copyAllValuesFromPreviousBoardToAnotherBoard(Board newBoard, int[][] matrixToBeCopied){
        int[][] copy = new int[newBoard.getLineSize()][newBoard.getColumnSize()];
        for(int i = 0; i < matrixToBeCopied.length; i++){
            copy[i] = Arrays.copyOf(matrixToBeCopied[i], matrixToBeCopied[i].length);
        }
        return copy;
    }

}
