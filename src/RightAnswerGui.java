import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * Τύπος γύρου γραφικά: Σωστή Απάντηση
 *
 * Ο παίχτης εάν απαντήσει σωστά στην ερώτηση που του γίνεται κερδίζει 1000 πόντους.
 *
 */
public class RightAnswerGui {
    private JFrame frame;
    private JFrame fr;
    private JFrame fScore;
    private  JLabel l;
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
    String answer1;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την ομαλή διεξαγωγή του γύρου "Σωστή Απάντηση".
     */
    public RightAnswerGui(){
        frame=new JFrame();
        fr=new JFrame();
        fScore=new JFrame("ΣΚΟΡ");
        question=new JLabel();
        scoreLabel=new JLabel();
        l=new JLabel();
        fScore.add(l,BorderLayout.CENTER);
        ans1=new JButton();
        ans2=new JButton();
        ans3=new JButton();
        ans4=new JButton();
        ansBox=new JPanel();
        questBox=new JPanel();

        counter=0;
        player=0;
        Ascore=0;

    }


    /**
     *
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει αν το παιχνίδι παίζεται από έναν ή δύο παίκτες
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     *
     * Φτιάχνει το frame με τις ερώτησεις και τις αντίστοιχες επιλόγες.
     */
    public void QuestionsWindow(DisplayQuestions d,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        //Δήλωση μοναδικότητας εμφάνισης του γύρου "Σωστή Απάντηση"
        rounds[0]=true;
        if (solo)
            player=1;
        showRound(rounds,solo);
        Bscore=scoreB;
        Ascore=scoreA;

        //Σχεδιασμός παραθύρου εμφάνισης ερωτήσεων
        frame.setTitle("ΕΡΩΣΤΗΣΕΙΣ");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Επιλογή ερώτησης μέσω της βοηθητικής κλάσης DisplayQuestions
        question.setText(d.questions(0));
        question.setAlignmentX(FlowLayout.LEFT);
        scoreLabel.setAlignmentX(FlowLayout.LEFT);
        questBox.add(question);
        questBox.add(scoreLabel);
        questBox.setLayout(new GridLayout(2,1));

        //Επιλογή αντίστοιχων πιθανών απαντήσεων
        String[] options = new String[4];

        updateOptions(d);

        ans1.setSize(100, 100);
        ans1.setFont(new Font("Candara Light", Font.BOLD, 22));
        ans2.setFont(new Font("Candara Light", Font.BOLD, 22));
        ans3.setFont(new Font("Candara Light", Font.BOLD, 22));
        ans4.setFont(new Font("Candara Light", Font.BOLD, 22));

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
                    scoreLabel.setText("ΚΕΡΔΙΖΕΙΣ +1000");   //+scoreGain
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);

                    scoreLabel.setFont(new Font("Candara Light", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
                } catch (InterruptedException | IOException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });

        ans2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans2.getText().equals(answer)) {
                    scoreLabel.setText("ΚΕΡΔΙΖΕΙΣ +1000");
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);

                    scoreLabel.setFont(new Font("Candara Light", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
                } catch (InterruptedException | IOException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });

        ans3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans3.getText().equals(answer)) {
                    scoreLabel.setText("ΚΕΡΔΙΖΕΙΣ +1000");
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);
                    scoreLabel.setFont(new Font("Candara Light", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {

                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
                } catch (InterruptedException | IOException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });
        ans4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                correctAnswer();

                if (ans4.getText().equals(answer)) {
                    scoreLabel.setText("ΚΕΡΔΙΖΕΙΣ +1000");
                    if(solo || player==0)
                        Ascore=updateScore(Ascore);
                    else
                        Bscore=updateScore(Bscore);

                    scoreLabel.setFont(new Font("Candara Light", Font.BOLD, 22));
                    scoreLabel.setVisible(true);
                }


            }

            public void mouseReleased(MouseEvent e) {
                try {
                    if(solo || player==0)
                        updateQuestion(d,menuFrame,Ascore,solo,rounds);
                    else
                        updateQuestion(d,menuFrame,Bscore,solo,rounds);
                } catch (InterruptedException | IOException interruptedException) {
                    interruptedException.printStackTrace();
                }
                updateOptions(d);
            }
        });

    }

    /**
     * Ξεκινάει τον γύρο εμφανίζοντας το frame.
     * Εμφανίζει το frame που περιλαμβάνει το σκορ.
     */
    public void game()  {
        frame.setVisible(true);
        updateScore( Ascore-1000);
    }

    /**
     *
     * @param r Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @param solo Boolean μεταβλητή που καθορίζει αν το παιχνίδι παίζεται από έναν ή δύο παίκτες
     *
     *Δημιουργεί το frame στο οποίο αναγράφετε ο γύρος και ο τύπος γύρου.
     *
     */
    private void showRound(boolean[] r,boolean solo)
    {
        int sum=0;
        for (int i=0;i<4;i++)
            if (r[i])
                sum++;
        if(solo)
            sum--;


        fr.setTitle("Round");

        fr.setLocation(40,200);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(400,400);
        fr.setResizable(true);
        fr.setBackground(Color.cyan);
        JLabel label=new JLabel("ROUND "+sum);
        JLabel l=new JLabel("Right Answer");

        label.setFont(new Font("Snap ITC",Font.PLAIN,45));
        l.setFont(new Font("Snap ITC",Font.BOLD,20));
        label.setVisible(true);
        l.setVisible(true);
        fr.add(label,BorderLayout.CENTER);
        fr.add(l,BorderLayout.PAGE_END);
        fr.setVisible(true);
    }
    /**
     * Εμφανίζει την σωστή απάντηση.
     */
    public void correctAnswer()  {
        question.setText("Η ΣΩΣΤΗ ΑΠΑΝΤΗΣΗ ΕΙΝΑΙ "+answer1);
        question.setFont(new Font("Candara Light",Font.BOLD,22));
        question.setVisible(true);
    }

    /**
     *
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param score Το σκορ του παίκτη που διαγωνίζεται
     * @param solo Boolean μεταβλητή που καθορίζει αν το παιχνίδι παίζεται από έναν ή δύο παίκτες
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     * @throws IOException
     *
     * Εμφανίζει την καινούργια ερώτηση.
     * Ελέγχει αν είναι το τέλος του γύρου και προχωράει στον επόμενο γύρο.
     * Αν είναι το τέλος του παιχνιδιού ξεκινάει απο την αρχή εμφανίζοντας το κεντρικό menu.
     */
    private void updateQuestion(DisplayQuestions d,JFrame menuFrame,int score,boolean solo,boolean[] rounds) throws InterruptedException, IOException {
        counter++;
        if(counter==5) {
           fScore.setVisible(false);

            if (player==0 )
            { counter = 0; player=1; }
            else {
                frame.setVisible(false);

                fr.setVisible(false);

                //Κλήση επόμενου γύρου με τυχαιότητα
                Random r=new Random();
                int ran=0;
                boolean flag=true;
                for (int i=0;i<4;i++)
                    if (!rounds[i])
                        flag=false;

                if(flag&&!solo)
                {
                   ThermometerGUI t=new ThermometerGUI();
                   t.showRoundScreen(d,menuFrame,Ascore,Bscore,solo,rounds);
                }
                if(flag){
                    ScoreFile s=new ScoreFile();
                    s.setHighScore(Ascore);
                    ScoreButtonGUI sb =new ScoreButtonGUI();
                    sb.showScore();
                    menuFrame.setVisible(true);
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

                        if(ran==3)
                        {
                            FastAnswerGUI f=new FastAnswerGUI();
                            f.fastAnswerQuestions(d,menuFrame,Ascore,Bscore,solo,rounds);
                        }
                        if(ran==2)
                        {
                            Betting b=new Betting();
                            b.showBetting(d,menuFrame,Ascore,Bscore,solo,rounds);
                        }
                        flag=true;
                    }
                }
                fScore.setVisible(false);
            }
        }

        TimeUnit.SECONDS.sleep(2);
        question.setText("<HTML>"+d.questions(0)+"</HTML>");
        question.setVisible(true);

    }
    /**
     *
     * @param s το ήδη υπάρχων σκορ
     * @return s
     * Ανανεώνει το σκορ τόσο στο frame του όσο και στην μεταβλητή αποθηκευσής του.
     */
    private int updateScore(int s)
    {
        s+=1000;
        l.setText("Your score: "+s);
        l.setVisible(true);
        fScore.setSize(400,100);
        fScore.setLocation(30,30);
        fScore.setVisible(true);

        return s;
    }
    /**
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * Ανανεώνει τις πιθανές επιλογές και την απάντηση κάθε ερώτησης.
     */
    private void updateOptions(DisplayQuestions d)
    {
        String[] opt=d.options();
        ans1.setText("<HTML>"+opt[0]+"</HTML>");
        ans3.setText("<HTML>"+opt[2]+"</HTML>");
        ans4.setText("<HTML>"+opt[3]+"</HTML>");
        ans2.setText("<HTML>"+opt[1]+"</HTML>");
        ansBox.setVisible(true);
        for (int i = 0; i < 4; i++)
            if (d.isCorrect(opt[i]))
                answer1 = opt[i];
         answer="<HTML>"+answer1+"</HTML>";

        scoreLabel.setVisible(false);
    }

}
