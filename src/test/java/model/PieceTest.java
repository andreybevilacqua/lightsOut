package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PieceTest {

    private int line;
    private int column;

    private Piece piece;

    @Before
    public void setup(){
        line = 2;
        column = 2;
    }

    @Test
    public void createPieceTest(){
        piece = new Piece(line, column);
        Assert.assertEquals(2, piece.getPiece().length);
        Assert.assertEquals(2, piece.getPiece()[0].length);

        piece = new Piece(0, 0);
        Assert.assertEquals(1, piece.getPiece().length);
        Assert.assertEquals(1, piece.getPiece()[0].length);
    }

    @Test
    public void insertValueIntoPieceTest(){
        piece = new Piece(line, column);

        piece.insertX(0,0);
        Assert.assertEquals('X', piece.getCellValue(0,0));

        piece.insertDot( 0, 0);
        Assert.assertEquals('.', piece.getCellValue(0,0));
    }

}
