package processing;

import initializer.BoardInitializer;
import initializer.PieceInitializer;
import manipulator.CoordinateManipulator;
import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CoordinateManipulatorTest {

    private Board board;
    private List<Piece> pieces;
    private BoardInitializer boardInitializer;
    private PieceInitializer pieceInitializer;

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

        boardInitializer = new BoardInitializer(firstLine, secondLine);
        pieceInitializer = new PieceInitializer(thirdLine);

        board = boardInitializer.getBoard();
        pieces = pieceInitializer.getPieces();


        CoordinateManipulator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

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
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getX());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getY());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(1).getX());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(1).getY());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(2).getX());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(2).getY());

        // Piece 3
        Assert.assertEquals(0, pieces.get(2).getCoordinates().get(0).getX());
        Assert.assertEquals(0, pieces.get(2).getCoordinates().get(0).getY());

        Assert.assertEquals(1, pieces.get(2).getCoordinates().get(1).getX());
        Assert.assertEquals(0, pieces.get(2).getCoordinates().get(1).getY());

        // Piece 9
        Assert.assertEquals(0, pieces.get(8).getCoordinates().get(0).getX());
        Assert.assertEquals(0, pieces.get(8).getCoordinates().get(0).getY());

    }

    @Test
    public void findAllPossiblieCoordinateOptionsForEachPieceWithFile02Test() throws Exception {

        readFile = new ReadFile("02.txt");
        firstLine = readFile.getFirstLine();
        secondLine = readFile.getSecondLine();
        thirdLine = readFile.getThirdLine();

        boardInitializer = new BoardInitializer(firstLine, secondLine);
        pieceInitializer = new PieceInitializer(thirdLine);

        board = boardInitializer.getBoard();
        pieces = pieceInitializer.getPieces();

        CoordinateManipulator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

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
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getX());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(0).getY());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(1).getX());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(1).getY());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(2).getX());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(2).getY());

        Assert.assertEquals(3, pieces.get(0).getCoordinates().get(3).getX());
        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(3).getY());

        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(4).getX());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(4).getY());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(5).getX());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(5).getY());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(6).getX());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(6).getY());

        Assert.assertEquals(3, pieces.get(0).getCoordinates().get(7).getX());
        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(7).getY());

        Assert.assertEquals(0, pieces.get(0).getCoordinates().get(8).getX());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(8).getY());

        Assert.assertEquals(1, pieces.get(0).getCoordinates().get(9).getX());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(9).getY());

        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(10).getX());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(10).getY());

        Assert.assertEquals(3, pieces.get(0).getCoordinates().get(11).getX());
        Assert.assertEquals(2, pieces.get(0).getCoordinates().get(11).getY());

        // Piece 4
        Assert.assertEquals(0, pieces.get(3).getCoordinates().get(0).getX());
        Assert.assertEquals(0, pieces.get(3).getCoordinates().get(0).getY());

        Assert.assertEquals(1, pieces.get(3).getCoordinates().get(1).getX());
        Assert.assertEquals(0, pieces.get(3).getCoordinates().get(1).getY());
    }
}