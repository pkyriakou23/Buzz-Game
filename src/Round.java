import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Round {
    private JFrame frame;



    private DisplayQuestions d;
    boolean[] rounds;

    public Round(){
        frame=new JFrame();

        d=new DisplayQuestions();
        rounds=new boolean[4];
        for(int i=0;i<4;i++)
            rounds[i]=false;
    }

    public void startRound(JFrame menuFrame,int scoreA,int scoreB,boolean solo) throws InterruptedException {
        Random r=new Random();
        int ran=r.nextInt(4);

        //ελεγχος για solo! Αν ειναι true δεν μπορει να παίξει γρηγορη απαντηση και θερμομετρο.
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
        //grigori
        if(ran==3){
            FastAnswerGUI type4;
            type4=new FastAnswerGUI();
            type4.fastAnswerQuestions(d,menuFrame,scoreA,scoreB,solo,rounds);
        }

    }

    private void visible(JLabel l)
    {
        l.setVisible(true);
        frame.setVisible(true);
    }
}
