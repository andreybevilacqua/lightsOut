package solution;

import model.Board;
import model.Piece;
import model.PieceCoordinate;
import manipulator.BoardManipulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BruteForceSolution implements Solution{

    private BoardManipulator boardManipulator;

    private Board board;
    private Board finalBoard;

    private ArrayList<Piece> pieces;
    private ArrayList<Board> boardsGeneratedList;

    public BruteForceSolution(Board board, Board finalBoard, ArrayList<Piece> pieces){
        this.board = board;
        this.finalBoard = finalBoard;
        this.pieces = pieces;

        boardManipulator = new BoardManipulator();

        boardsGeneratedList = new ArrayList();
    }

    public ArrayList<PieceCoordinate> solution(){

        Board newBoard;
        PieceCoordinate pieceCoordinate;

        ArrayList<ArrayList<PieceCoordinate>> piecesAndCoordinates = new ArrayList();
        ArrayList<PieceCoordinate> resultList = new ArrayList();

        ArrayList<ArrayList<Board>> boardsLists = new ArrayList();

        Map<Board, Board> mapOfBoards = new HashMap();

        boardsGeneratedList.add(board);

        int boardCounter = 0;

        for(Piece piece : pieces){

            ArrayList<Board> tempBoardList = new ArrayList();

            for(int b = boardCounter; b <  boardsGeneratedList.size(); b++){
                ArrayList<Board> generatedBoards = new ArrayList();
                ArrayList<PieceCoordinate> pieceCoordinates = new ArrayList();

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
