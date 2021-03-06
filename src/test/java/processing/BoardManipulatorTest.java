package processing;

import initializer.BoardInitializer;
import initializer.PieceInitializer;
import manipulator.BoardManipulator;
import manipulator.CoordinateManipulator;
import manipulator.PieceManipulator;
import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class BoardManipulatorTest {


    private Board board;
    private List<Piece> pieces;
    private BoardInitializer boardInitializer;
    private PieceInitializer pieceInitializer;

    private static ReadFile readFile;

    private String firstLine;
    private String secondLine;
    private String thirdLine;

    @Test
    public void applyPieceInBoardInDesiredCoordinateTest() {

        try{
            readFile = new ReadFile("01.txt");

            firstLine = readFile.getFirstLine();
            secondLine = readFile.getSecondLine();
            thirdLine = readFile.getThirdLine();

            boardInitializer = new BoardInitializer(firstLine, secondLine);
            pieceInitializer = new PieceInitializer(thirdLine);

            board = boardInitializer.getBoard();
            pieces = pieceInitializer.getPieces();

            CoordinateManipulator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

            BoardManipulator boardManipulator = new BoardManipulator();
            PieceManipulator pieceManipulator = new PieceManipulator();

            Board anotherBoard = new Board(board.getLineSize(), board.getColumnSize(), board.getDepth());

            anotherBoard.setBoard(boardManipulator.copyAllValuesFromPreviousBoardToAnotherBoard(anotherBoard, board.getBoard()));

            pieceManipulator.applyPieceInBoard(pieces.get(4), anotherBoard, pieces.get(4).getCoordinates().get(1));

            Assert.assertTrue(anotherBoard.getBoard()[1][0] == 0);
            Assert.assertTrue(anotherBoard.getBoard()[1][1] == 0);
            Assert.assertTrue(anotherBoard.getBoard()[2][0] == 0);
            Assert.assertTrue(anotherBoard.getBoard()[2][1] == 0);

            anotherBoard.setBoard(boardManipulator.copyAllValuesFromPreviousBoardToAnotherBoard(anotherBoard, board.getBoard()));
            pieceManipulator.applyPieceInBoard(pieces.get(4), anotherBoard, pieces.get(4).getCoordinates().get(2));

            Assert.assertTrue(anotherBoard.getBoard()[0][1] == 1);
            Assert.assertTrue(anotherBoard.getBoard()[0][2] == 0);
            Assert.assertTrue(anotherBoard.getBoard()[1][1] == 0);
            Assert.assertTrue(anotherBoard.getBoard()[1][2] == 0);

            anotherBoard.setBoard(boardManipulator.copyAllValuesFromPreviousBoardToAnotherBoard(anotherBoard, board.getBoard()));
            pieceManipulator.applyPieceInBoard(pieces.get(4), anotherBoard, pieces.get(4).getCoordinates().get(3));

            Assert.assertTrue(anotherBoard.getBoard()[1][1] == 1);
            Assert.assertTrue(anotherBoard.getBoard()[1][2] == 1);
            Assert.assertTrue(anotherBoard.getBoard()[2][1] == 1);
            Assert.assertTrue(anotherBoard.getBoard()[2][2] == 0);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}