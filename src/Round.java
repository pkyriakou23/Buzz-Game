import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Κλάση η οποία αναπαριστά την αρχή των γύρων του παιχνιδιού (1ος γύρος).
 */
public class Round {
    private JFrame frame;
    private DisplayQuestions d;
    boolean[] rounds;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την εμφάνιση του γύρου.
     */
    public Round(){
        frame=new JFrame();

        d=new DisplayQuestions();
        rounds=new boolean[4];
        for(int i=0;i<4;i++)
            rounds[i]=false;

    }

    /**
     *
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει αν το παιχνίδι παίζεται από έναν ή δύο παίκτες
     * @throws InterruptedException
     *
     * Ξεκινάει το παιχνίδι διαλέγοντας στην τύχη τον πρώτο γύρο.
     */
    public void startRound(JFrame menuFrame,int scoreA,int scoreB,boolean solo) throws InterruptedException {

        menuFrame.setVisible(false);
        Random r=new Random();
        if(solo)
        {
            rounds[3]=true;
        }
        int ran;
      do {
           ran = r.nextInt(4);
      }
      while (solo && ran==3);

        if(ran==0) {
            RightAnswer type1;
            type1 = new RightAnswer();
            type1.showRightAnswer(d, menuFrame, scoreA, scoreB, solo, rounds);

        }
        if(ran==1)
        {
            Time type2;
            type2=new Time();
            type2.showTime(d,menuFrame,scoreA,scoreB,solo,rounds);
        }
        if(ran==2)
        {
            Betting type3;
            type3=new Betting();
            type3.showBetting(d,menuFrame,scoreA,scoreB,solo,rounds);
        }
        if(ran==3 && !rounds[3] )
        {
            FastAnswerGUI f=new FastAnswerGUI();
            f.fastAnswerQuestions(d,menuFrame,scoreA,scoreB,solo,rounds);
        }



    }

}
