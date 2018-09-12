package initializer;

import model.Board;

public class FinalBoardObjectInitializer {

    private Board finalBoard;

    public FinalBoardObjectInitializer(){
    }

    public Board initializeFinalBoard(int lineSize, int columnSize, int depth) {

        finalBoard = new Board(lineSize, columnSize, depth);

        for(int i = 0; i < lineSize; i++){
            for(int j = 0;  j < columnSize; j++){
                finalBoard.insertValueIntoCell(0, i, j);
            }
        }

        return finalBoard;
    }
}
