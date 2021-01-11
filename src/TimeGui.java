import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TimeGui {
    private JFrame frame;
    private JFrame fr;
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


    long start;
    long stop;
    String answer;
    String answer1;

    public TimeGui(){
        frame=new JFrame();
        fr=new JFrame();
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


    public void QuestionsWindow(DisplayQuestions d,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        rounds[1]=true;
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

        question.setText(d.questions(0));
        question.setAlignmentX(FlowLayout.LEFT);
        scoreLabel.setAlignmentX(FlowLayout.LEFT);
        questBox.add(question);
        questBox.add(scoreLabel);

        questBox.setLayout(new GridLayout(2,1));

        String[] options = new String[4];


       updateOptions(d);

        ans1.setSize(100, 100);
        ans1.setFont(new Font("Verdana", Font.BOLD, 22));
        ans2.setFont(new Font("Verdana", Font.BOLD, 22));
        ans3.setFont(new Font("Verdana", Font.BOLD, 22));
        ans4.setFont(new Font("Verdana", Font.BOLD, 22));

        ansBox.setLayout(new GridLayout(2, 2));

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
                        updateScreenTime();
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


    public void game() throws InterruptedException {


        start=System.currentTimeMillis();
        frame.setVisible(true);
        updateScreenTime();

    }


    private void showRound(boolean[] r)
    {
        int sum=0;
        for (int i=0;i<4;i++)
            if (r[i])
                sum++;


        fr.setTitle("ROUND");

        fr.setLocation(40,200);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(300,300);
        fr.setResizable(false);
        fr.setBackground(Color.cyan);
        JLabel label=new JLabel("ROUND "+sum);
        JLabel l=new JLabel("Timer");

        label.setFont(new Font("Snap ITC",Font.PLAIN,45));
        l.setFont(new Font("Snap ITC",Font.BOLD,20));
        label.setVisible(true);
        l.setVisible(true);
        fr.add(label,BorderLayout.CENTER);
        fr.add(l,BorderLayout.PAGE_END);
        fr.setVisible(true);

    }
    public void correctAnswer()  {
        stop=System.currentTimeMillis();
        question.setText("Η ΣΩΣΤΗ ΑΠΑΝΤΗΣΗ ΕΙΝΑΙ "+answer1);
        question.setFont(new Font("Verdana",Font.BOLD,22));
        question.setVisible(true);
    }
    private void updateQuestion(DisplayQuestions d,JFrame menuFrame,int score,boolean solo,boolean[] rounds) throws InterruptedException {
        counter++;
        if (counter == 5) {
            JLabel label = new JLabel("ΤΕΛΟΣ ΓΥΡΟΥ! ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ " + score);
            TimeUnit.SECONDS.sleep(2);
            if (player == 0) {
                counter = 0;
                player = 1;
            } else {
                if (player == 1 && !solo)
                    label.setText("ΤΕΛΟΣ ΓΥΡΟΥ! ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ " + (int) score);
                frame.setVisible(false);
                JFrame frame1 = new JFrame("ΤΕΛΟΣ ΓΥΡΟΥ");
                frame1.setSize(200, 200);
                frame1.setLocationRelativeTo(null);

                frame1.add(label, BorderLayout.CENTER);
                frame1.setVisible(true);
                frame.setVisible(false);
                //kalo to epomeno round me tixaiotita
                Random r=new Random();
                int ran=0;
                boolean flag=true;
                for (int i=0;i<4;i++)
                    if (!rounds[i])
                        flag=false;
                if(flag)
                {
                    //THERMOMETRO
                }


                while(!flag)
                {
                    ran=r.nextInt(4);
                    if(!rounds[ran])
                    {
                        if(ran==2)
                        {
                            Betting b=new Betting();
                            b.showBetting(d,menuFrame,Ascore,Bscore,solo,rounds);
                        }
                        if(ran==0)
                        {
                            RightAnswer b=new RightAnswer();
                            b.showRightAnswer(d,menuFrame,Ascore,Bscore,solo,rounds);
                        }
                        if(ran==3)
                        {
                            //grigori
                        }



                        flag=true;
                    }

                }


            }
        } else {
            TimeUnit.SECONDS.sleep(2);
            question.setText("<HTML>" + d.questions(0) + "</HTML>");
            updateScreenTime();
          //  question.setVisible(true);
            start = System.currentTimeMillis();
        }
    }

    public void updateScreenTime() {

       scoreLabel.setText("Έχεις 5 δευτερόλεπτα να απαντήσεις, 'Οσο γρηγορότερα τόσο πιο πολλούς πόντους θα πάρεις");
        scoreLabel.setFont(new Font("Arial", Font.ITALIC, 15));
    }


    private int updateScore(int s)
    {
        long diff=stop-start;

        if(diff<5000)
        {
            s+=(int)((5000-diff)*0.2);
            scoreLabel.setText("ΤΟ ΣΚΟΡ ΣΟΥ +"+(int)((5000-diff)*0.2));
        }
        else
            scoreLabel.setText("ΕΚΤΟΣ ΧΡΟΝΟΥ");

        return s;

    }
    private void updateOptions(DisplayQuestions d)
    {
        String[] opt=d.options();
        ans1.setText("<HTML>"+opt[0]+"</HTML>");
        ans2.setText("<HTML>"+opt[1]+"</HTML>");
        ans3.setText("<HTML>"+opt[2]+"</HTML>");
        ans4.setText("<HTML>"+opt[3]+"</HTML>");
       // ansBox.setVisible(true);
        for (int i = 0; i < 4; i++)
            if (d.isCorrect(opt[i]))
                answer1 = opt[i];
        answer="<HTML>"+answer1+"</HTML>";

        updateScreenTime();
        scoreLabel.setVisible(true);
    }

}
