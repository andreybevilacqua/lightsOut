import model.Board;
import model.Piece;
import model.PieceCoordinate;
import initializer.BoardObjectInitializer;
import initializer.FinalBoardObjectInitializer;
import initializer.PieceObjectInitializer;
import processing.*;

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

        readFile = new ReadFile("01.txt");

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

        // Criar um ENUM chamado Strategies. Definir as Strings de estrategias nesse enum.
        String strategy = "circularLoopSolution";

        resultedList = executor.execute(strategy);

        if(resultedList == null){
            System.out.println("Didn't found the solution.");
        } else{
            System.out.println(prepareResult(resultedList));
        }

    }

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
