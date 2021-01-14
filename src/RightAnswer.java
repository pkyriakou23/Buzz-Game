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
/**
 * Τύπος γύρου: Σωστή Απάντηση
 *
 * Κλάση που αναπαριστά έναν από τους τύπους γύρων του παιχνιδιού, το Σωστή Απάντηση.
 * Ο παίχτης εάν απαντήσει σωστά στην ερώτηση που του γίνεται κερδίζει 1000 πόντους
 * Καλεί τα γραφικά να εμφανιστούν

 */
public class RightAnswer {
    private RightAnswerGui questions;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές.
     */
    public RightAnswer(){
        questions=new RightAnswerGui();
    }

    /**
     * Συνάρτηση που εμφανίζει τον τύπο γύρου "Σωστή Απάντηση"
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει αν το παιχνίδι παίζεται από έναν ή δύο παίκτες
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     */
    public void showRightAnswer(DisplayQuestions d,JFrame menuFrame,int scoreA, int scoreB,boolean solo,boolean[] rounds) throws InterruptedException {
        questions.QuestionsWindow(d,menuFrame,scoreA,scoreB,solo,rounds);
        questions.game();
    }

}