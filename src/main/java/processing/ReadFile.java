package processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private int lineCounter;

    private BufferedReader bufferedReader;
    private FileReader fileReader;

    private String directory;
    private String fileName;
    private String firstLine;
    private String secondLine;
    private String thirdLine;

    private StringBuilder directoryAndFileName;

    public ReadFile(String fileName){
        lineCounter = 0;

        directory = "/Users/andreybevilacqua/Documents/java/workspace/lightsOut/src/main/resources/InputFiles/";
        this.fileName = fileName;

        directoryAndFileName = new StringBuilder();
        directoryAndFileName.append(directory)
                .append(this.fileName);

        readFile(directoryAndFileName.toString());
    }

    private void readFile(String directoryAndFileName){

        try{
            fileReader = new FileReader(directoryAndFileName);
            bufferedReader = new BufferedReader(fileReader);

            String currentLine;

            while((currentLine = bufferedReader.readLine()) != null){

                if(lineCounter == 0){ // First line: depth.
                    firstLine = currentLine;

                } else if(lineCounter == 1){ // Second line: board.
                    secondLine = currentLine;

                } else { // Last line: pieces.
                    thirdLine = currentLine;
                }

                lineCounter++;
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getFirstLine(){ return firstLine; }
    public String getSecondLine(){ return secondLine; }
    public String getThirdLine(){ return thirdLine; }

}
