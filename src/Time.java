/*import java.util.Scanner;

/**
 * Τύπος γύρου: Σωστή Απάντηση
 *
 * Κλάση που αναπαριστά έναν από τους τύπους γύρων του παιχνιδιού, την Σωστή Απάντηση.
 * Κάθε παίχτης που απαντάει σωστά κερδίζει 1000 πόντους.
 */

/*public class RightAnswer {

    SelectQuestions questions;

    /**
     * Κατασκευαστής / Constructor
     */
  /*  public RightAnswer()
    {
        questions=new SelectQuestions();
    }

    /**
     *Προσθήκη 1000 πόντων για σωστή απάντηση.
     * @param player ο παίχτης που διαγωνίζεται
     */
  /*  public void addScore(Players player)
    {
        player.setScore(player.getScore() + 1000);
    }

    public void displayRightAnswer(DisplayQuestions d, Players p )
    {
        String answer;
        boolean checkAnswer = false;

        Scanner input = new Scanner(System.in);

       // d.display(0);

        System.out.print("Your answer : ");
        answer = input.nextLine();
        checkAnswer = d.isCorrect(answer);
        if (checkAnswer)
        {
            System.out.println("You score +1000");
            addScore(p);                        //πρόσθεση σκορ
        }
    }

}*/
import javax.swing.*;

public class Time {
    private TimeGui questions;

    public Time(){
        questions=new TimeGui();

    }

    public void showTime(DisplayQuestions d,JFrame menuFrame,int scoreA, int scoreB,boolean solo,boolean[] rounds) throws InterruptedException {
        questions.QuestionsWindow(d,menuFrame,scoreA,scoreB,solo,rounds);
        questions.game();
    }

}