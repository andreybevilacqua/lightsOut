package processing;

import model.Board;

import java.util.ArrayList;

public class BoardObjectInitializer {

    private Board board;

    private int depth;

    public BoardObjectInitializer(String firstLine, String secondLine){
        depth = parseDepthStringToInt(firstLine);
        createBoard(secondLine);
    }

    public Board getBoard() { return board; }

    private void createBoard(String secondLine){
        ArrayList<String> boardNumbersAsStringList = getBoardNumbersAsStringList(secondLine);

        board = new Board(boardNumbersAsStringList.size(),
                boardNumbersAsStringList.get(0).length(), depth);

        populateBoardWithInputNumbers(secondLine);
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

    private ArrayList<String> getBoardNumbersAsStringList(String secondLine){

        String temp;
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> boardNumbersStringList = new ArrayList<>();

        for(int i = 0; i <= secondLine.length(); i++){

            if(i < secondLine.length()){
                temp = secondLine.substring(i,i+1);
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

    private void populateBoardWithInputNumbers(String secondLine){

        int cellValue;
        int line = 0;
        int column = 0;

        String valueAsString;

        for(int i = 0; i <= secondLine.length(); i++){

            if(i < secondLine.length()){

                valueAsString = secondLine.substring(i,i+1);

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

}
