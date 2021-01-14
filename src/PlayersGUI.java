import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Κλάση η οποία υλοποιεί την οντότητα των παικτών στο παιχνίδι.
 */
public class PlayersGUI {

    private JPanel playerPanel;
    private JButton playersChoice1;
    private JButton playersChoice2;
    private JFrame playersFrame;
    private boolean solo;
    private String nameA,nameB;
    private boolean done;
    private int scoreA,scoreB;
    private int numberOfRoundsA;
    private Round r;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την
     * υλοποίηση των γραφικών και την επιλογή του αριθμού των παικτών.
     */
    public PlayersGUI(){
        playersFrame=new JFrame();
        playersChoice1=new JButton();
        playersChoice2=new JButton();
        playerPanel=new JPanel();
        nameA=null;
        nameB=null;
        solo=true;
        done=false;
        scoreA=0;
        numberOfRoundsA=0;
        scoreB=0;
        r=new Round();
    }

    /**
     * Συνάρτηση η οποία βοηθά στην επιλογή ενός ή δύο παικτών για την διεξαγωγή του παιχνιδιού.
     * Αν ο χρήστης επιλέξει ότι θα παίξει με έναν παίκτη τότε εμφανίζεται ένα πλαίσιο για την καταχώρηση του ονόματος
     * του παίκτη και έπειτα ένα πλαίσιο για επιβεβαίωση αυτού του ονόματος. Αντίστοιχα αν ο χρήστης κάνει την επιλογή των
     * δύο παικτών εμφανίζεται για τον κάθε παίκτη το αντίστοιχο πλαίσιο καταχώρησης του ονόματός του και το πλαίσιο επιβεβαίωσης.
     *
     * @param mainScreen
     */
    public void choosePlayer(JFrame mainScreen){

        playersChoice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo=true;
                UIManager.put("OptionPane.messageFont", new Font("Candara Light", Font.PLAIN, 20));
                nameA = JOptionPane.showInputDialog(null,"NAME: ");
                if(nameA!=null) {
                    JOptionPane.showMessageDialog(null, "PLAYER1: " + nameA);
                    playersFrame.setVisible(false);
                    done=true;
                }
                else if(nameA==null)
                    JOptionPane.showMessageDialog(null,"Error! ΔΕΝ ΕΔΩΣΕΣ ΟΝΟΜΑ!");
                try {
                    r.startRound(mainScreen,scoreA,scoreB,solo);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                try {
                    write();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                mainScreen.setVisible(false);
            }
        });

        playersChoice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo=false;
                UIManager.put("OptionPane.messageFont", new Font("Candara Light", Font.PLAIN, 20));
                nameA = JOptionPane.showInputDialog("NAME: ");
                if(nameA!=null)
                    JOptionPane.showMessageDialog(null, "PLAYER1: " + nameA);
                else if(nameA==null){
                    JOptionPane.showMessageDialog(null,"Error! NAME NOT DECLARED!");
                }

                nameB = JOptionPane.showInputDialog("NAME B: ");
                if(nameB!=null)
                    JOptionPane.showMessageDialog(null, "PLAYER1: " + nameB);
                else if(nameB==null)
                    JOptionPane.showMessageDialog(null,"Error! NAME NOT DECLARED!");

                if(nameA!=null && nameB!=null) {

                    playersFrame.setVisible(false);
                    done=true;
                    try {
                        write();
                        r.startRound(mainScreen,scoreA,scoreB,solo);
                    } catch (InterruptedException | IOException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
        });

        playerPanel.setLayout(new GridLayout(2,1));

        playersChoice1.setText("1 PLAYER");
        playersChoice1.setFont(new Font("Snap ITC",Font.PLAIN,45));
        playerPanel.add(playersChoice1);
        playersChoice2.setText("2 PLAYERS");
        playersChoice2.setFont(new Font("Snap ITC",Font.PLAIN,45));
        playerPanel.add(playersChoice2);
        playersFrame.setTitle("ΟΘΟΝΗ ΠΑΙΚΤΗ");
        playersFrame.setSize(400,400);
        playersFrame.setLocationRelativeTo(null);
        playersFrame.add(playerPanel,BorderLayout.CENTER);

        playersFrame.setVisible(true);
    }

    /**
     * Συνάρτηση η οποία επιστρέφει το όνομα του 1ου παίκτη.
     * @return nameA
     */
    public String getNameA(){
        return nameA;
    }

    /**
     * Συνάρτηση η οποία επιστρέφει το όνομα του 2ου παίκτη.
     * @return nameB
     */
    public String getNameB(){
        return nameB;
    }

    /**
     * Συνάρτηση η οποία επιστρέφει μία boolean μεταβλητή που έχει την τιμή true εαν ο παίκτης
     * είναι ένας. Διαφορετικά επιστρέφει την τιμή false που καθορίζει ότι το παιχνίδι παίζεται
     * ανταγωνιστηκά ανάμεσα σε δύο παίκτες.
     * @return solo
     */
    public boolean getNumberOfPlayers(){
        return solo;
    }

    /**
     * Συνάρτηση η οποία επιτρέφει την τιμή true εαν η διαδικασία επιλογής αριθμού παικτών και
     * καταχώρησης των ονομάτων τους έχει ολοκληρωθεί.
     * @return done
     */
    public boolean getDone(){
        return done;
    }

    /**
     * Συνάρτηση η οποία υλοποιεί την παρουσίαση του κουμπιού info
     * στην αρχική οθόνη του menu του παιχνιδιού.
     */
    public void playerInfo(){
        JLabel label=new JLabel(nameA);
        label.setFont(new Font("Snap ITC", Font.BOLD, 20));
        JOptionPane.showConfirmDialog(null,label,"INFO",JOptionPane.YES_OPTION);
    }

    /**
     * Συνάρτηση η οποία καταγράφει τα ονόματα των παικτών, σε περίπτωση ανταγωνιστικού παιχνιδιού,
     * σε αρχείο με το όνομα names.txt, έτσι ώστε να μπορούν να εμφανιστούν όποτε είναι απαραίτητο.
     * @throws IOException
     */
    public void write() throws IOException {
        try {
            FileWriter out = new FileWriter("names.txt");
            out.write(getNameA()+"\n");
            if(getNameB()!=null)
                out.write(getNameB());
            out.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred");
        }
    }


}
