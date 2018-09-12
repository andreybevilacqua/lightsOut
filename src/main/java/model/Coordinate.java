package model;

public class Coordinate {

    private int xCoordinate;
    private int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate(){ return xCoordinate; }

    public int getYCoordinate(){ return yCoordinate; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(xCoordinate).append(",").append(yCoordinate);
        return sb.toString();
    }
}
