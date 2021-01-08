import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class QuestionsWindow {
    private JFrame frame;
    private JLabel label;
    private JLabel label2;
    private JButton ans1;
    private JButton ans2;
    private JButton ans3;
    private JButton ans4;
    private JPanel ansBox;
    boolean flag;

    String answer;

    public QuestionsWindow(){
        frame=new JFrame();
        label=new JLabel();
        label2=new JLabel();
        ans1=new JButton();
        ans2=new JButton();
        ans3=new JButton();
        ans4=new JButton();
        ansBox=new JPanel();
    }

    public void QuestionWindow(DisplayQuestions d)
    {
        frame.setTitle("Questions");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        //game
        //System.out.println("in game");
        String[] options = new String[4];

        flag=false;

        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        label.setText(d.questions(0));
        //    label.setVisible(true);
        //  label2.setVisible(true);
        label.setAlignmentX(FlowLayout.RIGHT);
        label2.setAlignmentX(FlowLayout.CENTER);
        ansBox.add(label);
        ansBox.add(label2);
        //frame.add(label, BorderLayout.PAGE_START);
        //frame.add(label2, BorderLayout.CENTER);

        options = d.options();
        for (int i = 0; i < 4; i++)
            if (d.isCorrect(options[i]))
                answer = options[i];
        ans1.setText(options[0]);
        ans2.setText(options[1]);
        ans3.setText(options[2]);
        ans4.setText(options[3]);

        ans1.setSize(100,100);
        ans1.setFont(new Font("Verdana",Font.BOLD,22));
        ans2.setFont(new Font("Verdana",Font.BOLD,22));
        ans3.setFont(new Font("Verdana",Font.BOLD,22));
        ans4.setFont(new Font("Verdana",Font.BOLD,22));
        ansBox.setLayout(new GridLayout(3, 2));
        //   ansBox.setFont(new Font("Arial", Font.BOLD, 20));
        ansBox.add(ans1);
        ansBox.add(ans2);
        ansBox.add(ans3);
        ansBox.add(ans4);

        frame.add(ansBox, BorderLayout.CENTER);



        ans1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans1.getText().equals(answer)) {
                    label2.setText("You score +1000");
                    label2.setFont(new Font("Verdana",Font.BOLD,22));
                    label2.setVisible(true);
                }



            }
            public void mouseReleased(MouseEvent e)
            {
                try {
                    updateQuestion(d);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });

        ans2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans2.getText().equals(answer)) {
                    label2.setText("You score +1000");
                    label2.setFont(new Font("Verdana",Font.BOLD,22));
                    label2.setVisible(true);
                }



            }
            public void mouseReleased(MouseEvent e)
            {
                try {
                    updateQuestion(d);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });
        ans3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans3.getText().equals(answer)) {
                    label2.setText("You score +1000");
                    label2.setFont(new Font("Verdana",Font.BOLD,22));
                    label2.setVisible(true);
                }



            }
            public void mouseReleased(MouseEvent e)
            {
                try {
                    updateQuestion(d);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });
        ans4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans4.getText().equals(answer)) {
                    label2.setText("You score +1000");
                    label2.setFont(new Font("Verdana",Font.BOLD,22));
                    label2.setVisible(true);
                }



            }
            public void mouseReleased(MouseEvent e)
            {
                try {
                    updateQuestion(d);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });




    }
    public void game()  {


        frame.setVisible(true);


    }



    public void correctAnswer()  {
        label.setText("Correct answer is "+answer);
        label.setFont(new Font("Verdana",Font.BOLD,22));
        //System.out.println(answer);
        label.setVisible(true);
    }
    private void updateQuestion(DisplayQuestions d) throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);
        label.setText(d.questions(0));
        label.setVisible(true);
    }
    private void updateOptions(DisplayQuestions d)
    {
        String[] opt=d.options();
        ans1.setText(opt[0]);
        ans2.setText(opt[1]);
        ans3.setText(opt[2]);
        ans4.setText(opt[3]);
        ansBox.setVisible(true);
        for (int i = 0; i < 4; i++)
            if (d.isCorrect(opt[i]))
                answer = opt[i];
        label2.setVisible(false);
    }

}
