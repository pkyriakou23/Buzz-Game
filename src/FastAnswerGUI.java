import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FastAnswerGUI {
    private JFrame frame;
    JFrame fr;
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
    int firstA;
    int firstB;
    boolean aCorrect;
    boolean bCorrect;

    public FastAnswerGUI(){
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




    public void fastAnswerQuestions(DisplayQuestions d,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        rounds[3]=true;
        showRound(rounds);

        Ascore=scoreA;
        Bscore=scoreB;

        firstA=-1;
        firstB=-1;

        aCorrect=false;
        bCorrect=false;

        frame.setTitle("ΕΡΩΤΗΣΕΙΣ");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel dir=new JLabel("ΓΙΑ ΝΑ ΕΠΙΛΕΞΕΙΣ ΑΠΑΝΤΗΣΗ ΧΡΗΣΙΜΟΠΟΙΗΣΕ ΤΟ ΠΛΗΚΤΡΟΛΟΓΙΟ");
        JLabel directions1=new JLabel("1ος ΠΑΙΚΤΗΣ-> ΕΠΙΛΟΓΗ 1: W , ΕΠΙΛΟΓΗ 2: A , ΕΠΙΛΟΓΗ 3: S , ΕΠΙΛΟΓΗ 4: D");
        JLabel cont=new JLabel("ΓΙΑ ΤΗΝ ΕΠΟΜΕΝΗ ΕΡΩΤΗΣΗ ΠΑΤΗΣΕ ENTER!");
        JLabel directions2=new JLabel("2ος ΠΑΙΚΤΗΣ -> ΕΠΙΛΟΓΗ 1: I , ΕΠΙΛΟΓΗ 2: J , ΕΠΙΛΟΓΗ 3: K , ΕΠΙΛΟΓΗ 4: L");
        JPanel desc=new JPanel(new GridLayout(6,1));
        desc.add(cont);
        desc.add(dir);
        desc.add(directions1);
        desc.add(directions2);

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

        frame.setLayout(new GridLayout(3,1));
        frame.add(desc);
        frame.add(questBox);
        frame.add(ansBox);

        ans1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //first option -> Player 1:W , Player 2:I
                if(e.getKeyCode() == KeyEvent.VK_W){
                    ans1.doClick();
                    if(firstA<0 && firstB<0){
                        firstA=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans1.getText().equals(answer)){
                        aCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }

                if(e.getKeyCode()==KeyEvent.VK_I){
                    ans1.doClick();
                    if(firstA<0 && firstB<0){
                        firstB=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans1.getText().equals(answer)){
                        bCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }

                //second choice -> Player 1:A, Player 2:J
                if(e.getKeyCode()==KeyEvent.VK_A){
                    ans2.doClick();
                    if(firstA<0 && firstB<0){
                        firstA=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans2.getText().equals(answer)){
                        aCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_J){
                    ans2.doClick();
                    if(firstA<0 && firstB<0){
                        firstB=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans2.getText().equals(answer)){
                        bCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }

                //third choice -> Player 1:S , Player 2:K
                if(e.getKeyCode()==KeyEvent.VK_S){
                    ans3.doClick();
                    if(firstA<0 && firstB<0){
                        firstA=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans3.getText().equals(answer)){
                        aCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_K){
                    ans3.doClick();
                    if(firstA<0 && firstB<0){
                        firstB=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans3.getText().equals(answer)){
                        bCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }

                //fourth choice -> Player 1:D , Player 2:L
                if(e.getKeyCode()==KeyEvent.VK_D){
                    ans4.doClick();
                    if(firstA<0 && firstB<0){
                        firstA=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans4.getText().equals(answer)){
                        aCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_L){
                    ans4.doClick();
                    if(firstA<0 && firstB<0){
                        firstB=1;
                    }
                    else if(firstA>0 && firstB<0){
                        firstB=2;
                    }
                    else if(firstB>0 && firstA<0){
                        firstA=2;
                    }
                    if(ans4.getText().equals(answer)){
                        bCorrect=true;
                        if(firstA>0 && firstB>0) {
                            if (firstA == 1) {
                                if(aCorrect)
                                    Ascore+=1000;
                                if(bCorrect)
                                    Bscore+=500;
                            }
                            if(firstB==1) {
                                if(bCorrect)
                                    Bscore+=1000;
                                if(aCorrect)
                                    Ascore+=500;
                            }
                        }
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        updateQuestion(d,menuFrame,solo,Ascore,Bscore,rounds);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    updateOptions(d);
                }
            }
        });


    }


    public void game()  {

        frame.setVisible(true);
    }


    public void correctAnswer()  {
        question.setText("Η ΣΩΣΤΗ ΑΠΑΝΤΗΣΗ ΕΙΝΑΙ: "+answer);
        question.setFont(new Font("Verdana",Font.BOLD,22));
        question.setVisible(true);
    }
    private void updateQuestion(DisplayQuestions d,JFrame menuFrame,boolean solo,int scoreA,int scoreB,boolean[] rounds) throws InterruptedException {
        counter++;
        firstA=-1;
        firstB=-1;
        if(counter==5) {
            JLabel label = new JLabel("ΤΕΛΟΣ ΓΥΡΟΥ! ΠΑΙΚΤΗ 1 ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ: " + scoreA + "ΠΑΙΚΤΗ 2 ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ: "+ scoreB);
            TimeUnit.SECONDS.sleep(2);
            frame.setVisible(false);
            fr.setVisible(false);
            JFrame frame1 = new JFrame("ΤΕΛΟΣ ΓΥΡΟΥ!");
            frame1.setSize(200, 200);
            frame1.setLocationRelativeTo(null);

            frame1.add(label, BorderLayout.CENTER);
            label.setVisible(true);
            frame1.setVisible(true);
            TimeUnit.SECONDS.sleep(2);

            //kalo to epomeno round me tixaiotita
            Random r=new Random();
            int ran=0;
            boolean flag=true;
            for (int i=0;i<4;i++)
                if (!rounds[i])
                    flag=false;
            if(solo)
                flag=false;
            if(flag)
            {
                //THERMOMETRO
                ThermometerGUI t=new ThermometerGUI();
                t.showRoundScreen(d,menuFrame,Ascore,Bscore,solo,rounds);
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
                    if(ran==2)
                    {
                        Betting b=new Betting();
                        b.showBetting(d,menuFrame,Ascore,Bscore,solo,rounds);
                    }
                    if(ran==0)
                    {
                        RightAnswer ra=new RightAnswer();
                        ra.showRightAnswer(d,menuFrame,Ascore,Bscore,solo,rounds);
                    }




                    flag=true;
                }

            }

        }

        correctAnswer();
        TimeUnit.SECONDS.sleep(2);
        question.setText("<HTML>"+d.questions(0)+"</HTML>");
        question.setVisible(true);

    }

    private void updateOptions(DisplayQuestions d)
    {
        String[] opt=d.options();
        ans1.setText("<HTML>"+opt[0]+"</HTML>");
        ans2.setText("<HTML>"+opt[1]+"</HTML>");
        ans3.setText("<HTML>"+opt[2]+"</HTML>");
        ans4.setText("<HTML>"+opt[3]+"</HTML>");
        ansBox.setVisible(true);
        for (int i = 0; i < 4; i++)
            if (d.isCorrect(opt[i]))
                answer = opt[i];
        scoreLabel.setVisible(false);
    }

    private void showRound(boolean[] r)
    {
        int sum=0;
        for (int i=0;i<4;i++)
            if (r[i])
                sum++;


        JFrame fr=new JFrame();
        fr.setTitle("Round");
        fr.setLocation(40,200);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(400,400);
        fr.setResizable(true);
        fr.setBackground(Color.cyan);
        JLabel label=new JLabel("Round "+sum);
        JLabel l=new JLabel("Fast Answer");

        label.setFont(new Font("Snap ITC",Font.PLAIN,45));
        l.setFont(new Font("Snap ITC",Font.BOLD,20));
        label.setVisible(true);
        l.setVisible(true);
        fr.add(label,BorderLayout.CENTER);
        fr.add(l,BorderLayout.PAGE_END);
        fr.setVisible(true);
        game();
    }

}
