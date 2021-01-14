import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Κλάση για εμφάνιση των φωτογραφιών όπου το απαιτεί ο τύπος της ερώτησης.
 * Στο παιχνίδι μπορεί να υπάρχουν δύο τύποι ερωτήσεων: ένας με ερώτηση χωρίς εικόνα και ένας με ερώτηση που συνοδεύεται από εικόνα.
 */
public class PhotoFrame {
    JFrame frame;
    JLabel label;

    public PhotoFrame()
    {
        frame=new JFrame("ΕΡΩΤΗΣΗ ΜΕ ΕΙΚΟΝΑ");
        label=new JLabel();
        frame.add(label, BorderLayout.CENTER);
        frame.setSize(400,400);
        frame.setLocation(1300,100);
        frame.setFocusable(false);
    }

    /**
     *
     * @param count
     * Συνάρτηση για την εμφάνιση της εικόνας.
     */
    public void showImage(int count)
    {
        String filename="image/"+count+".jpg";
        URL imageURL=this.getClass().getResource(filename);
        ImageIcon icon = new ImageIcon(imageURL);
        label.setIcon(icon);
        label.setToolTipText(filename);
        frame.setVisible(true);
    }

    /**
     * Κρύβει την εικόνα, αφού απαντηθεί η ερώτηση που πλαισιώνει.
     */
    public void hideImage()
    {
        frame.setVisible(false);
    }
}
