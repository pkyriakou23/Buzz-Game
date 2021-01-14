import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Κουμπί παρουσιάσης στατιστικών σκορ παιχνιδιού.
 */

public class ScoreButtonGUI {

    private ScoreFile s;
    private JFrame score;
    private JPanel scorePanel;
    private JLabel titleHigh;
    private JLabel highScore;
    private JPanel winsPanel;
    private JLabel titleWins;
    private JLabel names;
    private JLabel wins;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την υλοποίηση της σχεδίασης
     * του κουμπιού που εμφανίζει το σκορ και τις νίκες των παικτών.
     */
    public ScoreButtonGUI(){
        s=new ScoreFile();
        score=new JFrame();
        scorePanel=new JPanel();
        titleHigh=new JLabel();
        highScore=new JLabel();
        winsPanel=new JPanel();
        titleWins=new JLabel();
        names=new JLabel();
        wins=new JLabel();
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

        scorePanel.setLayout(new GridLayout(3,1));

        titleHigh.setText("HIGH SCORE");
        titleHigh.setFont(new Font("Snap ITC", Font.BOLD, 30));
        titleHigh.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleHigh.setAlignmentY(Component.CENTER_ALIGNMENT);
        highScore.setText(String.valueOf(s.getHighScore()));
        highScore.setFont(new Font("Snap ITC", Font.BOLD, 30));
        highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScore.setAlignmentY(Component.CENTER_ALIGNMENT);

        scorePanel.add(titleHigh,BorderLayout.CENTER);
        scorePanel.add(highScore,BorderLayout.CENTER);

        winsPanel.setLayout(new GridLayout(3,10));
        titleWins.setText("WINS TABLE");
        titleWins.setFont(new Font("Snap ITC", Font.BOLD, 30));
        names.setText(s.getNames());
        names.setFont(new Font("Candara Light", Font.BOLD, 30));
        wins.setText(s.getWins());
        wins.setFont(new Font("Candara Light", Font.BOLD, 30));
        winsPanel.add(titleWins);
        winsPanel.add(names);
        winsPanel.add(wins);

        score.add(scorePanel,BorderLayout.PAGE_START);
        score.add(winsPanel,BorderLayout.PAGE_END);

        score.setVisible(true);
    }

}
