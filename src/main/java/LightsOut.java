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

        String fileName = "00.txt";

        objectInitializer = new ObjectInitializer(fileName);

        board = objectInitializer.getBoard();
        finalBoard = objectInitializer.getFinalBoard();

        pieces = objectInitializer.getPieces();

        CoordinateGenerator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

        Executor executor = new Executor(board, finalBoard, pieces);

        resultedList = executor.execute();

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
            coordinates.append(pc.getCoordinate().getYCoordinate()).append(",").append(pc.getCoordinate().getXCoordinate());
            //coordinates.append(pc.getCoordinate().getXCoordinate()).append(",").append(pc.getCoordinate().getYCoordinate());
            result.append(coordinates.toString()).append(" ");
            coordinates.setLength(0);
        }

        return result.toString();
    }

}
