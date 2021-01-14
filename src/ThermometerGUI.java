import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Υλοποίηση τύπου γύρου Θερμόμετρο. Σε αυτόν τον τύπο γύρου ο πρώτος παίχτης που θα απαντήσει σωστά 5 ερωτήσεις κερδίζει 5000
 * πόντους. Αυτός ο τύπος ερώτησης έχει νόημα μόνο όταν παίζουν δύο παίχτες.
 */

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
    private ScoreFile s;
    private int Ascore,Bscore;
    private int correctA,correctB;
    private int counter;
    private int player;
    String[] questions;
    String[][] options;
    String[] answers;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποεί τις απαραίτητες μεταβλητές για την
     * υλοποίηση των γραφικών και την ομαλή διεξαγωγή του γύρου θερμόμετρο.
     */

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
        s=new ScoreFile();
    }

    /**
     * Σε αυτή την συνάρτηση υλοποιείται η εμφάνιση του κεντρικού παραθύρου ερωτήσεων. Πρώτα, αρχικοποείται ο σχεδιασμός του κεντρικού παραθύρου
     * με τις απαραίτητες ρυθμίσεις. Με την βοήθεια της κλάσης DisplayQuestions, η οποία περνιέται και σαν παράμετρος στην συνάρτηση, επιλέγονται
     * και εμφανίζονται οι ερωτήσεις που θα χρησιμοποιηθούν για την διεξαγωγή αυτού του γύρου ερωτήσεων. Στον γύρο θερμόμετρο οι ερωτήσεις που εμφανίζονται
     * στους δύο παίκτες είναι οι ίδιες. Οι παίκτες παίζουν με την σειρά διαδοχικά ο ένας μετά τον άλλο και επιλέγουν τις απαντήσεις τους ανάμεσα στις
     * τέσσερις πιθανές επιλογές χρησιμοποιώντας το ποντίκι του υπολογιστή τους. Οι σωστές απαντήσεις των ερωτήσεων εμφανίζονται αφού έχει ήδη παίξει
     * ο πρώτος παίκτης, δηλαδή την δεύτερη φορά που παίζεται αυτός ο γύρος (από τον δεύτερο παίκτη). Με αυτό τον τρόπο εξασφαλίζεται ότι ο δεύτερος
     * παίκτης δεν θα γνωρίζει ήδη τις απαντήσεις των ερωτήσεων. Ο τύπος γύρου θερμόμετρο αποτελεί τον τελευταίο γύρο του παιχνιδιού με δύο παίκτες.
     *
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει ότι το παιχνίδι μπορεί να παιχτεί μόνο από δύο παίκτες ανταγωνιστικά
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     */

    public void thermometerQuestions(DisplayQuestions d,JFrame menuFrame,int scoreA,int scoreB,boolean solo,boolean[] rounds) throws InterruptedException
    {
        if (solo)
            player=1;

        //Βοηθητικές μεταβλητές για διατήρηση του σκορ των δύο παικτών
        Ascore=scoreA;
        Bscore=scoreB;

        //Σχεδιασμός παραθύρου εμφάνισης ερωτήσεων
        frame.setTitle("ΕΡΩΤΗΣΕΙΣ");
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Επιλογή ερώτησης και απαραίτητες ενέργειες για την εμφάνιση της στην οθόνη
        question.setText(questions[counter]);
        question.setFont(new Font("Candara Light",Font.BOLD,22));
        question.setAlignmentX(FlowLayout.LEFT);
        scoreLabel.setAlignmentX(FlowLayout.LEFT);
        questBox.add(question);
        questBox.add(scoreLabel);

        questBox.setLayout(new GridLayout(2,1));

        //Επιλογή πιθανών απαντήσεων από την κλάση DisplayQuestions
        ans1.setText(options[counter][0]);
        ans2.setText(options[counter][1]);
        ans3.setText(options[counter][2]);
        ans4.setText(options[counter][3]);

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

        //Υλοποίηση επιλογής κουμπιού από τον χρήστη και έλεγχος ορθότητας απάντησης. Εμφάνιση σωστής απάντησης μόνο στον δεύτερο παίκτη.
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

    /**
     * Συνάρτηση για εμφάνιση του παραθύρου ερωτήσεων στην οθόνη
     */
    public void game()  {
        frame.setVisible(true);
    }

    /**
     * Συνάρτηση για εμφάνιση της σωστής απάντησης στον παίκτη.
     */
    public void correctAnswer()  {
        question.setText("Η ΣΩΣΤΗ ΑΠΑΝΤΗΣΗ ΕΙΝΑΙ: "+answers[counter]);
        question.setFont(new Font("Candara Light",Font.BOLD,22));
        question.setVisible(true);
    }

    /**
     * Συνάρτηση για ανανέωση ερωτήσεων. Μετρά τις ερωτήσεις, έτσι ώστε όταν φτάσει στον επιθυμητό αριθμό ερωτήσεων να περάσει στον επόμενο γύρο.
     * Εμφάνιση παραθύρου για πληροφόρηση του παίκτη για το συγκεντρωτικό του σκορ και ενημέρωσή του ότι θα ακολουθήσει ο επόμενος γύρος.
     * Μόλις φτάσει το τέλος του γύρου γίνεται καταγραφή της νίκης του παίκτη που κέρδισε σε αυτό τον γύρο σε αρχείο, το οποίο χρησιμοποιείται
     * για την αποθήκευση του πλήθος των νικών κάθε παίκτη. Για την καταγραφή της νίκης του παίκτη σε αρχείο χρησιμοποιείται η κλάση ScoreFile.
     *
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param menuFrame Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param score Το σκορ του 1ου ή του 2ου παίκτη, ανάλογα με το ποιος έχει σειρά
     * @param solo Boolean μεταβλητή που καθορίζει ότι το παιχνίδι μπορεί να παιχτεί μόνο από δύο παίκτες ανταγωνιστικά
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     */
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

                //Καταγραφή της νίκης του 1ου ή του 2ου παίκτη σε αρχείο.
                String[] n=new String[2];
                try {
                    n=read();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                s.findPlayers(n[0],n[1]);
                if(Ascore>Bscore)
                    s.addWin(true,false);
                else if(Bscore>Ascore)
                    s.addWin(false,true);
                else
                    s.addWin(true,true);
                s.setWins();
                s.writeWins();
                //Εμφάνιση του κεντρικού μενού
                menuFrame.setVisible(true);
            }
        }else {
            //Ανανέωση ερώτησης, αν ο γύρος δεν έχει τελειώσει
            TimeUnit.SECONDS.sleep(2);
            question.setText("<HTML>" + questions[counter] + "</HTML>");
            question.setVisible(true);
        }
    }

    /**
     * Συνάρτηση για ανανέωση των πιθανών απάντησεων κάθε ερώτησης. Καλείται κάθε φορά που ο παίκτης απαντάει μία ερώτηση.
     */
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

    /**
     * Συνάρτηση για την εμφάνιση του πλαισίου που αφορά τον αριθμό και τον τύπο του γύρου ερώτησης.
     * Αυτό το παράθυρο παραμένει ορατό μέχρι το τέλος κάθε γύρου.
     *
     * @param d Η βοηθητική κλάση DisplayQuestions για την εμφάνιση των ερωτήσεων
     * @param mainScreen Το αρχικό μενού, το οποίο μπορεί να χρειαστεί να εμφανιστεί μετά το τέλος του γύρου
     * @param scoreA Το σκορ του 1ου παίκτη
     * @param scoreB Το σκορ του 2ου παίκτη
     * @param solo Boolean μεταβλητή που καθορίζει ότι το παιχνίδι μπορεί να παιχτεί μόνο από δύο παίκτες ανταγωνιστικά
     * @param rounds Βοηθητική μεταβλητή για την τυχαία σειρά εμφάνισης των διαφόρων τύπων γύρων του παιχνιδιού
     * @throws InterruptedException
     */
    public void showRoundScreen(DisplayQuestions d, JFrame mainScreen, int scoreA, int scoreB, boolean solo, boolean[] rounds) throws InterruptedException {

        roundFrame.setLocation(40,200);
        roundFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roundFrame.setSize(400,400);
        roundFrame.setResizable(true);
        roundFrame.setBackground(Color.cyan);
        JLabel roundLabel=new JLabel("Round 5");
        roundLabel.setFont(new Font("Snap ITC",Font.PLAIN,45));
        JLabel nameOfRound=new JLabel("Thermometer");
        nameOfRound.setFont(new Font("Snap ITC",Font.PLAIN,45));
        roundLabel.setVisible(true);
        nameOfRound.setVisible(true);
        JPanel roundPanel=new JPanel();
        roundPanel.add(roundLabel);
        roundPanel.add(nameOfRound);
        roundPanel.setLayout(new GridLayout(2,1));
        roundFrame.add(roundPanel,BorderLayout.CENTER);
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

    /**
     * Συνάρτηση η οποία διαβάζει από το αρχείο names.txt τα ονόματα των διαγωνιζόμενων παικτών και τα επιστρέφει όταν ζητηθούν.
     * Αυτή η συνάρτηση λειτουργεί βοηθητικά ώστε να διαβάζονται τα ονόματα των δύο παικτών όπου είναι απαραίτητα.
     *
     * @return Επιστρέφει έναν πίνακα δύο θέσεων που επιστρέφει τα ονόματα των δύο παικτών που ανταγωνίζονται.
     * @throws FileNotFoundException
     */
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
