import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Υλοποίηση τύπου γύρου: Γρήγορη απάντηση.
 * Ο πρώτος που απαντάει σωστά κερδίζει 1000 πόντους και ο δεύτερος
 * 500 πόντους. Αυτός ο τύπος γύρου εμφανίζεται μόνο όταν παίζουν 2 παίχτες.
 */

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

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την
     * υλοποίηση των γραφικών και την ομαλή διεξαγωγή του γύρου γρήγορη απάντηση.
     */

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

    /**
     * Σε αυτή την συνάρτηση υλοποιείται η εμφάνιση του κεντρικού παραθύρου ερωτήσεων. Αρχικοποείται ο σχεδιασμός του κεντρικού παραθύρου
     * με τις απαραίτητες ρυθμίσεις και δίνονται οι κατάλληλες οδηγίες/ διευκρινήσεις στον χρήστη για τον τρόπο διεξαγωγής του συγκεκριμένου γύρου.
     * Με την βοήθεια της κλάσης DisplayQuestions, η οποία περνιέται και σαν παράμετρος στην συνάρτηση, επιλέγονται και εμφανίζονται οι ερωτήσεις
     * που θα χρησιμοποιηθούν για την διεξαγωγή αυτού του γύρου ερωτήσεων.
     * Για την επιλογή μιας από τις 4 πιθανές απαντήσεις σε κάθε ερώτηση και οι δύο παίκτες χρησιμοποιούν το πληκτρολόγιο.
     * Ο πρώτος παίκτης μπορεί να επιλεξει μια από τις απαντήσεις χρησιμοποιώντας: για την ΕΠΙΛΟΓΗ 1 το πλήκτρο W, για την ΕΠΙΛΟΓΗ 2 το πλήκτρο E,
     * για την ΕΠΙΛΟΓΗ 3 το πλήκτρο S και τέλος για την ΕΠΙΛΟΓΗ 4 το πλήκτρο D. Αντίστοιχα, ο δεύτερος παίκτης μπορεί να χρησιμοποιήσει
     * για την ΕΠΙΛΟΓΗ 1 το πλήκτρο I, για την ΕΠΙΛΟΓΗ 2 το πλήκτρο O, για την ΕΠΙΛΟΓΗ 3 το πλήκτρο K και για την ΕΠΙΛΟΓΗ 4 το πλήκτρο L.
     * Η επιλογή των συγκεκριμένων πλήκτρων έγινε έτσι ώστε ο ένας παίκτης να μπορεί να χρησιμοποιήσει την δεξιά πλευρά του πληκτρολογίου και
     * ο άλλος την αριστερή. Όταν και οι δύο παίκτες επιλέξουν την απάντηση τους πιέζουν μία φορά το κουμπί του ENTER για να ακολουθήσει η επόμενη ερώτηση.
     *
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει ότι το παιχνίδι μπορεί να παιχτεί μόνο από δύο παίκτες ανταγωνιστικά
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     */

    public void fastAnswerQuestions(DisplayQuestions d,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        //Δήλωση μοναδικότητας εμφάνισης του γύρου "Γρήγορη απάντηση" στο παιχνίδι και εμφάνιση του αριθμού γύρου που διεξάγεται
        rounds[3]=true;
        showRound(rounds);

        //Βοηθητικές μεταβλητές για διατήρηση του σκορ των δύο παικτών, του πρώτου παίκτη που απαντά σε κάθε ερώτηση και την ορθότηττα της απάντησης του
        Ascore=scoreA;
        Bscore=scoreB;

        firstA=-1;
        firstB=-1;

        aCorrect=false;
        bCorrect=false;

        //Σχεδιασμός παραθύρου εμφάνισης ερωτήσεων
        frame.setTitle("ΕΡΩΤΗΣΕΙΣ");
        frame.setSize(700,500);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Οδηγίες για την επιλογή απάντησης για κάθε παίκτη
        JLabel dir=new JLabel("ΓΙΑ ΝΑ ΕΠΙΛΕΞΕΙΣ ΑΠΑΝΤΗΣΗ ΧΡΗΣΙΜΟΠΟΙΗΣΕ ΤΟ ΠΛΗΚΤΡΟΛΟΓΙΟ");
        JLabel directions1=new JLabel("1ος ΠΑΙΚΤΗΣ-> ΕΠΙΛΟΓΗ 1: W , ΕΠΙΛΟΓΗ 2: E , ΕΠΙΛΟΓΗ 3: S , ΕΠΙΛΟΓΗ 4: D");
        JLabel cont=new JLabel("ΓΙΑ ΤΗΝ ΕΠΟΜΕΝΗ ΕΡΩΤΗΣΗ ΠΑΤΗΣΕ ENTER ΜΙΑ ΦΟΡΑ! ΜΗΝ ΕΙΣΑΙ ΝΕΥΡΙΚΟΣ!");
        JLabel directions2=new JLabel("2ος ΠΑΙΚΤΗΣ -> ΕΠΙΛΟΓΗ 1: I , ΕΠΙΛΟΓΗ 2: O , ΕΠΙΛΟΓΗ 3: K , ΕΠΙΛΟΓΗ 4: L");
        JPanel desc=new JPanel(new GridLayout(6,1));
        desc.add(cont);
        desc.add(dir);
        desc.add(directions1);
        desc.add(directions2);

        //Επιλογή ερώτησης και απαραίτητες ενέργειες για την εμφάνιση της στην οθόνη
        question.setText(d.questions(0));
        question.setFont(new Font("Candara Light",Font.BOLD,22));
        question.setAlignmentX(FlowLayout.LEFT);
        scoreLabel.setAlignmentX(FlowLayout.LEFT);
        questBox.add(question);
        questBox.add(scoreLabel);

        questBox.setLayout(new GridLayout(2,1));

        //Επιλογή πιθανών απαντήσεων από την κλάση DisplayQuestions
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
        ans1.setFont(new Font("Candara Light", Font.BOLD, 22));
        ans2.setFont(new Font("Candara Light", Font.BOLD, 22));
        ans3.setFont(new Font("Candara Light", Font.BOLD, 22));
        ans4.setFont(new Font("Candara Light", Font.BOLD, 22));

        ansBox.setLayout(new GridLayout(2, 2));
        ansBox.add(ans1);
        ansBox.add(ans2);
        ansBox.add(ans3);
        ansBox.add(ans4);

        frame.setLayout(new GridLayout(3,1));
        frame.add(desc);
        frame.add(questBox);
        frame.add(ansBox);

        //Καθορισμός πλήκτρων για επιλογή απάντησης από κάθε παίκτη, έλεγχος εαν ενέργησε πρώτος και αν η απάντηση που δώθηκε ήταν σωστή για καθορισμό του σκορ
        ans1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //ΕΠΙΛΟΓΗ 1 -> Παίκτης 1:W , Παίκτης 2:I
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

                //ΕΠΙΛΟΓΗ 2 -> Παίκτης 1:E, Παίκτης 2:O
                if(e.getKeyCode()==KeyEvent.VK_E){
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
                if(e.getKeyCode()==KeyEvent.VK_O){
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

                //ΕΠΙΛΟΓΗ 3 -> Παίκτης 1:S , Παίκτης 2:K
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

                //ΕΠΙΛΟΓΗ 4 -> Παίκτης 1:D , Παίκτης 2:L
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
                // ENTER για επόμενη ερώτηση
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

    /**
     * Συνάρτηση για εμφάνιση του παραθύρου ερωτήσεων στην οθόνη
     */
    public void game()  {
        frame.setVisible(true);
    }

    /**
     * Εμφάνιση σωστής ερώτησης στον παίκτη
     */
    public void correctAnswer()  {
        question.setText("Η ΣΩΣΤΗ ΑΠΑΝΤΗΣΗ ΕΙΝΑΙ: "+answer);
        question.setFont(new Font("Candara Light",Font.BOLD,22));
        question.setVisible(true);
    }

    /**
     * Συνάρτηση για ανανέωση ερωτήσεων. Μετρά τις ερωτήσεις, έτσι ώστε όταν φτάσει στον επιθυμητό αριθμό ερωτήσεων να περάσει στον επόμενο γύρο.
     * Εμφάνιση παραθύρου για πληροφόρηση του παίκτη για το συγκεντρωτικό του σκορ και ενημέρωσή του ότι θα ακολουθήσει ο επόμενος γύρος.
     *
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει ότι το παιχνίδι μπορεί να παιχτεί μόνο από δύο παίκτες ανταγωνιστικά
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     */
    private void updateQuestion(DisplayQuestions d,JFrame menuFrame,boolean solo,int scoreA,int scoreB,boolean[] rounds) throws InterruptedException {
        counter++;
        firstA=-1;
        firstB=-1;
        if(counter==5) {
            JLabel label = new JLabel("ΤΕΛΟΣ ΓΥΡΟΥ! ΠΑΙΚΤΗ 1 ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ: " + scoreA + "ΠΑΙΚΤΗ 2 ΤΟ ΣΚΟΡ ΣΟΥ ΕΙΝΑΙ: "+ scoreB);
            label.setFont(new Font("Candara Light",Font.BOLD,22));
            label.setAlignmentY(Component.CENTER_ALIGNMENT);
            label.setAlignmentY(Component.CENTER_ALIGNMENT);
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

            //Κλήση επόμενου γύρου με τυχαιότητα
            Random r=new Random();
            int ran=0;
            boolean flag=true;
            for (int i=0;i<4;i++)
                if (!rounds[i])
                    flag=false;
            if(solo)
                flag=false;
            //Αν ο γύρος που ακολουθεί είναι ο τελευταίος, αφού αποτελεί παιχνίδι δύο παικτών, αυτός θα πρέπει να είναι το θερμόμετρο.
            if(flag)
            {
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

        //Ανανέωση ερώτησης, αν ο γύρος δεν έχει τελειώσει
        correctAnswer();
        TimeUnit.SECONDS.sleep(2);
        question.setText("<HTML>"+d.questions(0)+"</HTML>");
        question.setVisible(true);

    }

    /**
     * Συνάρτηση για ανανέωση των πιθανών απάντησεων κάθε ερώτησης. Καλείται κάθε φορά που ο παίκτης απαντάει μία ερώτηση.
     * @param d Βοηθητική κλάση για επιλογή των πιθανών απαντήσεων.
     */
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

    /**
     * Συνάρτηση για την εμφάνιση του πλαισίου που αφορά τον αριθμό και τον τύπο του γύρου ερώτησης.
     * Αυτό το παράθυρο παραμένει ορατό μέχρι το τέλος κάθε γύρου.
     * @param r Μεταβλητή για καθορισμό του αριθμού του γύρου που διεξάγεται.
     */
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
