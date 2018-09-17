package initializer;

import model.Board;

public class FinalBoardInitializer {

    private Board finalBoard;

    public Board initialize(int lineSize, int columnSize, int depth) {
        finalBoard = new Board(lineSize, columnSize, depth);

        for(int i = 0; i < lineSize; i++){
            for(int j = 0;  j < columnSize; j++){
                finalBoard.insertValue(0, i, j);
            }
        }
        return finalBoard;
    }
}
