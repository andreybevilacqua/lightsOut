package processing;

import model.Board;
import model.Piece;
import model.PieceCoordinate;
import solution.BruteForceSolution;
import solution.CircularLoopSolution;
import solution.Strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Executor {

    private List<Piece> pieces;
    private List<Piece> piecesBackup;

    private BruteForceSolution bruteForceSolution;
    private CircularLoopSolution circularLoopSolution;

    public Executor(){ }

    public Executor(Board board, Board finalBoard, List<Piece> pieces){
        this.pieces = pieces;
        this.piecesBackup = new ArrayList<>();

        bruteForceSolution = new BruteForceSolution(board, finalBoard, pieces);
        circularLoopSolution = new CircularLoopSolution(board, finalBoard, pieces, piecesBackup);
    }

    public List<PieceCoordinate> execute(Strategy strategy){
        piecesBackup.addAll(pieces);

        pieces.sort(Comparator.comparingInt(piece -> piece.getCoordinates().size()));

        if(strategy.equals(Strategy.CIRCULAR_LOOP)){
            return circularLoopSolution.solution();
        } else {
            return bruteForceSolution.solution();
        }
    }

    public String prepareResult(List<PieceCoordinate> resultedList){
        StringBuilder coordinates = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(PieceCoordinate pc : resultedList){
            coordinates.append(pc.getCoordinate().getX()).append(",").append(pc.getCoordinate().getY());
            result.append(coordinates.toString()).append(" ");
            coordinates.setLength(0);
        }

        return result.toString();
    }

    public List<PieceCoordinate> prepareResult(List<Piece> auxListOfPieces, List<PieceCoordinate> pieceCoordinates){
        List<PieceCoordinate> resultedList = new ArrayList<>();

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
