package processing;

import model.Board;
import model.Piece;
import model.PieceCoordinate;
import solution.BruteForceSolution;
import solution.CircularLoopSolution;
import solution.Strategy;

import java.util.ArrayList;
import java.util.Comparator;

public class Executor {

    private ArrayList<Piece> pieces;
    private ArrayList<Piece> piecesBackup;

    private BruteForceSolution bruteForceSolution;
    private CircularLoopSolution circularLoopSolution;

    public Executor(){ }

    public Executor(Board board, Board finalBoard, ArrayList<Piece> pieces){
        this.pieces = pieces;
        this.piecesBackup = new ArrayList<>();

        bruteForceSolution = new BruteForceSolution(board, finalBoard, pieces);
        circularLoopSolution = new CircularLoopSolution(board, finalBoard, pieces, piecesBackup);
    }

    public ArrayList<PieceCoordinate> execute(Strategy strategy){

        piecesBackup.addAll(pieces);

        pieces.sort(Comparator.comparingInt(piece -> piece.getCoordinates().size()));

        if(strategy.equals(Strategy.CIRCULAR_LOOP)){
            return circularLoopSolution.solution();
        } else {
            return bruteForceSolution.solution();
        }
    }

    public String prepareResult(ArrayList<PieceCoordinate> resultedList){
        StringBuilder coordinates = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(PieceCoordinate pc : resultedList){
            coordinates.append(pc.getCoordinate().getX()).append(",").append(pc.getCoordinate().getY());
            result.append(coordinates.toString()).append(" ");
            coordinates.setLength(0);
        }

        return result.toString();
    }

    public ArrayList<PieceCoordinate> prepareResult(ArrayList<Piece> auxListOfPieces, ArrayList<PieceCoordinate> pieceCoordinates){
        ArrayList<PieceCoordinate> resultedList = new ArrayList();

        for(Piece piece : auxListOfPieces){
            for(PieceCoordinate pieceCoordinate : pieceCoordinates){
                if(pieceCoordinate.getPiece().generateDeepHashCode() == piece.generateDeepHashCode() ){
                    resultedList.add(pieceCoordinate);
                }
            }
        }
        return resultedList;
    }
}
