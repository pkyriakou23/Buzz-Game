import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class RightAnswerGui {
    private JFrame frame;
    private JLabel question;
    private JLabel scoreLabel;
    private JButton ans1;
    private JButton ans2;
    private JButton ans3;
    private JButton ans4;
    private JPanel ansBox;
    private JPanel questBox;


    private int Ascore,Bscore;

    private int counter;
    private int player;

    String answer;

    public RightAnswerGui(){
        frame=new JFrame();
        question=new JLabel();
        scoreLabel=new JLabel();
        ans1=new JButton();
        ans2=new JButton();
        ans3=new JButton();
        ans4=new JButton();
        ansBox=new JPanel();
        questBox=new JPanel();

        counter=0;
        player=0;

    }




    public void QuestionsWindow(DisplayQuestions d,JFrame roundFrame,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        rounds[0]=true;
        if (solo)
            player=1;

        roundFrame.setVisible(false);
        Ascore=scoreA;
        Bscore=scoreB;

        frame.setTitle("Questions");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        question.setText(d.questions(0));
        question.setAlignmentX(FlowLayout.LEFT);
        scoreLabel.setAlignmentX(FlowLayout.LEFT);
        questBox.add(question);
        questBox.add(scoreLabel);

        questBox.setLayout(new GridLayout(2,1));

        String[] options = new String[4];


        options = d.options();
        for (int i = 0; i < 4; i++)
            if (d.isCorrect(options[i]))
                answer = options[i];
        ans1.setText(options[0]);
        ans2.setText(options[1]);
        ans3.setText(options[2]);
        ans4.setText(options[3]);

        ans1.setSize(100, 100);
        ans1.setFont(new Font("Verdana", Font.BOLD, 22));
        ans2.setFont(new Font("Verdana", Font.BOLD, 22));
        ans3.setFont(new Font("Verdana", Font.BOLD, 22));
        ans4.setFont(new Font("Verdana", Font.BOLD, 22));

        ansBox.setLayout(new GridLayout(2, 2));
        //   ansBox.setFont(new Font("Arial", Font.BOLD, 20));
        ansBox.add(ans1);
        ansBox.add(ans2);
        ansBox.add(ans3);
        ansBox.add(ans4);

        frame.setLayout(new GridLayout(2,1));
        frame.add(questBox);
        frame.add(ansBox);


        ans1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans1.getText().equals(answer)) {
                    scoreLabel.setText("You score +1000");   //+scoreGain
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo);
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
                    scoreLabel.setText("You score +1000");
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo);
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
                    scoreLabel.setText("You score +1000");
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);
                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo);
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
                    scoreLabel.setText("You score +1000");
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo);
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
        question.setText("Correct answer is "+answer);
        question.setFont(new Font("Verdana",Font.BOLD,22));
        question.setVisible(true);
    }
    private void updateQuestion(DisplayQuestions d,JFrame menuFrame,int score,boolean solo) throws InterruptedException {
        counter++;
        if(counter==5) {
            JLabel label = new JLabel("End of Round! Your score is "+score);
            TimeUnit.SECONDS.sleep(2);
            if (player==0 )
            { counter = 0; player=1; }
            else {
                if(player==1 && !solo )
                    label.setText("End of Round! Your score is "+score);
                frame.setVisible(false);
                JFrame frame1 = new JFrame("End of Round");
                frame1.setSize(200, 200);
                frame1.setLocationRelativeTo(null);

                frame1.add(label, BorderLayout.CENTER);
                frame1.setVisible(true);

                //kalo to epomeno round me tixaiotita


            }
        }

        TimeUnit.SECONDS.sleep(2);
        question.setText("<HTML>"+d.questions(0)+"</HTML>");
        question.setVisible(true);

    }
    private int updateScore(int s)
    {

        s+=1000;

        return s;

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
        scoreLabel.setVisible(false);
    }

}
