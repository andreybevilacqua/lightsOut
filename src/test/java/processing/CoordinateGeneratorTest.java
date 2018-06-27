package processing;

import model.Board;
import model.Piece;
import objects.BoardObjectInitializer;
import objects.PieceObjectInitializer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CoordinateGeneratorTest {

    private Board board;
    private ArrayList<Piece> pieces;
    private BoardObjectInitializer boardObjectInitializer;
    private PieceObjectInitializer pieceObjectInitializer;

    private static ReadFile readFile;

    private String firstLine;
    private String secondLine;
    private String thirdLine;

    @Test
    public void findAllPossiblieCoordinateOptionsForEachPieceWithFile01Test() throws Exception {

        readFile = new ReadFile("01.txt");
        firstLine = readFile.getFirstLine();
        secondLine = readFile.getSecondLine();
        thirdLine = readFile.getThirdLine();

        boardObjectInitializer = new BoardObjectInitializer(firstLine, secondLine);
        pieceObjectInitializer = new PieceObjectInitializer(thirdLine);

        board = boardObjectInitializer.getBoard();
        pieces = pieceObjectInitializer.getPieces();


        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        Assert.assertEquals(3, pieces.get(0).getCoordinates().size());
        Assert.assertEquals(3, pieces.get(1).getCoordinates().size());
        Assert.assertEquals(2, pieces.get(2).getCoordinates().size());
        Assert.assertEquals(9, pieces.get(3).getCoordinates().size());
        Assert.assertEquals(4, pieces.get(4).getCoordinates().size());
        Assert.assertEquals(2, pieces.get(5).getCoordinates().size());
        Assert.assertEquals(3, pieces.get(6).getCoordinates().size());
        Assert.assertEquals(2, pieces.get(7).getCoordinates().size());
        Assert.assertEquals(1, pieces.get(8).getCoordinates().size());
        Assert.assertEquals(3, pieces.get(9).getCoordinates().size());

        // Piece 1
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getXCoordinate());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getYCoordinate());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(1).getXCoordinate());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(1).getYCoordinate());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(2).getXCoordinate());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(2).getYCoordinate());

        // Piece 3
        Assert.assertEquals(0, pieces.get(2).getCoordinates().get(0).getXCoordinate());
        Assert.assertEquals(0, pieces.get(2).getCoordinates().get(0).getYCoordinate());

        Assert.assertEquals(1, pieces.get(2).getCoordinates().get(1).getXCoordinate());
        Assert.assertEquals(0, pieces.get(2).getCoordinates().get(1).getYCoordinate());

        // Piece 9
        Assert.assertEquals(0, pieces.get(8).getCoordinates().get(0).getXCoordinate());
        Assert.assertEquals(0, pieces.get(8).getCoordinates().get(0).getYCoordinate());

    }

    @Test
    public void findAllPossiblieCoordinateOptionsForEachPieceWithFile02Test() throws Exception {

        readFile = new ReadFile("02.txt");
        firstLine = readFile.getFirstLine();
        secondLine = readFile.getSecondLine();
        thirdLine = readFile.getThirdLine();

        boardObjectInitializer = new BoardObjectInitializer(firstLine, secondLine);
        pieceObjectInitializer = new PieceObjectInitializer(thirdLine);

        board = boardObjectInitializer.getBoard();
        pieces = pieceObjectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        Assert.assertTrue(pieces.size() == 9);

        Assert.assertEquals(12, pieces.get(0).getCoordinates().size());
        Assert.assertEquals(12, pieces.get(1).getCoordinates().size());
        Assert.assertEquals(3, pieces.get(2).getCoordinates().size());
        Assert.assertEquals(2, pieces.get(3).getCoordinates().size());
        Assert.assertEquals(6, pieces.get(4).getCoordinates().size());
        Assert.assertEquals(12, pieces.get(5).getCoordinates().size());
        Assert.assertEquals(12, pieces.get(6).getCoordinates().size());
        Assert.assertEquals(3, pieces.get(7).getCoordinates().size());
        Assert.assertEquals(4, pieces.get(8).getCoordinates().size());

        // Piece 1
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getXCoordinate());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getYCoordinate());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(1).getXCoordinate());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(1).getYCoordinate());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(2).getXCoordinate());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(2).getYCoordinate());

        Assert.assertEquals(3, pieces.get(0).getCoordinates().get(3).getXCoordinate());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(3).getYCoordinate());

        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(4).getXCoordinate());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(4).getYCoordinate());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(5).getXCoordinate());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(5).getYCoordinate());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(6).getXCoordinate());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(6).getYCoordinate());

        Assert.assertEquals(3, pieces.get(0).getCoordinates().get(7).getXCoordinate());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(7).getYCoordinate());

        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(8).getXCoordinate());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(8).getYCoordinate());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(9).getXCoordinate());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(9).getYCoordinate());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(10).getXCoordinate());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(10).getYCoordinate());

        Assert.assertEquals(3, pieces.get(0).getCoordinates().get(11).getXCoordinate());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(11).getYCoordinate());

        // Piece 4
        Assert.assertEquals(0, pieces.get(3).getCoordinates().get(0).getXCoordinate());
        Assert.assertEquals(0, pieces.get(3).getCoordinates().get(0).getYCoordinate());

        Assert.assertEquals(1, pieces.get(3).getCoordinates().get(1).getXCoordinate());
        Assert.assertEquals(0, pieces.get(3).getCoordinates().get(1).getYCoordinate());
    }
}