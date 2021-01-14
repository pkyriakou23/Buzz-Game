import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Κλάση η οποία υλοποιεί τον σχεδιασμό των κουμπιών του κεντρικού μενού του παιχνιδιού.
 * Το πρώτο κουμπί παρουσιάζει διάφορες πληροφορίες σχετικά με το παιχνίδι.
 * Το δεύτερο κουμπί αποτελεί το κουμπί έναρξης του παιχνιδιού, στο οποίο γίνεται η επιλογή του αριθμού
 * των παικτών και ξεκινά η διεξαγωγή του παιχνιδιού. Το τρίτο κουμπί χρησιμοποιείται
 * για να παρουσιάσει τα στατιστικά στοιχεία σχετικά με το σκορ των παικτών. Το τελευταίο κουμπί αποτελεί το
 * κουμπί εξόδου από το παιχνίδι.
 */

public class MenuButtons {
    private JFrame information;
    private JLabel desc;
    private ScoreFile s;
    private JFrame score;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την σχεδίαση και υλοποίηση των γραφικών
     * των κουμπιών του κεντρικού μενού, ξεχωριστά.
     */
    public MenuButtons(){
        information=new JFrame();
        desc=new JLabel();
        information.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        s=new ScoreFile();
        score=new JFrame();
    }

    /**
     * Κουμπί πληροφοριών.
     * Εμφανίζει κάποια βασικά στοιχεία για το παιχνίδι, όπως τον τίτλο του παιχνιδιού και τους κατασκευαστές του.
     */
    public void showInfo(){
        information.setTitle("Information");
        information.setLocationRelativeTo(null);
        information.setSize(800,600);
        information.getContentPane().setBackground(Color.white);
        information.setResizable(true);
        information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        desc.setHorizontalAlignment(SwingConstants.CENTER);
        desc.setVerticalAlignment(SwingConstants.CENTER);
        desc.setText("<html> Buzz Quiz World Game <br/> <br/> Code by: <br/> PANAYIOTIS KYRIACOU <br/> ALEXANDRA PROUNTZOU <br/> <br/> Project for OOP 2020-2021 <html>");
        desc.setFont(new Font("Snap ITC",Font.BOLD,45));
        desc.setForeground(Color.darkGray);

        information.add(desc,BorderLayout.CENTER);

        information.setVisible(true);
    }

    /**
     * Κουμπί εξόδου.
     * Εμφανίζει μήνυμα για επιβεβαίωση της εξόδου του χρήστη από το παιχνίδι και πραγματοποιεί
     * την έξοδο του από αυτό, σύμφωνα με την απάντηση του.
     */
    public void exitMessage(){
        JLabel label = new JLabel("Are you sure do you want to exit game?");
        label.setFont(new Font("Snap ITC", Font.BOLD, 20));
        int result=JOptionPane.showConfirmDialog(null,label,"Exit Game",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    /**
     * Κουμπί παρουσιάσης στατιστικών σκορ παιχνιδιού.
     * Εμφανίζει στην οθόνη με την βοήθεια της κλάσης ScoreFile
     * το υψηλότερο σκορ στο παιχνίδι ενός παίκτη καθώς και τις νίκες κάθε
     * παίκτη στο ανταγωνιστικό παιχνίδι δύο παικτών.
     * @throws IOException
     */
    public void showScore() throws IOException {
        score.setTitle("Score");
        score.setLocationRelativeTo(null);
        score.setSize(800,600);
        score.setResizable(true);
        score.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel scorePanel=new JPanel();
        scorePanel.setLayout(new GridLayout(3,1));

        JLabel titleHigh=new JLabel("HIGH SCORE");
        titleHigh.setFont(new Font("Snap ITC", Font.BOLD, 30));
        titleHigh.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleHigh.setAlignmentY(Component.CENTER_ALIGNMENT);
        JLabel highScore=new JLabel(String.valueOf(s.getHighScore()));
        highScore.setFont(new Font("Snap ITC", Font.BOLD, 30));
        highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScore.setAlignmentY(Component.CENTER_ALIGNMENT);

        scorePanel.add(titleHigh,BorderLayout.CENTER);
        scorePanel.add(highScore,BorderLayout.CENTER);

        JPanel winsPanel=new JPanel();
        winsPanel.setLayout(new GridLayout(3,10));
        JLabel titleWins=new JLabel("WINS TABLE");
        titleWins.setFont(new Font("Snap ITC", Font.BOLD, 30));
        JLabel names=new JLabel(s.getNames());
        names.setFont(new Font("Candara Light", Font.BOLD, 30));
        JLabel wins=new JLabel(s.getWins());
        wins.setFont(new Font("Candara Light", Font.BOLD, 30));
        winsPanel.add(titleWins);
        winsPanel.add(names);
        winsPanel.add(wins);

        JPanel total=new JPanel();
        total.add(scorePanel);
        total.add(winsPanel);
        score.add(total,BorderLayout.CENTER);

        score.setVisible(true);
    }
}
