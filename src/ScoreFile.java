import java.io.*;
import java.util.Scanner;

public class ScoreFile {

    private int currentHighScore;
    private int lineA;
    private int lineB;
    private int winA;
    private int winB;

    //onomata edo i apo names.txt ?
    //prin to steilo midenizo tin timi sto HighScore.txt

    public ScoreFile(){
        try {
            File myObj = new File("HighScore.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            currentHighScore = Integer.parseInt(data);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        lineA=0;
        lineB=0;

        winA=0;
        winB=0;
    }

    public void setHighScore(int scoreOfGame) throws IOException {
        try {
            if(scoreOfGame>currentHighScore){
                currentHighScore=scoreOfGame;
                FileWriter myObj = new FileWriter("HighScore.txt");
                myObj.write(String.valueOf(currentHighScore));
                myObj.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int getHighScore(){
        return currentHighScore;
    }

    public void findPlayers(String nameA,String nameB){
        try {
            File myObj = new File("PlayersNames.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int counter=1;
            boolean foundA=false;
            boolean foundB=false;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if(data.equals(nameA)){
                    lineA=counter;
                    foundA=true;
                }
                if(data.equals(nameB)){
                    lineB=counter;
                    foundB=true;
                }
                counter++;
            }
            if(!foundA){
                writeNameOfPlayer(nameA);
            }
            if(!foundB){
                writeNameOfPlayer(nameB);
            }
            myReader.close();
            setWins();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNameOfPlayer(String name) throws IOException {
        FileWriter out=new FileWriter("PlayersNames.txt",true);
        out.write(System.lineSeparator() + name);
        out.close();

        FileWriter outW=new FileWriter("Wins.txt",true);
        outW.write(System.lineSeparator() + "0");
        outW.close();
    }

    public void addWin(boolean winOfPlayerA,boolean winOfPlayerB){
        if(winOfPlayerA) {
            winA++;
        }else if(winOfPlayerB) {
            winB++;
        }else if(winOfPlayerA && winOfPlayerB){
            winA++;
            winB++;
        }
    }

    public void setWins(){
        try {
            File myObj = new File("Wins.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int counter=1;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if(counter==lineA){
                    winA=Integer.parseInt(data);
                }
                if(counter==lineB){
                    winB=Integer.parseInt(data);
                }
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeWins() {
        try {
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("Wins.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            int counter=1;
            String targetA = null,targetB=null;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
                if(counter==lineA){
                    targetA=line;
                }
                if(counter==lineB){
                    targetB=line;
                }
                counter++;
            }
            file.close();
            String inputStr = inputBuffer.toString();

            // logic to replace lines in the string (could use regex here to be generic)
            inputStr = inputStr.replace(targetA, String.valueOf(winA));
            inputStr = inputStr.replace(targetB, String.valueOf(winB));

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("Wins.txt");
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }

}
