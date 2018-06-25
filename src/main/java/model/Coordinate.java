package model;

public class Coordinate {

    private int xCoordinate;
    private int yCoordinate;

    public Coordinate(){ }

    public Coordinate(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate(){ return xCoordinate; }

    public int getYCoordinate(){ return yCoordinate; }

    public void setXCoordinate(int xCoordinate){
        if(xCoordinate < 0){
            throw new IllegalArgumentException("Coordinates X must be >= 0");
        } else{
            this.xCoordinate = xCoordinate;
        }
    }

    public void setYCoordinate(int yCoordinate){
        if(yCoordinate < 0){
            throw new IllegalArgumentException("Coordinates Y must be >= 0");
        } else{
            this.yCoordinate = yCoordinate;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(xCoordinate).append(",").append(yCoordinate);
        return sb.toString();
    }
}
