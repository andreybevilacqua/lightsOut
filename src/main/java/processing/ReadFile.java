package processing;

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    private int lineCounter;

    private String fileName;
    private String firstLine;
    private String secondLine;
    private String thirdLine;

    public ReadFile(String fileName) throws FileNotFoundException {
        lineCounter = 0;
        this.fileName = "/Users/andreybevilacqua/Documents/java/workspace/lightsOut/src/main/resources/InputFiles/" + fileName;

        readFile();
    }

    private void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(this.fileName));

        while (scanner.hasNextLine()) {
            if (lineCounter == 0) { // First line: depth.
                firstLine = scanner.nextLine();

            } else if (lineCounter == 1) { // Second line: board.
                secondLine = scanner.nextLine();

            } else { // Last line: pieces.
                thirdLine = scanner.nextLine();
            }
            lineCounter++;
        }
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public String getThirdLine() {
        return thirdLine;
    }

}
