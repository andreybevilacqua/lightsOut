package initializer;

import model.Piece;

import java.util.ArrayList;
import java.util.Comparator;

public class PieceInitializer {

    private ArrayList<String> pieceChars;
    private ArrayList<Piece> pieces;

    public PieceInitializer(String lastLine){
        pieceChars = generatePiecesChars(lastLine);
        pieces = generatePieceObjectsList(pieceChars);
    }

    public ArrayList<Piece> getPieces() { return pieces;}

    private ArrayList<String> generatePiecesChars(String lastLine){
        String temp;
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> piecesChars = new ArrayList();

        for(int i = 0; i <= lastLine.length(); i++){

            if(i < lastLine.length()){
                temp = lastLine.substring(i, i+1);
            } else {
                temp = "endOfThirdLine";
            }

            if(temp.equals("X") || temp.equals(".") || temp.equals(" ")){
                stringBuilder.append(temp);
            } else{
                piecesChars.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        return piecesChars;
    }

    private ArrayList<Piece> generatePieceObjectsList(ArrayList<String> piecesChars){
        ArrayList<Piece> pieces = new ArrayList();
        ArrayList<String> listValuesOfEachPiece = new ArrayList();

        StringBuilder stringBuilder = new StringBuilder();

        String temp;

        for(String s : piecesChars){
            for(int i = 0; i <= s.length(); i++){
                if(i < s.length()){
                    temp = s.substring(i, i+1);

                    if(temp.equals(".") || temp.equals("X")){
                        stringBuilder.append(temp);
                    } else if(temp.equals(" ")){
                        listValuesOfEachPiece.add(stringBuilder.toString());
                        stringBuilder.setLength(0);
                    }
                } else{
                    listValuesOfEachPiece.add(stringBuilder.toString());

                    int column = getBiggestString(listValuesOfEachPiece);

                    pieces.add(createNewPiece(listValuesOfEachPiece.size(), column, listValuesOfEachPiece));

                    stringBuilder.setLength(0);
                    listValuesOfEachPiece.clear();
                }
            }
        }
        return pieces;
    }

    private int getBiggestString(ArrayList<String> tempArrayList){
//        int result = 0;
//        int size;
//
//        for(String s : tempArrayList){
//            size = s.length();
//            if(size > result){
//                result = size;
//            }
//        }
//
//        return result;
        tempArrayList.sort(Comparator.comparing(String::length));
        return tempArrayList.get(tempArrayList.size()-1).length();
    }

    private Piece createNewPiece(int lineSize, int columnSize, ArrayList<String> listOFValuesOfEachPiece){
        Piece piece = new Piece(lineSize, columnSize);

        String xOrDot;
        int line = 0;

        for(String s : listOFValuesOfEachPiece){
            for(int i = 0; i <= s.length(); i++){
                if(i < s.length()){
                    xOrDot = s.substring(i, i+1);

                    if(xOrDot.equals("X")){
                        piece.insertX(line, i);
                    } else if(xOrDot.equals(".")){
                        piece.insertDot(line, i);
                    }
                }
            }
            line++;
        }
        return piece;
    }

}
