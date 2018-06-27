package processing;

import model.Piece;

import java.util.ArrayList;

public class PieceObjectInitializer {

    private ArrayList<String> piecesCharactersList;
    private ArrayList<Piece> pieces;

    public PieceObjectInitializer(String lastLine){
        piecesCharactersList = generatePiecesCharactersList(lastLine);
        pieces = generatePieceObjectsList(piecesCharactersList);
    }

    public ArrayList<Piece> getPieces() { return pieces;}

    private ArrayList<String> generatePiecesCharactersList(String lastLine){

        String temp;
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> piecesCharacters = new ArrayList<>();

        for(int i = 0; i <= lastLine.length(); i++){

            if(i < lastLine.length()){
                temp = lastLine.substring(i, i+1);
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

        String temp;

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
        int size;

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
