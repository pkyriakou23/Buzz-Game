import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Round {
    private JFrame frame;
    private RightAnswer type1;
    private DisplayQuestions d;

    public Round(){
        frame=new JFrame();
        type1=new RightAnswer();
        d=new DisplayQuestions();
    }

    public void startRound(JFrame menuFrame) throws InterruptedException {
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

        updateScreen(menuFrame);
    }

    public void updateScreen(JFrame menuFrame) throws InterruptedException {
        type1.showRightAnswer(d,menuFrame);
    }


}
