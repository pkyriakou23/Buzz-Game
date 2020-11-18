import java.util.Scanner;

public class Players {
    private String name;
    private int score;
    private int numberOfRounds;

    public void Players(){
        name=null;
        score=0;
        numberOfRounds=0;
    }
    public void setName(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter your name: ");
        this.name=input.nextLine();
    }
    public void setScore(int previousScore){
        this.score=previousScore;
    }
    public void setNumOfRounds(){
        numberOfRounds++;
        System.out.println("Round " + numberOfRounds);
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
    public int getNumOfRounds(){
        return numberOfRounds;
    }


    public void showScore(){
        System.out.println(score);
    }

    public void showRound(){
        System.out.println(numberOfRounds);
    }
}
