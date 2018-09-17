package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private int line;
    private int column;
    private int depth;

    private Board board;
    private Board board1;

    @Before
    public void setup(){
        line = 2;
        column = 2;
        depth = 2;
    }

    @Test
    public void createBoardTest(){

        board = new Board(line, column, depth);
        Assert.assertEquals(2,board.getBoard().length);
        Assert.assertEquals(2, board.getBoard()[1].length);
        Assert.assertEquals(2, board.getDepth());

        board1 = new Board(0, 0, 1);
        Assert.assertEquals(1, board1.getBoard().length);
        Assert.assertEquals(2, board1.getDepth());
    }

    @Test
    public void insertValueIntoCellTest(){

        board = new Board(line, column, depth);

        board.insertValue(0, 0, 0);
        Assert.assertTrue(board.getCellValue(0,0) == 0);

        board.incrementCell(0,0);
        Assert.assertTrue(board.getCellValue(0,0) == 1);

        board.incrementCell(0,0);
        Assert.assertTrue(board.getCellValue(0,0) == 0);
    }

}
