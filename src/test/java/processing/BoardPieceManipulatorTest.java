package processing;

import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BoardPieceManipulatorTest {


    private Board board;
    private ArrayList<Piece> pieces;
    private ObjectInitializer objectInitializer;

    private String fileName;

    @Test
    public void applyPieceInBoardInDesiredCoordinateTest() {

        fileName = "01.txt";

        objectInitializer = new ObjectInitializer(fileName);

        board = objectInitializer.getBoard();
        pieces = objectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        BoardPieceManipulator boardPieceManipulator = new BoardPieceManipulator();

        Board anotherBoard = new Board(board.getLineSize(), board.getColumnSize(), board.getDepth());

        anotherBoard.setBoard(boardPieceManipulator.copyAllValuesFromPreviousBoardToAnotherBoard(anotherBoard, board.getBoard()));

        boardPieceManipulator.applyPieceInBoardInDesiredCoordinate(pieces.get(4), anotherBoard, pieces.get(4).getCoordinates().get(1));

        Assert.assertTrue(anotherBoard.getBoard()[1][0] == 0);
        Assert.assertTrue(anotherBoard.getBoard()[1][1] == 0);
        Assert.assertTrue(anotherBoard.getBoard()[2][0] == 0);
        Assert.assertTrue(anotherBoard.getBoard()[2][1] == 0);

        anotherBoard.setBoard(boardPieceManipulator.copyAllValuesFromPreviousBoardToAnotherBoard(anotherBoard, board.getBoard()));
        boardPieceManipulator.applyPieceInBoardInDesiredCoordinate(pieces.get(4), anotherBoard, pieces.get(4).getCoordinates().get(2));

        Assert.assertTrue(anotherBoard.getBoard()[0][1] == 1);
        Assert.assertTrue(anotherBoard.getBoard()[0][2] == 0);
        Assert.assertTrue(anotherBoard.getBoard()[1][1] == 0);
        Assert.assertTrue(anotherBoard.getBoard()[1][2] == 0);

        anotherBoard.setBoard(boardPieceManipulator.copyAllValuesFromPreviousBoardToAnotherBoard(anotherBoard, board.getBoard()));
        boardPieceManipulator.applyPieceInBoardInDesiredCoordinate(pieces.get(4), anotherBoard, pieces.get(4).getCoordinates().get(3));

        Assert.assertTrue(anotherBoard.getBoard()[1][1] == 1);
        Assert.assertTrue(anotherBoard.getBoard()[1][2] == 1);
        Assert.assertTrue(anotherBoard.getBoard()[2][1] == 1);
        Assert.assertTrue(anotherBoard.getBoard()[2][2] == 0);
    }
}