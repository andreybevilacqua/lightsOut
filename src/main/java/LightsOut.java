import model.Board;
import model.Piece;
import model.PieceCoordinate;
import processing.CoordinateGenerator;
import processing.Executor;
import processing.ObjectInitializer;

import java.util.ArrayList;

public class LightsOut {

    private static ObjectInitializer objectInitializer;

    private static Board board;
    private static Board finalBoard;
    private static ArrayList<Piece> pieces;
    private static ArrayList<PieceCoordinate> resultedList;

    public static void main(String[] args) {

        String fileName = "01.txt";

        objectInitializer = new ObjectInitializer(fileName);

        board = objectInitializer.getBoard();
        finalBoard = objectInitializer.getFinalBoard();

        pieces = objectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        Executor executor = new Executor(board, finalBoard, pieces);

        //String strategy = "bruteForceSolution";
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
