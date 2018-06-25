package processing;

import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ExecutorTest {

    private Board board;
    private ArrayList<Piece> pieces;
    private ObjectInitializer objectInitializer;

    private String fileName;

    @Test
    public void circularLoopSolutionTest(){
        fileName = "01.txt";

        objectInitializer = new ObjectInitializer(fileName);

        board = objectInitializer.getBoard();
        pieces = objectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        Assert.assertTrue(true);
    }
}