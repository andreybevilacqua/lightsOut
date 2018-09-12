import model.Board;
import model.Piece;
import model.PieceCoordinate;
import initializer.BoardObjectInitializer;
import initializer.FinalBoardObjectInitializer;
import initializer.PieceObjectInitializer;
import processing.*;
import solution.Strategy;

import java.util.ArrayList;

public class LightsOut {

    private static BoardObjectInitializer boardObjectInitializer;
    private static FinalBoardObjectInitializer finalBoardObjectInitializer;
    private static PieceObjectInitializer pieceObjectInitializer;
    private static ReadFile readFile;

    private static Board board;
    private static Board finalBoard;
    private static ArrayList<Piece> pieces;
    private static ArrayList<PieceCoordinate> resultedList;

    public static void main(String[] args) {

        readFile = new ReadFile("00.txt");

        String firstLine = readFile.getFirstLine();
        String secondLine = readFile.getSecondLine();
        String thirdLine = readFile.getThirdLine();

        boardObjectInitializer = new BoardObjectInitializer(firstLine, secondLine);
        finalBoardObjectInitializer = new FinalBoardObjectInitializer();
        pieceObjectInitializer = new PieceObjectInitializer(thirdLine);

        board = boardObjectInitializer.getBoard();
        finalBoard = finalBoardObjectInitializer.initializeFinalBoard(board.getLineSize(),
                board.getColumnSize(), board.getDepth());

        pieces = pieceObjectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        Executor executor = new Executor(board, finalBoard, pieces);

        resultedList = executor.execute(Strategy.CIRCULAR_LOOP);

        if(resultedList == null){
            System.out.println("Didn't found the solution.");
        } else{
            System.out.println(prepareResult(resultedList));
        }

    }

    // Remover esse método daqui.
    private static String prepareResult(ArrayList<PieceCoordinate> resultedList){
        StringBuilder coordinates = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(PieceCoordinate pc : resultedList){
            coordinates.append(pc.getCoordinate().getXCoordinate()).append(",").append(pc.getCoordinate().getYCoordinate());
            result.append(coordinates.toString()).append(" ");
            coordinates.setLength(0);
        }

        return result.toString();
    }

}
