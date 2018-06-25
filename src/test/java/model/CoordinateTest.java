package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

    private int xCoordinate;
    private int yCoordinate;

    private Coordinate coordinate;

    @Before
    public void setup(){
        coordinate = new Coordinate();
    }

    @Test
    public void setXCoordinateTest(){
        xCoordinate = 1;
        coordinate.setXCoordinate(xCoordinate);

        Assert.assertEquals(1, coordinate.getXCoordinate());
    }

    @Test
    public void setYCoordinateTest(){
        yCoordinate = 1;
        coordinate.setYCoordinate(yCoordinate);

        Assert.assertEquals(1, coordinate.getYCoordinate());
    }

    @Test
    public void insertCoordinateTest(){
        xCoordinate = 1;
        yCoordinate = 1;

        coordinate.setXCoordinate(xCoordinate);
        coordinate.setYCoordinate(yCoordinate);

        Assert.assertEquals(1, coordinate.getXCoordinate());
        Assert.assertEquals(1, coordinate.getYCoordinate());

        xCoordinate = -1;
        yCoordinate = -1;

        try{
            coordinate.setXCoordinate(xCoordinate);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        } catch (Exception e){
            Assert.assertTrue(false);
        }

        try{
            coordinate.setYCoordinate(yCoordinate);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        } catch (Exception e){
            Assert.assertTrue(false);
        }

    }


}
