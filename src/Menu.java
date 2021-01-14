import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Κλάση η οποία υλοποιεί τον σχεδιασμό του κεντρικού μενού του παιχνιδιού.
 * Το κεντρικό μενού αποτελείται από τέσσερα κουμπιά. Το πρώτο κουμπί που εμφανίζεται παρουσιάζει διάφορες
 * πληροφορίες σχετικά με το παιχνίδι. Το δεύτερο κουμπί αποτελεί το κουμπί έναρξης του παιχνιδιού, στο οποίο
 * γίνεται η επιλογή του αριθμού των παικτών και ξεκινά η διεξαγωγή του παιχνιδιού. Το τρίτο κουμπί χρησιμοποιείται
 * για να παρουσιάσει τα στατιστικά στοιχεία σχετικά με το σκορ των παικτών. Το τελευταίο κουμπί αποτελεί το
 * κουμπί εξόδου από το παιχνίδι.
 */

public class Menu {
    private JFrame menu;
    private JButton infoButton;
    private JPanel buttonsPanel;
    private MenuButtons buttons;
    private JButton play;
    private RightAnswerGui question;
    private JLabel title;
    private JButton exit;
    private PlayersGUI p;
    private JButton showScore;
    private ScoreButtonGUI scoreBut;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την σχεδίαση και υλοποίηση των γραφικών
     * του κεντρικού μενού. Σε αυτή την κλάση συνδέεται η κλάση MenuButtons η οποία
     * περιλαμβάνει την υλοποίηση κάθε κουμπιού ξεχωριστά.
     */
    public Menu(){
        menu=new JFrame();
        infoButton=new JButton();
        buttonsPanel=new JPanel();
        buttons=new MenuButtons();
        play=new JButton();
        question=new RightAnswerGui();
        title=new JLabel();
        exit=new JButton();
        p=new PlayersGUI();
        showScore=new JButton();
        scoreBut=new ScoreButtonGUI();
    }

    /**
     * Συνάρτηση η οποία δημιουργεί το παράθυρο του μενού.
     * Δίνει έναν τίτλο στο πάνω μέρος της οθόνης που εμφανίζεται με το όνομα του παιχνιδιού
     * και έπειτα παρουσιάζει τα κουμπιά που περιγράφονται παραπάνω.
     */
    public void createMenuScreen(){
        menu.setTitle("Buzz Quiz World Game");
        menu.setLocationRelativeTo(null);
        menu.setSize(800,300);
        menu.setResizable(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Τίτλος
        title.setText("BUZZ QUIZ WORLD GAME");
        title.setFont(new Font("Snap ITC", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        buttonsPanel.add(title);

        //Κουμοί πληροφοριών
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.showInfo();
            }
        });
        infoButton.setText("INFO");
        infoButton.setSize(10,5);
        infoButton.setFont(new Font("Snap ITC",Font.PLAIN,45));
        buttonsPanel.add(infoButton);

        //Κουμπί έναρξης παιχνιδιού
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.choosePlayer(menu);
            }
        });
        play.setText("PLAY");
        play.setFont(new Font("Snap ITC",Font.PLAIN,45));
        play.setSize(10,5);
        buttonsPanel.add(play);

        //Κουμπί εμφάνισης σκορ
        showScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    scoreBut.showScore();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        showScore.setText("SCORE");
        showScore.setFont(new Font("Snap ITC",Font.PLAIN,45));
        buttonsPanel.add(showScore);

        //Κουμπί εξόδου
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.exitMessage();
            }
        });
        exit.setText("EXIT");
        exit.setFont(new Font("Snap ITC",Font.PLAIN,45));
        buttonsPanel.add(exit);

        buttonsPanel.setLayout(new GridLayout(6,1));

        menu.add(buttonsPanel,BorderLayout.CENTER);

    }

    /**
     * Συνάρτηση η οποία κάνει ορατό το κεντρικό μενού ξεκινώντας το παιχνίδι.
     */
    public void start(){
        menu.setVisible(true);
    }

    /**
     * Συνάρτηση η οποία κρύβει το κεντρικό μενού.
     */
    public void hideMenu(){
        menu.setVisible(false);
    }

}
