package model;

import java.util.Arrays;

public class Board{

    private int[][] board;
    private int depth;
    private int increment;

    public Board(int line, int column, int depth) {

        if(line < 1){ // Mininum size of board: [1][1].
            line = 1;
        }

        if(column < 1){
            column = 1;
        }

        if(depth < 2){
            depth = 2;
        }

        board = new int[line][column];
        this.depth = depth;
        increment = 1;
    }

    public int[][] getBoard(){ return board; }

    public int getDepth(){ return depth; }

    public int getLineSize(){ return board.length; }

    public int getColumnSize() { return board[0].length; }

    public int getCellValue(int line, int column){
        return board[line][column];
    }

    public void insertValue(int cellValue, int line, int column){
        board[line][column] = cellValue;
    }

    public void incrementCell(int line, int column){
        if((board[line][column] + increment) == depth){
            board[line][column] = 0;

        } else{
            board[line][column] += increment;
        }
    }

    public void setBoard(int[][] board){
        this.board = Arrays.copyOf(board, board.length);
    }

    public int generateDeepHashCode(){
        return java.util.Arrays.deepHashCode(board);
    }
}
