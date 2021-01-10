import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Round {
    private JFrame frame;
    private RightAnswer type1;
    private DisplayQuestions d;
    boolean[] rounds;

    public Round(){
        frame=new JFrame();
        type1=new RightAnswer();
        d=new DisplayQuestions();
        rounds=new boolean[5];
        for(int i=0;i<5;i++)
            rounds[i]=false;
    }

    public void startRound(JFrame menuFrame,int scoreA,int scoreB,boolean solo) throws InterruptedException {
        frame.setTitle("Round");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setResizable(true);
        frame.setBackground(Color.cyan);
        JLabel label=new JLabel("Round 1");
        label.setFont(new Font("Snap ITC",Font.PLAIN,45));
        label.setVisible(true);
        frame.add(label,BorderLayout.CENTER);
        frame.setVisible(true);

        //random kali oti erthei

        type1.showRightAnswer(d,frame,menuFrame,scoreA,scoreB,solo,rounds);
    }


}
