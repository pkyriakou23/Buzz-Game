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
 * Τύπος γύρου: Χρονόμετρο
 *
 * Κλάση που αναπαριστά έναν από τους τύπους γύρων του παιχνιδιού, το Χρονόμετρο.
 * Ο παίχτης έχει 5 δευτερόλεπτα να απαντήσει σωστά στην ερώτηση που του γίνεται. Κερδίζει πόντους ανάλογα με τον χρόνο που έκανε για να απαντήσει κάθε ερώτηση.
 */
public class Time {
    private TimeGui questions;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές.
     */
    public Time(){
        questions=new TimeGui();

    }

    /**
     * Καλεί τα γραφικά του γύρου Χρονόμετρο για να εμφανιστούν.
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει αν το παιχνίδι παίζεται από έναν ή δύο παίκτες
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     */
    public void showTime(DisplayQuestions d,JFrame menuFrame,int scoreA, int scoreB,boolean solo,boolean[] rounds) throws InterruptedException {
        questions.QuestionsWindow(d,menuFrame,scoreA,scoreB,solo,rounds);
        questions.game();
    }

}