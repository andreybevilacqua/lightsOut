package processing;

import model.Board;
import model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SortTest {

    private Board board;
    private ArrayList<Piece> pieces;
    private ObjectInitializer objectInitializer;

    private String fileName;

    @Test
    public void bubbleSortTest() {

        fileName = "00.txt";

        objectInitializer = new ObjectInitializer(fileName);

        board = objectInitializer.getBoard();
        pieces = objectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        ArrayList<Piece> orderedPieces = new Sort().bubbleSort(pieces);

        Assert.assertTrue(orderedPieces.size() == pieces.size());
        Assert.assertTrue(orderedPieces.get(0).getCoordinates().size() < orderedPieces.get(1).getCoordinates().size());
        Assert.assertTrue(orderedPieces.get(1).getCoordinates().size() < orderedPieces.get(2).getCoordinates().size());

        }
}