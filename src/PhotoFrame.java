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
        frame.setLocation(1200,100);
    }
    public void showImage(int count)
    {
        String filename="image/"+count+".jpeg";
        URL imageURL=this.getClass().getResource(filename); //this.getClass().getResource(filename);
        // imageURL = imageURL.getClass().getResource(filename);
        //   System.out.println(filename);
        System.out.println(imageURL);
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
