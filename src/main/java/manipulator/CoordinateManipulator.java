package manipulator;

import model.Board;
import model.Coordinate;
import model.Piece;

import java.util.ArrayList;
import java.util.List;

public class CoordinateManipulator {

    public static void findAllPossiblieCoordinateOptionsForEachPiece(Board board, List<Piece> pieces) {
        int totalPossibleOptions;

        int pieceLineSize;
        int pieceColumnSize;

        int lineCoordinateCounter = 0;
        int columnCoordinateCounter = 0;

        boolean didIChangeLine;

        List<Coordinate> coordinates = new ArrayList<>();

        for (Piece piece : pieces) {

            totalPossibleOptions = calculateTotalPossibleOptions(board, piece);

            pieceLineSize = piece.getLineSize();
            pieceColumnSize = piece.getColumnSize();

            while (pieceLineSize <= board.getLineSize() &&
                    pieceColumnSize <= board.getColumnSize()) {

                didIChangeLine = false;

                Coordinate coordinate = new Coordinate(lineCoordinateCounter, columnCoordinateCounter);
                coordinates.add(coordinate);

                if (totalPossibleOptions == 1) {
                    pieceLineSize++;
                    pieceColumnSize++;
                } else {

                    if (pieceLineSize < board.getLineSize()) {
                        lineCoordinateCounter++;
                        pieceLineSize++;
                        didIChangeLine = true;
                    }

                    if (pieceColumnSize < board.getColumnSize() && !didIChangeLine) {
                        columnCoordinateCounter++;
                        pieceColumnSize++;
                    }

                    if (pieceLineSize == board.getLineSize() &&
                            pieceColumnSize == board.getColumnSize() &&
                            coordinates.size() == (totalPossibleOptions - 1)) {

                        Coordinate lastCoordinate = new Coordinate(lineCoordinateCounter, columnCoordinateCounter);
                        coordinates.add(lastCoordinate);

                        pieceLineSize++;
                        pieceColumnSize++;

                    } else if (pieceLineSize >= board.getLineSize() &&
                            pieceColumnSize <= board.getColumnSize()) {

                        if (coordinates.get(coordinates.size() - 1).getX() == lineCoordinateCounter) {
                            lineCoordinateCounter = 0;
                            pieceLineSize = piece.getLineSize();
                        }
                    }
                }
            }
            piece.addAllCoordinates(coordinates);
            coordinates.clear();
            lineCoordinateCounter = 0;
            columnCoordinateCounter = 0;
        }
    }

    private static int calculateTotalPossibleOptions(Board board, Piece piece) {
        // If the size of line or column be equals of board, their values should be one.
        int lineDifference = (board.getLineSize() - piece.getLineSize()) + 1;
        int columnDifference = (board.getColumnSize() - piece.getColumnSize()) + 1;

        return lineDifference * columnDifference;
    }
}
