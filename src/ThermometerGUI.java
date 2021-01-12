import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ThermometerGUI {

    private JFrame frame;
    JFrame roundFrame;
    private JLabel question;
    private JLabel scoreLabel;
    private JButton ans1;
    private JButton ans2;
    private JButton ans3;
    private JButton ans4;
    private JPanel ansBox;
    private JPanel questBox;


    private int Ascore,Bscore;

    private int correctA,correctB;

    private int counter;
    private int player;

    String[] questions;
    String[][] options;
    String[] answers;

    public ThermometerGUI(){
        frame=new JFrame();
         roundFrame=new JFrame("ΤΕΛΕΥΤΑΙΟΣ ΓΥΡΟΣ");
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
        correctA=0;
        correctB=0;


    }




    public void thermometerQuestions(DisplayQuestions d,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        if (solo)
            player=1;

        Ascore=scoreA;
        Bscore=scoreB;

        frame.setTitle("ΕΡΩΤΗΣΕΙΣ");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        question.setText(questions[counter]);
        question.setAlignmentX(FlowLayout.LEFT);
        scoreLabel.setAlignmentX(FlowLayout.LEFT);
        questBox.add(question);
        questBox.add(scoreLabel);

        questBox.setLayout(new GridLayout(2,1));

        ans1.setText(options[counter][0]);
        ans2.setText(options[counter][1]);
        ans3.setText(options[counter][2]);
        ans4.setText(options[counter][3]);

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

                if (ans1.getText().equals(answers[counter])) {
                    if(solo || player==0)
                        correctA++;
                    else {
                        correctAnswer();
                        correctB++;
                    }
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
                updateOptions();
            }
        });

        ans2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (ans2.getText().equals(answers[counter])) {
                    if(solo || player==0)
                        correctA++;
                    else {
                        correctAnswer();
                        correctB++;
                    }
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
                updateOptions();
            }
        });

        ans3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (ans3.getText().equals(answers[counter])) {
                    if(solo || player==0)
                        correctA++;
                    else {
                        correctAnswer();
                        correctB++;
                    }
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
                updateOptions();
            }
        });

        ans4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (ans4.getText().equals(answers[counter])) {
                    if(solo || player==0)
                        correctA++;
                    else {
                        correctAnswer();
                        correctB++;
                    }
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
                updateOptions();
            }
        });

    }


    public void game()  {

        frame.setVisible(true);
    }



    public void correctAnswer()  {
        question.setText("Η ΣΩΣΤΗ ΑΠΑΝΤΗΣΗ ΕΙΝΑΙ: "+answers[counter]);
        question.setFont(new Font("Verdana",Font.BOLD,22));
        question.setVisible(true);
    }
    private void updateQuestion(DisplayQuestions d,JFrame menuFrame,int score,boolean solo,boolean[] rounds) throws InterruptedException {
        counter++;
        if(counter==5) {
            JLabel label = new JLabel();
            TimeUnit.SECONDS.sleep(2);
            if (player==0 )
            { counter = 0;
                player=1;
                TimeUnit.SECONDS.sleep(2);
                question.setText("<HTML>" + questions[counter] + "</HTML>");
                question.setVisible(true);
            } else {
                if(player==1 && solo )
                    label.setText("ΤΕΛΟΣ ΓΥΡΟΥ! ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ "+score);
                frame.setVisible(false);
                roundFrame.setVisible(false);
                JFrame frame1 = new JFrame("ΤΕΛΟΣ ΓΥΡΟΥ");
                frame1.setSize(200, 200);
                frame1.setLocationRelativeTo(null);
                if(correctA>correctB){
                    Ascore+=5000;
                    label.setText("ΠΑΙΚΤΗ 1 ΚΕΡΔΙΖΕΙΣ " + Ascore + "ΠΟΝΤΟΥΣ");
                }
                else if(correctB>correctA){
                    Bscore+=5000;
                    label.setText("ΠΑΙΚΤΗ 2 ΚΕΡΔΙΖΕΙΣ " + Bscore + "ΠΟΝΤΟΥΣ");
                }
                else{
                    Ascore+=5000;
                    Bscore+=5000;
                    label.setText("ΜΠΡΑΒΟ!! ΚΑΙ ΟΙ ΔΥΟ ΒΡΗΚΑΤΕ 5 ΣΩΣΤΕΣ ΑΠΑΝΤΗΣΕΙΣ!");
                }

                frame1.add(label, BorderLayout.CENTER);
                frame1.setVisible(true);

                //emfanizo to kentriko menu
                menuFrame.setVisible(true);
            }

        }else {
            TimeUnit.SECONDS.sleep(2);
            question.setText("<HTML>" + questions[counter] + "</HTML>");
            question.setVisible(true);
        }
    }

    private void updateOptions()
    {
        if(counter==5) {
            ans1.setText("<HTML>"+options[0][0]+"</HTML>");
            ans2.setText("<HTML>"+options[0][1]+"</HTML>");
            ans3.setText("<HTML>"+options[0][2]+"</HTML>");
            ans4.setText("<HTML>"+options[0][3]+"</HTML>");
        }
        else{
            ans1.setText("<HTML>"+options[counter][0]+"</HTML>");
            ans2.setText("<HTML>"+options[counter][1]+"</HTML>");
            ans3.setText("<HTML>"+options[counter][2]+"</HTML>");
            ans4.setText("<HTML>"+options[counter][3]+"</HTML>");
        }
        ansBox.setVisible(true);
    }


    public void showRoundScreen(DisplayQuestions d, JFrame mainScreen, int scoreA, int scoreB, boolean solo, boolean[] rounds) throws InterruptedException {

        roundFrame.setLocation(40,200);
        roundFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roundFrame.setSize(400,400);
        roundFrame.setResizable(true);
        roundFrame.setBackground(Color.cyan);
        JLabel roundLabel=new JLabel("Round 5 - THERMOMETER");
        roundLabel.setFont(new Font("Snap ITC",Font.PLAIN,45));
        roundLabel.setVisible(true);
        roundFrame.add(roundLabel,BorderLayout.CENTER);
        roundFrame.setVisible(true);

        questions=new String[5];
        options = new String[5][4];
        answers=new String[5];
        for(int i=0;i<5;i++){
            questions[i]=d.questions(0);
            options[i] = d.options();
            for (int j = 0; j < 4; j++)
                if (d.isCorrect(options[i][j]))
                    answers[i] = options[i][j];
        }

        thermometerQuestions(d,mainScreen,scoreA,scoreB,solo,rounds);
        game();

    }

    private String[] read() throws FileNotFoundException {
        String[] n=new String[2];
        File myObj = new File("names.txt");
        Scanner myReader = new Scanner(myObj);
        int j=0;
        while(myReader.hasNextLine()) {
            n[j] = myReader.nextLine();
            j++;
        }
        return n;
    }
}
