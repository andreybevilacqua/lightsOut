package processing;

import initializer.BoardInitializer;
import initializer.PieceInitializer;
import manipulator.CoordinateManipulator;
import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class ExecutorTest {

    private Board board;
    private List<Piece> pieces;
    private BoardInitializer boardInitializer;
    private PieceInitializer pieceInitializer;

    private static ReadFile readFile;

    private String firstLine;
    private String secondLine;
    private String thirdLine;

    @Test
    public void circularLoopSolutionTest(){

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

            Assert.assertTrue(true);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}