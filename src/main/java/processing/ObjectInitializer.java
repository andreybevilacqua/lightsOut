package processing;

import model.Board;
import model.Piece;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectInitializer {

    private Board board;
    private Board finalBoard;

    private int depth;
    private int lineCounter;

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    private String directory;
    private String fileName;

    private StringBuilder directoryAndFileName;

    private ArrayList<String> piecesCharactersList;
    private ArrayList<Piece> pieces;

    public ObjectInitializer(String fileName){
        lineCounter = 0;

        directory = "/Users/andreybevilacqua/Documents/java/workspace/lightsOut/src/main/resources/InputFiles/";
        this.fileName = fileName;

        directoryAndFileName = new StringBuilder();
        directoryAndFileName.append(directory)
                            .append(this.fileName);

        piecesCharactersList = new ArrayList<>();
        pieces = new ArrayList<>();

        readFile(directoryAndFileName.toString());
    }

    public Board getBoard() { return board; }

    public Board getFinalBoard() { return finalBoard; }

    public ArrayList<Piece> getPieces() { return pieces;}

    private void readFile(String directoryAndFileName){

        try{
            fileReader = new FileReader(directoryAndFileName);
            bufferedReader = new BufferedReader(fileReader);

            String currentLine;

            while((currentLine = bufferedReader.readLine()) != null){

                if(lineCounter == 0){ // First line: depth.
                    depth = parseDepthStringToInt(currentLine);

                } else if(lineCounter == 1){ // Second line: board.
                    ArrayList<String> boardNumbersAsStringList = getBoardNumbersAsStringList(currentLine);

                    board = new Board(boardNumbersAsStringList.size(),
                                      boardNumbersAsStringList.get(0).length(), depth);

                    populateBoardWithInputNumbers(currentLine);

                } else { // Last line: pieces.
                    piecesCharactersList = generatePiecesCharactersList(currentLine);
                    pieces = generatePieceObjectsList(piecesCharactersList);
                }

                lineCounter++;
            }

            initializeFinalBoard(board.getLineSize(), board.getColumnSize());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void initializeFinalBoard(int lineSize, int columnSize) {

        finalBoard = new Board(lineSize, columnSize, depth);

        for(int i = 0; i < lineSize; i++){
            for(int j = 0;  j < columnSize; j++){
                finalBoard.insertValueIntoCell(0, i, j);
            }
        }
    }

    private int parseDepthStringToInt(String stringNumber){

        int depth;

        try{
            depth = Integer.parseInt(stringNumber);
        } catch (NumberFormatException e){
            depth = -1;
        }

        return depth;
    }

    private ArrayList<String> getBoardNumbersAsStringList(String currentLine){

        String temp = "";
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> boardNumbersStringList = new ArrayList<>();

        for(int i = 0; i <= currentLine.length(); i++){

            if(i < currentLine.length()){
                temp = currentLine.substring(i,i+1);
            } else {
                temp = "endOfSecondLine";
            }

            if(temp.matches("\\d+")){
                stringBuilder.append(temp);
            } else{
                boardNumbersStringList.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }

        return boardNumbersStringList;
    }

    private void populateBoardWithInputNumbers(String currentLine){

        int cellValue = 0;
        int line = 0;
        int column = 0;

        String valueAsString = "";

        for(int i = 0; i <= currentLine.length(); i++){

            if(i < currentLine.length()){

                valueAsString = currentLine.substring(i,i+1);

                if(!valueAsString.equals(",")){
                    cellValue = Integer.parseInt(valueAsString);
                    board.insertValueIntoCell(cellValue, line, column);
                    column++;
                } else{
                    line++;
                    column = 0;
                }
            }
        }
    }

    private ArrayList<String> generatePiecesCharactersList(String currentLine){

        String temp = "";
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> piecesCharacters = new ArrayList<>();

        for(int i = 0; i <= currentLine.length(); i++){

            if(i < currentLine.length()){
                temp = currentLine.substring(i, i+1);
            } else {
                temp = "endOfThirdLine";
            }

            if(temp.equals("X") || temp.equals(".") || temp.equals(" ")){
                stringBuilder.append(temp);
            } else{
                piecesCharacters.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }

        return piecesCharacters;
    }

    private ArrayList<Piece> generatePieceObjectsList(ArrayList<String> piecesCharactersList){

        ArrayList<Piece> pieces = new ArrayList<>();
        ArrayList<String> listOFValuesOfEachPiece = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        String temp = "";

        for(String s : piecesCharactersList){

            for(int i = 0; i <= s.length(); i++){

                if(i < s.length()){
                    temp = s.substring(i, i+1);

                    if(temp.equals(".") || temp.equals("X")){
                        stringBuilder.append(temp);
                    } else if(temp.equals(" ")){
                        listOFValuesOfEachPiece.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    }
                } else{

                    listOFValuesOfEachPiece.add(stringBuilder.toString());

                    int column = getBiggestStringInsideTempArrayList(listOFValuesOfEachPiece);

                    pieces.add(createNewPiece(listOFValuesOfEachPiece.size(), column, listOFValuesOfEachPiece));

                    stringBuilder.setLength(0);
                    listOFValuesOfEachPiece.clear();
                }
            }
        }

        return pieces;
    }

    private int getBiggestStringInsideTempArrayList(ArrayList<String> tempArrayList){

        int result = 0;
        int size = 0;

        for(String s : tempArrayList){
            size = s.length();
            if(size > result){
                result = size;
            }
        }
        return result;
    }

    private Piece createNewPiece(int totalLine, int totalColumn, ArrayList<String> listOFValuesOfEachPiece){

        Piece piece = new Piece(totalLine, totalColumn);

        String pieceString;
        int line = 0;

        for(String s : listOFValuesOfEachPiece){

            for(int i = 0; i <= s.length(); i++){

                if(i < s.length()){
                    pieceString = s.substring(i, i+1);

                    if(pieceString.equals("X")){
                        piece.insertXValueIntoPiece(line, i);
                    } else if(pieceString.equals(".")){
                        piece.insertDotValueIntoPiece(line, i);
                    }
                }
            }

            line++;
        }
        return piece;
    }

}
