import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtons {
    private JFrame information;
    private JLabel desc;


    public MenuButtons(){
        information=new JFrame();
        desc=new JLabel();
        information.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void showInfo(){
        information.setTitle("Information");
        information.setLocationRelativeTo(null);
        information.setSize(800,600);
        information.getContentPane().setBackground(Color.white);
        information.setResizable(true);
        information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        desc.setHorizontalAlignment(SwingConstants.CENTER);
        desc.setVerticalAlignment(SwingConstants.CENTER);
        desc.setText("<html> Buzz Quiz World Game <br/> <br/> Code by: <br/> PANAYIOTIS KYRIACOU <br/> ALEXANDRA PROUNTZOU <br/> <br/> Multiple Choice Questions Game <html>");
        desc.setFont(new Font("Snap ITC",Font.BOLD,45));
        desc.setForeground(Color.darkGray);

        information.add(desc,BorderLayout.CENTER);

        information.setVisible(true);
    }

    public void exitMessage(){
        JLabel label = new JLabel("Are you sure do you want to exit game?");
        label.setFont(new Font("Snap ITC", Font.BOLD, 20));
        int result=JOptionPane.showConfirmDialog(null,label,"Exit Game",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            System.exit(0);
        }
        /*else if(result==JOptionPane.NO_OPTION){

        }*/

    }
}
