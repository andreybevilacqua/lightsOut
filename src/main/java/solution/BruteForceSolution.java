package solution;

import manipulator.BoardManipulator;
import model.Board;
import model.Piece;
import model.PieceCoordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForceSolution implements Solution{

    private BoardManipulator boardManipulator;

    private Board board;
    private Board finalBoard;

    private List<Piece> pieces;
    private List<Board> boardsGeneratedList;

    public BruteForceSolution(Board board, Board finalBoard, List<Piece> pieces){
        this.board = board;
        this.finalBoard = finalBoard;
        this.pieces = pieces;

        boardManipulator = new BoardManipulator();

        boardsGeneratedList = new ArrayList();
    }

    public List<PieceCoordinate> solution(){

        Board newBoard;
        PieceCoordinate pieceCoordinate;

        List<List<PieceCoordinate>> piecesAndCoordinates = new ArrayList();
        List<PieceCoordinate> resultList = new ArrayList();

        List<List<Board>> boardsLists = new ArrayList();

        Map<Board, Board> mapOfBoards = new HashMap();

        boardsGeneratedList.add(board);

        int boardCounter = 0;

        for(Piece piece : pieces){

            List<Board> tempBoardList = new ArrayList();

            for(int b = boardCounter; b <  boardsGeneratedList.size(); b++){
                List<Board> generatedBoards = new ArrayList();
                List<PieceCoordinate> pieceCoordinates = new ArrayList();

                for(int i = 0; i < piece.getCoordinates().size(); i++){
                    newBoard = boardManipulator.createNewBoard(boardsGeneratedList.get(b), piece, i);
                    pieceCoordinate = new PieceCoordinate(piece, piece.getCoordinates().get(i));

                    pieceCoordinates.add(pieceCoordinate);
                    generatedBoards.add(newBoard);

                    mapOfBoards.put(newBoard, boardsGeneratedList.get(b));
                }

                boardsLists.add(generatedBoards);
                piecesAndCoordinates.add(pieceCoordinates);

                tempBoardList.addAll(generatedBoards);
            }
            boardCounter = boardsGeneratedList.size();
            boardsGeneratedList.addAll(tempBoardList);
        }

        for(int i = (boardsLists.size() -1); i >= 0; i--){
            for(int j = 0; j < boardsLists.get(i).size(); j++){
                if(boardsLists.get(i).get(j).generateDeepHashCode() == finalBoard.generateDeepHashCode()){
                    System.out.println("I found the final result");
                    System.out.println("Prepare the Coordinate List here.");
                    j = boardsLists.get(i).size();
                    i = 0;
                }
            }
        }
        return resultList;
    }
}
