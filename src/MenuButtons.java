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

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιεί τις απαραίτητες μεταβλητές για την σχεδίαση και υλοποίηση των γραφικών
     * των κουμπιών του κεντρικού μενού, ξεχωριστά.
     */
    public MenuButtons(){
        information=new JFrame();
        desc=new JLabel();
        information.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

}
