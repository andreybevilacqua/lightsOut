package processing;

import model.Board;
import model.Coordinate;
import model.Piece;

import java.util.ArrayList;

public class CoordinateGenerator {

    public static void findAllPossiblieCoordinateOptionsForEachPiece(Board board, ArrayList<Piece> pieces) {

        int quantityOfPossibleOptions = 1;

        int pieceLineSize;
        int pieceColumnSize;

        int lineCoordinateCounter = 0;
        int columnCoordinateCounter = 0;

        boolean didIChangeLine;

        ArrayList<Coordinate> coordinates = new ArrayList<>();

        for (Piece piece : pieces) {

            quantityOfPossibleOptions = calculateQuantityOfPossibleOptions(board, piece);

            pieceLineSize = piece.getLineSize();
            pieceColumnSize = piece.getColumnSize();

            while (pieceLineSize <= board.getLineSize() &&
                    pieceColumnSize <= board.getColumnSize()) {

                didIChangeLine = false;

                Coordinate coordinate = new Coordinate(lineCoordinateCounter, columnCoordinateCounter);
                coordinates.add(coordinate);

                if (quantityOfPossibleOptions == 1) {
                    pieceLineSize++;
                    pieceColumnSize++;
                } else {

                    if (pieceLineSize < board.getLineSize()) {
                        lineCoordinateCounter++;
                        pieceLineSize++;
                        didIChangeLine = true;
                    }

                    if (pieceColumnSize < board.getColumnSize() && didIChangeLine == false) {
                        columnCoordinateCounter++;
                        pieceColumnSize++;
                    }

                    if (pieceLineSize == board.getLineSize() &&
                            pieceColumnSize == board.getColumnSize() &&
                            coordinates.size() == (quantityOfPossibleOptions - 1)) {

                        Coordinate lastCoordinate = new Coordinate(lineCoordinateCounter, columnCoordinateCounter);
                        coordinates.add(lastCoordinate);

                        pieceLineSize++;
                        pieceColumnSize++;

                    } else if (pieceLineSize >= board.getLineSize() &&
                            pieceColumnSize <= board.getColumnSize()) {

                        if (coordinates.get(coordinates.size() - 1).getXCoordinate() == lineCoordinateCounter) {
                            lineCoordinateCounter = 0;
                            pieceLineSize = piece.getLineSize();
                        }

                    }

                }
            }

            piece.addAllCoordinatesIntoCoordinateList(coordinates);
            coordinates.clear();
            lineCoordinateCounter = 0;
            columnCoordinateCounter = 0;
        }
    }

    private static int calculateQuantityOfPossibleOptions(Board board, Piece piece) {

        int quantityOfPossibleOptions = 0;

        // If the size of line or column be equals of board, their values should be one.
        int lineDifference = 1;
        int columnDifference = 1;

        int pieceLineSize = piece.getLineSize();
        int pieceColumnSize = piece.getColumnSize();

        if (pieceLineSize < board.getLineSize()) {
            lineDifference = (board.getLineSize() - pieceLineSize) + 1;
        }

        if (pieceColumnSize < board.getColumnSize()) {
            columnDifference = (board.getColumnSize() - pieceColumnSize) + 1;
        }

        quantityOfPossibleOptions = lineDifference * columnDifference;

        return quantityOfPossibleOptions;
    }
}
