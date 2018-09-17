package initializer;

import model.Piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PieceInitializer {

    private List<String> pieceChars;
    private List<Piece> pieces;

    public PieceInitializer(String lastLine){
        pieceChars = generatePiecesChars(lastLine);
        pieces = generatePieceObjectsList(pieceChars);
    }

    public List<Piece> getPieces() { return pieces;}

    private List<String> generatePiecesChars(String lastLine){
        String temp;
        StringBuilder stringBuilder = new StringBuilder();

        List<String> piecesChars = new ArrayList();

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

    private List<Piece> generatePieceObjectsList(List<String> piecesChars){
        List<Piece> pieces = new ArrayList();
        List<String> listValuesOfEachPiece = new ArrayList();

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

    private int getBiggestString(List<String> tempArrayList){
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

    private Piece createNewPiece(int lineSize, int columnSize, List<String> listOFValuesOfEachPiece){
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
