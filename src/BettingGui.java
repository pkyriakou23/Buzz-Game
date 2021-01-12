import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BettingGui {
    private JFrame frame;
    private JFrame fr;
    private JFrame bettingFrame;
    private JLabel category;
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
    int scoreGain;

    String answer;

    public BettingGui(){
        frame=new JFrame();
        fr=new JFrame();
        bettingFrame=new JFrame();
        category=new JLabel();
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
        scoreGain=0;

    }


    private void bettingFr(DisplayQuestions d)
    {
        frame.setVisible(false);
        bettingFrame.setTitle("BET");
        bettingFrame.setSize(700,500);
        bettingFrame.setLocationRelativeTo(null);
        bettingFrame.setResizable(true);
        bettingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel betLabel=new JLabel();
        betLabel.setText("Το ποντάρισμα σου:");
        JPanel betPanel=new JPanel();
        JButton bet1= new JButton();
        JButton bet2= new JButton();
        JButton bet3= new JButton();
        JButton bet4= new JButton();
        
        bet1.setText("250");
        bet1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                scoreGain = 250;
            }
            public void mouseReleased(MouseEvent e)
            {
                bettingFrame.setVisible(false);
                question.setText("<HTML>"+d.questions(1)+"</HTML>");
                updateOptions(d);
                question.setVisible(true);
                frame.setVisible(true);
            }
        });
        bet2.setText("500");
        bet2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                scoreGain = 500;
            }
            public void mouseReleased(MouseEvent e)
            {
                bettingFrame.setVisible(false);
                question.setText("<HTML>"+d.questions(1)+"</HTML>");
                updateOptions(d);
                question.setVisible(true);
                frame.setVisible(true);
            }
        });
        bet3.setText("750");
        bet3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                scoreGain = 750;
            }
            public void mouseReleased(MouseEvent e)
            {
                bettingFrame.setVisible(false);
                question.setText("<HTML>"+d.questions(1)+"</HTML>");
                updateOptions(d);
                question.setVisible(true);
                frame.setVisible(true);

            }
        });
        bet4.setText("1000");
        bet4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                scoreGain = 1000;
            }
            public void mouseReleased(MouseEvent e)
            {
                bettingFrame.setVisible(false);
                question.setText("<HTML>"+d.questions(1)+"</HTML>");
                updateOptions(d);
                question.setVisible(true);
                frame.setVisible(true);
            }
        });


        betPanel.setLayout(new GridLayout(2,2));
        bettingFrame.setLayout(new GridLayout(3,1));

       category.setText(d.questionsCategory(d.getRandomI()));
       category.setVisible(true);
       bettingFrame.add(category);

       bettingFrame.add(betLabel);

        betPanel.add(bet1);
        betPanel.add(bet2);
        betPanel.add(bet3);
        betPanel.add(bet4);

        bettingFrame.add(betPanel);


    }

    public void QuestionsWindow(DisplayQuestions d,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        rounds[2]=true;
        if (solo)
            player=1;
       showRound(rounds);


        Ascore=scoreA;
        Bscore=scoreB;

        frame.setTitle("ΕΡΩΤΗΣΕΙΣ");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        question.setText(d.questions(1));
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
                    scoreLabel.setText("ΚΕΔΙΖΕΙΣ +"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,scoreGain);
                    else
                        Bscore=updateScore(Bscore,scoreGain);

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }
                else
                {
                    scoreLabel.setText("ΧΑΝΕΙΣ -"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,(scoreGain*(-1)));
                    else
                        Bscore=updateScore(Bscore,(scoreGain*(-1)));

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);

                }


            }

            public void mouseReleased(MouseEvent e) {
                try {

                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
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
                    scoreLabel.setText("ΚΕΡΔΙΖΕΙΣ +"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,scoreGain);
                    else
                        Bscore=updateScore(Bscore,scoreGain);

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }
                else
                {
                    scoreLabel.setText("ΧΑΝΕΙΣ -"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,(scoreGain*(-1)));
                    else
                        Bscore=updateScore(Bscore,(scoreGain*(-1)));

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);

                }


            }

            public void mouseReleased(MouseEvent e) {
                try {

                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
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
                    scoreLabel.setText("ΚΕΡΔΙΖΕΙΣ +"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,scoreGain);
                    else
                        Bscore=updateScore(Bscore,scoreGain);
                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }
                else
                {
                    scoreLabel.setText("ΧΑΝΕΙΣ -"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,(scoreGain*(-1)));
                    else
                        Bscore=updateScore(Bscore,(scoreGain*(-1)));

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);

                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
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
                    scoreLabel.setText("ΚΕΡΔΙΖΕΙΣ +"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,scoreGain);
                    else
                        Bscore=updateScore(Bscore,scoreGain);

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }
                else
                {
                    scoreLabel.setText("ΧΑΝΕΙΣ -"+scoreGain);
                    if(solo || player==0)
                        Ascore=updateScore(Ascore,(scoreGain*(-1)));
                    else
                        Bscore=updateScore(Bscore,(scoreGain*(-1)));

                    scoreLabel.setFont(new Font("Verdana", Font.BOLD, 22));
                    scoreLabel.setVisible(true);

                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });

    }


    public void game(DisplayQuestions d)  {

        bettingFr(d);
        bettingFrame.setVisible(true);
    }

    private void showRound(boolean[] r)
    {
        int sum=0;
        for (int i=0;i<4;i++)
            if (r[i])
                sum++;


        fr.setTitle("ΓΥΡΟΣ");

        fr.setLocation(40,200);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(400,400);
        fr.setResizable(true);
        fr.setBackground(Color.cyan);
        JLabel label=new JLabel("ΓΥΡΟΣ "+sum);
        label.setFont(new Font("Century Gothic",Font.PLAIN,45));
        label.setVisible(true);
        fr.add(label,BorderLayout.CENTER);
        fr.setVisible(true);
    }

    public void correctAnswer()  {
        question.setText("Η ΣΩΣΤΗ ΑΠΑΝΤΗΣΗ ΕΙΝΑΙ  "+answer);
        question.setFont(new Font("Verdana",Font.BOLD,22));
        question.setVisible(true);

    }
    private void updateQuestion(DisplayQuestions d,JFrame menuFrame,int score,boolean solo,boolean[] rounds) throws InterruptedException {
        counter++;
        System.out.println(counter);
        if(counter==5) {
            JLabel label = new JLabel("ΤΕΛΟΣ ΓΥΡΟΥ! ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ "+score);
            TimeUnit.SECONDS.sleep(2);
            if (player==0 )
            { counter = 0; player=1; }
            else {
                if(player==1 && solo )
                    label.setText("ΤΕΛΟΣ ΓΥΡΟΥ! ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ "+score);
                frame.setVisible(false);
                bettingFrame.setVisible(false);
                JFrame frame1 = new JFrame("ΤΕΛΟΣ ΓΥΡΟΥ!");
                frame1.setSize(200, 200);
                frame1.setLocationRelativeTo(null);

                frame1.add(label, BorderLayout.CENTER);
                frame1.setVisible(true);
                fr.setVisible(false);
                //kalo to epomeno round me tixaiotita
                Random r=new Random();
                int ran=0;
                boolean flag=true;
                for (int i=0;i<4;i++)
                    if (!rounds[i])
                        flag=false;
                if(flag)
                {
                    ThermometerGUI therm=new ThermometerGUI();
                    therm.showRoundScreen(d,menuFrame,Ascore,Bscore,solo,rounds);
                }


                while(!flag)
                {
                    ran=r.nextInt(4);
                    if(!rounds[ran])
                    {
                        if(ran==1)
                        {
                            Time t=new Time();
                            t.showTime(d,menuFrame,Ascore,Bscore,solo,rounds);

                        }
                        if(ran==0)
                        {
                            RightAnswer b=new RightAnswer();
                            b.showRightAnswer(d,menuFrame,Ascore,Bscore,solo,rounds);
                        }
                        if(ran==3)
                        {
                            FastAnswerGUI fast=new FastAnswerGUI();
                            fast.fastAnswerQuestions(d,menuFrame,Ascore,Bscore,solo,rounds);
                        }




                        break;
                    }

                }


            }
        }
        else {
            TimeUnit.SECONDS.sleep(2);
            frame.setVisible(false);
            bettingFrame.setVisible(true);
        }

    }
    private int updateScore(int s,int score)
    {
        s+=score;
        return s;
    }
    private void updateOptions(DisplayQuestions d)
    {
        String[] opt=d.options();
        ans1.setText("<HTML>"+opt[0]+"</HTML>");
        ans2.setText("<HTML>"+opt[1]+"</HTML>");
        ans3.setText("<HTML>"+opt[2]+"</HTML>");
        ans4.setText("<HTML>"+opt[3]+"</HTML>");
      //  ansBox.setVisible(true);
        for (int i = 0; i < 4; i++)
            if (d.isCorrect(opt[i]))
                answer = opt[i];
        scoreLabel.setVisible(false);
        category.setText(d.questionsCategory(d.getRandomI()));
        category.setVisible(true);
    }

}


