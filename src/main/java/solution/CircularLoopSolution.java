package solution;

import manipulator.BoardManipulator;
import model.Board;
import model.Piece;
import model.PieceCoordinate;
import processing.Executor;

import java.util.ArrayList;
import java.util.Arrays;

public class CircularLoopSolution implements Solution {

    private boolean foundAnswer = false;

    private BoardManipulator boardManipulator;

    private Board board;
    private Board finalBoard;

    private ArrayList<Piece> pieces;
    private ArrayList<Piece> piecesBackup;
    private ArrayList<Board> boardsGeneratedList;
    private ArrayList<PieceCoordinate> pieceCoordinatesList;
    private ArrayList<PieceCoordinate> resultedList;

    public CircularLoopSolution(Board board, Board finalBoard, ArrayList<Piece> pieces, ArrayList<Piece> piecesBackup){
        this.board = board;
        this.finalBoard = finalBoard;
        this.pieces = pieces;

        boardManipulator = new BoardManipulator();

        boardsGeneratedList = new ArrayList();
        pieceCoordinatesList = new ArrayList();

        this.piecesBackup = piecesBackup;
        resultedList = new ArrayList();
    }

    public ArrayList<PieceCoordinate> solution(){

        int pointerWhichPieceImIn = 0;
        int pointerWhichCoordinateShouldIUse = 0; // pointerFromAllListThatDefinesWhichCoordinateShouldIUse
        int pointerDefaultPositionOfEachPiece = 0;

        int[] defaultPositionOfEachPiece = new int[pieces.size()];
        Arrays.fill(defaultPositionOfEachPiece, 0);

        boolean alreadyReset = false;
        boolean didNotFound = false;

        Board newBoard;
        PieceCoordinate pieceCoordinate;

        while(foundAnswer == false && didNotFound == false){

            for(int i = 0; i < pieces.size(); i++){

                if(i == pointerWhichPieceImIn){

                    if(boardsGeneratedList.size() > 0){
                        newBoard = boardManipulator.createNewBoard(
                                boardsGeneratedList.get(i - 1), pieces.get(i), pointerWhichCoordinateShouldIUse);
                    } else{
                        newBoard = boardManipulator.createNewBoard(
                                board, pieces.get(i), pointerWhichCoordinateShouldIUse);
                    }
                    pieceCoordinate = new PieceCoordinate(pieces.get(i), pieces.get(i).getCoordinates().get(pointerWhichCoordinateShouldIUse));
                } else{

                    if(boardsGeneratedList.size() > 0){
                        newBoard = boardManipulator.createNewBoard(
                                boardsGeneratedList.get(i - 1), pieces.get(i), defaultPositionOfEachPiece[i]);
                    } else{
                        newBoard = boardManipulator.createNewBoard(
                                board, pieces.get(i), defaultPositionOfEachPiece[i]);
                    }
                    pieceCoordinate = new PieceCoordinate(pieces.get(i), pieces.get(i).getCoordinates().get(defaultPositionOfEachPiece[i]));
                }
                boardsGeneratedList.add(newBoard);
                pieceCoordinatesList.add(pieceCoordinate);
            }

            if(boardsGeneratedList.get(boardsGeneratedList.size() -1).generateDeepHashCode() == finalBoard.generateDeepHashCode()){
                foundAnswer = true;
                resultedList = new Executor().prepareResult(piecesBackup, pieceCoordinatesList);
            } else {
                if(pointerWhichCoordinateShouldIUse == (pieces.get(pointerWhichPieceImIn).getCoordinates().size() - 1) ){

                    if(pointerWhichPieceImIn == (pieces.size() -1) ){
                        alreadyReset = true;
                    }

                    if(alreadyReset){

                        if(pointerDefaultPositionOfEachPiece == pieces.size()){
                            didNotFound = true;
                            break;
                        }

                        if(defaultPositionOfEachPiece[pointerDefaultPositionOfEachPiece] != (pieces.get(pointerDefaultPositionOfEachPiece).getCoordinates().size() -1)){
                            defaultPositionOfEachPiece[pointerDefaultPositionOfEachPiece]++;
                        } else{
                            pointerDefaultPositionOfEachPiece++;
                        }
                        pointerWhichPieceImIn = 0;
                        alreadyReset = false;
                    } else {
                        pointerWhichPieceImIn++;
                    }

                    pointerWhichCoordinateShouldIUse = 0;

                } else{
                    pointerWhichCoordinateShouldIUse++;
                }
            }
            boardsGeneratedList.clear();
            pieceCoordinatesList.clear();
        }
        if(didNotFound){
            return null;
        }

        return resultedList;
    }

}
