import initializer.BoardObjectInitializer;
import initializer.FinalBoardObjectInitializer;
import initializer.PieceObjectInitializer;
import model.Board;
import model.Piece;
import model.PieceCoordinate;
import manipulator.CoordinateManipulator;
import processing.Executor;
import processing.ReadFile;
import solution.Strategy;

import java.io.FileNotFoundException;
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

        String result;

        try{
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

            CoordinateManipulator.findAllPossiblieCoordinateOptionsForEachPiece(board, pieces);

            Executor executor = new Executor(board, finalBoard, pieces);

            resultedList = executor.execute(Strategy.CIRCULAR_LOOP);

            if(resultedList == null){
                result = "Didn't found the solution.";
            } else{
                result = executor.prepareResult(resultedList);
            }

            System.out.println(result);

        } catch (FileNotFoundException e){
            System.out.println("File was not found. Please add the input file in 'resources' folder");
        }


    }
}
