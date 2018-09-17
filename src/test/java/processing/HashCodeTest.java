package processing;

import model.Board;
import initializer.BoardInitializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class HashCodeTest {

    private static Board board;
    private static Board anotherBoard;

    private static BoardInitializer boardInitializer;
    private static ReadFile readFile;

    private String firstLine;
    private String secondLine;
    private String thirdLine;

    @Before
    public void setup(){

        try{
            readFile = new ReadFile("01.txt");
            firstLine = readFile.getFirstLine();
            secondLine = readFile.getSecondLine();
            thirdLine = readFile.getThirdLine();

            boardInitializer = new BoardInitializer(firstLine, secondLine);
            board = boardInitializer.getBoard();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void justAHashTest(){

        int initialBoardHashCode = board.generateDeepHashCode();

        anotherBoard = boardInitializer.getBoard();
        int anotherHash = anotherBoard.generateDeepHashCode();

        Assert.assertTrue(initialBoardHashCode == anotherHash);

        Board finalIntendedBoard = new Board(3,3,2);

        for(int i = 0; i < finalIntendedBoard.getLineSize(); i++){
            for(int j = 0; j < finalIntendedBoard.getColumnSize(); j++){
                finalIntendedBoard.insertValue(0, i, j);
            }
        }

        int finalIntendedBoardHash = finalIntendedBoard.generateDeepHashCode();

        for(int i = 0; i < anotherBoard.getLineSize(); i++){
            for(int j = 0; j < anotherBoard.getColumnSize(); j++){
                anotherBoard.insertValue(0, i, j);
            }
        }
        anotherHash = anotherBoard.generateDeepHashCode();

        Assert.assertTrue(finalIntendedBoardHash == anotherHash);
    }
}


