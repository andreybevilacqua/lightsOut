package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

    private Coordinate coordinate;

    @Before
    public void setup(){
        coordinate = new Coordinate(1, 1);
    }

    @Test
    public void insertCoordinateTest(){

        Assert.assertEquals(1, coordinate.getX());
        Assert.assertEquals(1, coordinate.getY());
    }


}
