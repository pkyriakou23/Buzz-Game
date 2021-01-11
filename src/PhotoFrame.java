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
        frame.setSize(1300,1300);
        frame.setLocation(1000,100);
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
