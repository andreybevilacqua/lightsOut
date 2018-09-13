package processing;

import initializer.BoardObjectInitializer;
import initializer.PieceObjectInitializer;
import manipulator.CoordinateManipulator;
import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExecutorTest {

    private Board board;
    private ArrayList<Piece> pieces;
    private BoardObjectInitializer boardObjectInitializer;
    private PieceObjectInitializer pieceObjectInitializer;

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

            boardObjectInitializer = new BoardObjectInitializer(firstLine, secondLine);
            pieceObjectInitializer = new PieceObjectInitializer(thirdLine);

            board = boardObjectInitializer.getBoard();
            pieces = pieceObjectInitializer.getPieces();

            CoordinateManipulator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

            Assert.assertTrue(true);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}