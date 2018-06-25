package processing;

import model.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashCodeTest {

    private static Board board;
    private static Board anotherBoard;

    private static ObjectInitializer objectInitializer;

    private String fileName;

    @Before
    public void setup(){
        fileName = "01.txt";

        objectInitializer = new ObjectInitializer(fileName);
        board = objectInitializer.getBoard();
    }

    @Test
    public void justAHashTest(){

        int initialBoardHashCode = board.generateDeepHashCode();

        anotherBoard = objectInitializer.getBoard();
        int anotherHash = anotherBoard.generateDeepHashCode();

        Assert.assertTrue(initialBoardHashCode == anotherHash);

        Board finalIntendedBoard = new Board(3,3,2);

        for(int i = 0; i < finalIntendedBoard.getLineSize(); i++){
            for(int j = 0; j < finalIntendedBoard.getColumnSize(); j++){
                finalIntendedBoard.insertValueIntoCell(0, i, j);
            }
        }

        int finalIntendedBoardHash = finalIntendedBoard.generateDeepHashCode();

        for(int i = 0; i < anotherBoard.getLineSize(); i++){
            for(int j = 0; j < anotherBoard.getColumnSize(); j++){
                anotherBoard.insertValueIntoCell(0, i, j);
            }
        }
        anotherHash = anotherBoard.generateDeepHashCode();

        Assert.assertTrue(finalIntendedBoardHash == anotherHash);
    }
}


