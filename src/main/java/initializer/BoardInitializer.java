package initializer;

import model.Board;

import java.util.ArrayList;

public class BoardInitializer {

    private Board board;

    private int depth;

    public BoardInitializer(String firstLine, String secondLine){
        try{
            depth = Integer.parseInt(firstLine);
        } catch (NumberFormatException e){
            depth = -1;
        }
        createBoard(secondLine);
    }

    public Board getBoard() { return board; }

    private void createBoard(String secondLine){
        ArrayList<String> boardNumbersAsString = getBoardNumbersAsString(secondLine);

        board = new Board(boardNumbersAsString.size(),
                boardNumbersAsString.get(0).length(), depth);

        populateBoardWithInputNumbers(secondLine);
    }

    private ArrayList<String> getBoardNumbersAsString(String secondLine){
        String temp;
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> boardNumbersAsString = new ArrayList();

        for(int i = 0; i <= secondLine.length(); i++){

            if(i < secondLine.length()){
                temp = secondLine.substring(i,i+1);
            } else {
                temp = "endOfSecondLine";
            }

            if(temp.matches("\\d+")){
                stringBuilder.append(temp);
            } else{
                boardNumbersAsString.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        return boardNumbersAsString;
    }

    private void populateBoardWithInputNumbers(String secondLine){

        int cellValue;
        int line = 0;
        int column = 0;

        String value;

        for(int i = 0; i <= secondLine.length(); i++){

            if(i < secondLine.length()){

                value = secondLine.substring(i,i+1);

                if(!value.equals(",")){
                    cellValue = Integer.parseInt(value);
                    board.insertValue(cellValue, line, column);
                    column++;
                } else{
                    line++;
                    column = 0;
                }
            }
        }
    }

}
