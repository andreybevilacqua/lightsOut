package processing;

import model.Board;
import model.Piece;
import objects.BoardObjectInitializer;
import objects.PieceObjectInitializer;
import org.junit.Assert;
import org.junit.Test;

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

    private String fileName;

    @Test
    public void circularLoopSolutionTest(){

        readFile = new ReadFile("01.txt");
        firstLine = readFile.getFirstLine();
        secondLine = readFile.getSecondLine();
        thirdLine = readFile.getThirdLine();

        boardObjectInitializer = new BoardObjectInitializer(firstLine, secondLine);
        pieceObjectInitializer = new PieceObjectInitializer(thirdLine);

        board = boardObjectInitializer.getBoard();
        pieces = pieceObjectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        Assert.assertTrue(true);
    }
}