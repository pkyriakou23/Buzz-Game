import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayersGUI {

    private JPanel playerPanel;
    private JButton playersChoice1;
    private JButton playersChoice2;
    private JFrame playersFrame;
    private Players a,b;
    private boolean solo;

    public PlayersGUI(){
        playersFrame=new JFrame();
        playersChoice1=new JButton();
        playersChoice2=new JButton();
        playerPanel=new JPanel();
        a=new Players();
        b=new Players();
        solo=true;
    }

    public void choosePlayer(){

        playersChoice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo=true;
                UIManager.put("OptionPane.messageFont", new Font("Snap ITC", Font.PLAIN, 20));
                String nameA = JOptionPane.showInputDialog(null,"Enter your name: ");
                a.setName(nameA);
                if(nameA!=null) {
                    JOptionPane.showMessageDialog(null, "PlayerA: " + nameA);
                    playersFrame.setVisible(false);
                }
                else if(nameA==null)
                    JOptionPane.showMessageDialog(null,"Error! Name not declared!");
            }
        });

        playersChoice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo=false;
                UIManager.put("OptionPane.messageFont", new Font("Snap ITC", Font.PLAIN, 20));
                String nameA = JOptionPane.showInputDialog("Enter your name: ");
                Players a=new Players();
                if(nameA!=null)
                    JOptionPane.showMessageDialog(null, "PlayerA: " + nameA);
                else if(nameA==null){
                    JOptionPane.showMessageDialog(null,"Error! Name not declared!");
                }
                a.setName(nameA);

                String nameB = JOptionPane.showInputDialog("Enter your name: ");
                b.setName(nameB);
                if(nameB!=null)
                    JOptionPane.showMessageDialog(null, "PlayerB: " + nameB);
                else if(nameB==null)
                    JOptionPane.showMessageDialog(null,"Error! Name not declared!");

                if(nameA!=null && nameB!=null)
                    playersFrame.setVisible(false);
            }
        });

        playerPanel.setLayout(new GridLayout(2,1));

        playersChoice1.setText("1 Player");
        playersChoice1.setFont(new Font("Snap ITC",Font.PLAIN,45));
        playerPanel.add(playersChoice1);
        playersChoice2.setText("2 Players");
        playersChoice2.setFont(new Font("Snap ITC",Font.PLAIN,45));
        playerPanel.add(playersChoice2);
        playersFrame.setTitle("Players Screen");
        playersFrame.setSize(400,400);
        playersFrame.setLocationRelativeTo(null);
        playersFrame.add(playerPanel,BorderLayout.CENTER);

        playersFrame.setVisible(true);
    }

    public String getNameA(){
        return a.getName();
    }

    public String getNameB(){
        return b.getName();
    }

    public boolean getNumberOfPlayers(){
        return solo;
    }

}
