package model;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){ return x; }

    public int getY(){ return y; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(",").append(y);
        return sb.toString();
    }
}
