package model;

public class PieceCoordinate {

    private Piece piece;
    private Coordinate coordinate;

    public PieceCoordinate(Piece piece, Coordinate coordinate){
        this.piece = piece;
        this.coordinate = coordinate;
    }

    public Piece getPiece() { return piece; }

    public Coordinate getCoordinate() { return coordinate; }

}
