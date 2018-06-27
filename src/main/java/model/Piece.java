package model;

import java.util.ArrayList;

public class Piece {

    private char xCommand;
    private char dotCommand;

    private char[][] piece;

    private ArrayList<Coordinate> coordinates;

    public Piece(int line, int column){

        // Mininum size of each piece: [1][1]
        if(line < 1){
            line = 1;
        }

        if(column < 1){
            column = 1;
        }

        piece = new char[line][column];

        xCommand = 'X';
        dotCommand = '.';

        coordinates = new ArrayList<>();
    }

    public char[][] getPiece(){ return piece; }

    public char getCellValue(int line, int column){
        return piece[line][column];
    }

    public int getLineSize(){ return piece.length; }

    public int getColumnSize(){ return piece[0].length; }

    public ArrayList<Coordinate> getCoordinates(){ return coordinates; }

    public void insertXValueIntoPiece(int line, int column){
        piece[line][column] = xCommand;
    }

    public void insertDotValueIntoPiece(int line, int column){
        piece[line][column] = dotCommand;
    }

    public void addAllCoordinatesIntoCoordinateList(ArrayList<Coordinate> coordinates){ this.coordinates.addAll(coordinates); }

    public int generateDeepHashCode(){ return java.util.Arrays.deepHashCode(piece); }

}