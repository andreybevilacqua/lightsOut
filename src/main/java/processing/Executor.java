package processing;

import model.Board;
import model.Piece;
import model.PieceCoordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Executor {

    private BoardPieceManipulator boardPieceManipulator;

    private boolean foundAnswer = false;

    private Board board;
    private Board finalBoard;

    private ArrayList<Piece> pieces;
    private ArrayList<Piece> piecesBackup;
    private ArrayList<Board> boardsGeneratedList;
    private ArrayList<PieceCoordinate> pieceCoordinatesList;
    private ArrayList<PieceCoordinate> resultedList;

    public Executor(Board board, Board finalBoard, ArrayList<Piece> pieces){
        this.board = board;
        this.finalBoard = finalBoard;
        this.pieces = pieces;

        boardPieceManipulator = new BoardPieceManipulator();

        boardsGeneratedList = new ArrayList<>();
        pieceCoordinatesList = new ArrayList<>();

        piecesBackup = new ArrayList<>();
        resultedList = new ArrayList<>();
    }

    public ArrayList<PieceCoordinate> execute(String strategy){

        piecesBackup.addAll(pieces);
        // Usar Collections.sort
        pieces = new Sort().bubbleSort(pieces);

        if(strategy.equals("bruteForceSolution")){
            return bruteForceSolution();
        } else {
            return circularLoopSolution();
        }

    }

    // Criar uma classe para cada solucao!
    private ArrayList<PieceCoordinate> bruteForceSolution(){

        Board newBoard;
        PieceCoordinate pieceCoordinate;

        ArrayList<ArrayList<PieceCoordinate>> listOfPiecesAndCoordinates = new ArrayList<>();
        ArrayList<PieceCoordinate> resultList = new ArrayList<>();

        ArrayList<ArrayList<Board>> listOfAllBoardsList = new ArrayList<>();

        Map<Board, Board> mapOfBoards = new HashMap<>();

        boardsGeneratedList.add(board);

        int boardCounter = 0;

        for(Piece piece : pieces){

            ArrayList<Board> tempBoardList = new ArrayList<>();

            for(int b = boardCounter; b <  boardsGeneratedList.size(); b++){
                ArrayList<Board> generatedBoards = new ArrayList<>();
                ArrayList<PieceCoordinate> pieceCoordinates = new ArrayList<>();

                for(int i = 0; i < piece.getCoordinates().size(); i++){
                    newBoard = createAndPrepareNewBoard(boardsGeneratedList.get(b), piece, i);
                    pieceCoordinate = new PieceCoordinate(piece, piece.getCoordinates().get(i));

                    pieceCoordinates.add(pieceCoordinate);
                    generatedBoards.add(newBoard);

                    mapOfBoards.put(newBoard, boardsGeneratedList.get(b));
                }

                listOfAllBoardsList.add(generatedBoards);
                listOfPiecesAndCoordinates.add(pieceCoordinates);

                tempBoardList.addAll(generatedBoards);
            }
            boardCounter = boardsGeneratedList.size();
            boardsGeneratedList.addAll(tempBoardList);

        }

        for(int i = (listOfAllBoardsList.size() -1); i >= 0; i--){
            for(int j = 0; j < listOfAllBoardsList.get(i).size(); j++){
                if(listOfAllBoardsList.get(i).get(j).generateDeepHashCode() == finalBoard.generateDeepHashCode()){
                    System.out.println("I found the final result");
                    System.out.println("Prepare the Coordinate List here.");
                    j = listOfAllBoardsList.get(i).size();
                    i = 0;
                }

            }
        }
        return resultList;
    }

    // Criar uma classe para cada solucao!
    private ArrayList<PieceCoordinate> circularLoopSolution(){

        int pointerThatDefinesWhichPieceImIn = 0;
        int pointerFromAllListThatDefinesWhichCoordinateShouldIUse = 0;
        int pointerOfDefaultPositionOfEachPiece = 0;

        int[] defaultPositionOfEachPiece = new int[pieces.size()];
        populateDefaultPositionOfEachPiece(pieces, defaultPositionOfEachPiece);

        boolean alreadyReset = false;
        boolean didNotFound = false;

        Board newBoard;
        PieceCoordinate pieceCoordinate;

        while(foundAnswer == false && didNotFound == false){

            for(int i = 0; i < pieces.size(); i++){

                if(i == pointerThatDefinesWhichPieceImIn){

                    if(boardsGeneratedList.size() > 0){
                        newBoard = createAndPrepareNewBoard(boardsGeneratedList.get(i - 1), pieces.get(i), pointerFromAllListThatDefinesWhichCoordinateShouldIUse);
                    } else{
                        newBoard = createAndPrepareNewBoard(board, pieces.get(i), pointerFromAllListThatDefinesWhichCoordinateShouldIUse);
                    }
                    pieceCoordinate = new PieceCoordinate(pieces.get(i), pieces.get(i).getCoordinates().get(pointerFromAllListThatDefinesWhichCoordinateShouldIUse));
                } else{

                    if(boardsGeneratedList.size() > 0){
                        newBoard = createAndPrepareNewBoard(boardsGeneratedList.get(i - 1), pieces.get(i), defaultPositionOfEachPiece[i]);
                    } else{
                        newBoard = createAndPrepareNewBoard(board, pieces.get(i), defaultPositionOfEachPiece[i]);
                    }
                    pieceCoordinate = new PieceCoordinate(pieces.get(i), pieces.get(i).getCoordinates().get(defaultPositionOfEachPiece[i]));
                }
                boardsGeneratedList.add(newBoard);
                pieceCoordinatesList.add(pieceCoordinate);
            }

            if(boardsGeneratedList.get(boardsGeneratedList.size() -1).generateDeepHashCode() == finalBoard.generateDeepHashCode()){
                foundAnswer = true;
                resultedList = prepareResult(piecesBackup, pieceCoordinatesList);
            } else {
                if(pointerFromAllListThatDefinesWhichCoordinateShouldIUse == (pieces.get(pointerThatDefinesWhichPieceImIn).getCoordinates().size() - 1) ){

                    if(pointerThatDefinesWhichPieceImIn == (pieces.size() -1) ){
                        alreadyReset = true;
                    }

                    if(alreadyReset){

                        if(pointerOfDefaultPositionOfEachPiece == pieces.size()){
                            didNotFound = true;
                            break;
                        }

                        if(defaultPositionOfEachPiece[pointerOfDefaultPositionOfEachPiece] != (pieces.get(pointerOfDefaultPositionOfEachPiece).getCoordinates().size() -1)){
                            defaultPositionOfEachPiece[pointerOfDefaultPositionOfEachPiece]++;
                        } else{
                            pointerOfDefaultPositionOfEachPiece++;
                        }
                        pointerThatDefinesWhichPieceImIn = 0;
                        alreadyReset = false;
                    } else {
                        pointerThatDefinesWhichPieceImIn++;
                    }

                    pointerFromAllListThatDefinesWhichCoordinateShouldIUse = 0;

                } else{
                    pointerFromAllListThatDefinesWhichCoordinateShouldIUse++;
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

    // Esse cara pode ir para a classe model Board.
    private Board createAndPrepareNewBoard(Board board, Piece piece, int coordinatePosition){
        Board newBoard = new Board(board.getLineSize(), board.getColumnSize(), board.getDepth());

        newBoard.setBoard(boardPieceManipulator.copyAllValuesFromPreviousBoardToAnotherBoard(newBoard, board.getBoard()));

        boardPieceManipulator.applyPieceInBoardInDesiredCoordinate(piece, newBoard, piece.getCoordinates().get(coordinatePosition));

        return newBoard;
    }

    private ArrayList<PieceCoordinate> prepareResult(ArrayList<Piece> backup, ArrayList<PieceCoordinate> pieceCoordinates){
        ArrayList<PieceCoordinate> resultedList = new ArrayList<>();

        for(Piece piece : backup){
            for(PieceCoordinate pieceCoordinate : pieceCoordinates){
                if(pieceCoordinate.getPiece().generateDeepHashCode() == piece.generateDeepHashCode() ){
                    resultedList.add(pieceCoordinate);
                }
            }
        }
        return resultedList;
    }

    private void populateDefaultPositionOfEachPiece(ArrayList<Piece> pieces, int[] defaultPositionOfEachPiece){
        for(int i = 0; i < pieces.size(); i++){
            defaultPositionOfEachPiece[i] = 0;
        }
    }

}
