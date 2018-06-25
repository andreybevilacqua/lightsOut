package processing;

import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ObjectInitializerTest {

    private ObjectInitializer objectInitializer;

    private Board board;

    private ArrayList<Piece> pieces;

    private String fileName;

    @Test
    public void objectInitializerTestWithFirstFile(){
        fileName = "01.txt";
        objectInitializer = new ObjectInitializer(fileName);

        board = objectInitializer.getBoard();
        pieces = objectInitializer.getPieces();

        // Board validation.
        Assert.assertTrue(board.getDepth() == 2);
        Assert.assertTrue(board.getLineSize() == 3);
        Assert.assertTrue(board.getColumnSize() == 3);

        Assert.assertEquals(1, board.getCellValue(0,0));
        Assert.assertEquals(0, board.getCellValue(0,1));
        Assert.assertEquals(0, board.getCellValue(0,2));

        Assert.assertEquals(1, board.getCellValue(1,0));
        Assert.assertEquals(0, board.getCellValue(1,1));
        Assert.assertEquals(1, board.getCellValue(1,2));

        Assert.assertEquals(0, board.getCellValue(2,0));
        Assert.assertEquals(1, board.getCellValue(2,1));
        Assert.assertEquals(1, board.getCellValue(2,2));

        // Pieces validation.
        Assert.assertEquals(10, pieces.size());
        Assert.assertEquals(1, pieces.get(0).getLineSize());
        Assert.assertEquals(3, pieces.get(0).getColumnSize());

        Assert.assertEquals('.', pieces.get(0).getCellValue(0,0));
        Assert.assertEquals('.', pieces.get(0).getCellValue(0,1));
        Assert.assertEquals('X', pieces.get(0).getCellValue(0,2));

        Assert.assertEquals('X', pieces.get(2).getCellValue(0, 0));
        Assert.assertEquals('.', pieces.get(2).getCellValue(0, 1));
        Assert.assertEquals('.', pieces.get(2).getCellValue(0, 2));
        Assert.assertEquals('X', pieces.get(2).getCellValue(1, 0));
    }

    @Test
    public void objectInitializerTestWithThirdFile(){
        fileName = "03.txt";
        objectInitializer = new ObjectInitializer(fileName);

        board = objectInitializer.getBoard();
        pieces = objectInitializer.getPieces();

        // Board validation.
        Assert.assertTrue(board.getDepth() == 3);
        Assert.assertTrue(board.getLineSize() == 6);
        Assert.assertTrue(board.getColumnSize() == 4);

        Assert.assertEquals(2, board.getCellValue(0,0));
        Assert.assertEquals(1, board.getCellValue(0,1));
        Assert.assertEquals(2, board.getCellValue(0,2));
        Assert.assertEquals(1, board.getCellValue(0,3));

        Assert.assertEquals(2, board.getCellValue(1,0));
        Assert.assertEquals(2, board.getCellValue(1,1));
        Assert.assertEquals(1, board.getCellValue(1,2));
        Assert.assertEquals(2, board.getCellValue(1,3));

        Assert.assertEquals(1, board.getCellValue(2,0));
        Assert.assertEquals(0, board.getCellValue(2,1));
        Assert.assertEquals(0, board.getCellValue(2,2));
        Assert.assertEquals(1, board.getCellValue(2,3));

        Assert.assertEquals(2, board.getCellValue(3,0));
        Assert.assertEquals(0, board.getCellValue(3,1));
        Assert.assertEquals(1, board.getCellValue(3,2));
        Assert.assertEquals(1, board.getCellValue(3,3));

        Assert.assertEquals(1, board.getCellValue(4,0));
        Assert.assertEquals(2, board.getCellValue(4,1));
        Assert.assertEquals(1, board.getCellValue(4,2));
        Assert.assertEquals(1, board.getCellValue(4,3));

        Assert.assertEquals(2, board.getCellValue(5,0));
        Assert.assertEquals(1, board.getCellValue(5,1));
        Assert.assertEquals(1, board.getCellValue(5,2));
        Assert.assertEquals(1, board.getCellValue(5,3));

        // Pieces validation.
        Assert.assertEquals(27, pieces.size());
        Assert.assertEquals(1, pieces.get(0).getLineSize());
        Assert.assertEquals(4, pieces.get(0).getColumnSize());

        Assert.assertEquals('X', pieces.get(0).getCellValue(0,0));
        Assert.assertEquals('.', pieces.get(0).getCellValue(0,1));
        Assert.assertEquals('.', pieces.get(0).getCellValue(0,2));
        Assert.assertEquals('.', pieces.get(0).getCellValue(0,3));

        Assert.assertEquals('X', pieces.get(3).getCellValue(0,0));
        Assert.assertEquals('X', pieces.get(3).getCellValue(0,1));
        Assert.assertEquals('.', pieces.get(3).getCellValue(0,2));
        Assert.assertEquals('.', pieces.get(3).getCellValue(0,3));

        Assert.assertEquals('X', pieces.get(3).getCellValue(1,0));
        Assert.assertEquals('X', pieces.get(3).getCellValue(1,1));
        Assert.assertEquals('X', pieces.get(3).getCellValue(1,2));
        Assert.assertEquals('\u0000', pieces.get(3).getCellValue(1,3));
    }

}
