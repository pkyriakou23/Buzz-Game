import javax.swing.*;
import java.awt.*;
import java.net.URL;

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
    public void showImage(int count)
    {
        String filename="image/"+count+".jpg";
        URL imageURL=this.getClass().getResource(filename);
        ImageIcon icon = new ImageIcon(imageURL);
        label.setIcon(icon);
        label.setToolTipText(filename);
        frame.setVisible(true);
    }
    public void hideImage()
    {
        frame.setVisible(false);
    }
}
