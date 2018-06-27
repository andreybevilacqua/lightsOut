package processing;

import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SortTest {

    private Board board;
    private ArrayList<Piece> pieces;
    private BoardObjectInitializer boardObjectInitializer;
    private PieceObjectInitializer pieceObjectInitializer;

    private static ReadFile readFile;

    private String firstLine;
    private String secondLine;
    private String thirdLine;

    @Test
    public void bubbleSortTest() {

        readFile = new ReadFile("00.txt");
        firstLine = readFile.getFirstLine();
        secondLine = readFile.getSecondLine();
        thirdLine = readFile.getThirdLine();

        boardObjectInitializer = new BoardObjectInitializer(firstLine, secondLine);
        pieceObjectInitializer = new PieceObjectInitializer(thirdLine);

        board = boardObjectInitializer.getBoard();
        pieces = pieceObjectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        ArrayList<Piece> orderedPieces = new Sort().bubbleSort(pieces);

        Assert.assertTrue(orderedPieces.size() == pieces.size());
        Assert.assertTrue(orderedPieces.get(0).getCoordinates().size() < orderedPieces.get(1).getCoordinates().size());
        Assert.assertTrue(orderedPieces.get(1).getCoordinates().size() < orderedPieces.get(2).getCoordinates().size());

        }
}