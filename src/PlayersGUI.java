import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayersGUI {

    private JPanel playerPanel;
    private JButton playersChoice1;
    private JButton playersChoice2;
    private JFrame playersFrame;
    private boolean solo;
    private String nameA,nameB;
    private boolean done;
    private int scoreA,scoreB;
    private int numberOfRoundsA,numberOfRoundsB;
    private Round r;

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
        numberOfRoundsB=0;
        r=new Round();
    }

    public void choosePlayer(JFrame mainScreen){

        playersChoice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo=true;
                UIManager.put("OptionPane.messageFont", new Font("Snap ITC", Font.PLAIN, 20));
                nameA = JOptionPane.showInputDialog(null,"Enter your name: ");
                if(nameA!=null) {
                    JOptionPane.showMessageDialog(null, "PlayerA: " + nameA);
                    playersFrame.setVisible(false);
                    done=true;
                }
                else if(nameA==null)
                    JOptionPane.showMessageDialog(null,"Error! Name not declared!");
                try {
                    r.startRound(mainScreen);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                mainScreen.setVisible(false);
            }
        });

        playersChoice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo=false;
                UIManager.put("OptionPane.messageFont", new Font("Snap ITC", Font.PLAIN, 20));
                nameA = JOptionPane.showInputDialog("Enter your name: ");
                if(nameA!=null)
                    JOptionPane.showMessageDialog(null, "PlayerA: " + nameA);
                else if(nameA==null){
                    JOptionPane.showMessageDialog(null,"Error! Name not declared!");
                }

                nameB = JOptionPane.showInputDialog("Enter your name: ");
                if(nameB!=null)
                    JOptionPane.showMessageDialog(null, "PlayerB: " + nameB);
                else if(nameB==null)
                    JOptionPane.showMessageDialog(null,"Error! Name not declared!");

                if(nameA!=null && nameB!=null) {
                    playersFrame.setVisible(false);
                    done=true;
                }
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
        return nameA;
    }

    public String getNameB(){
        return nameB;
    }

    public boolean getNumberOfPlayers(){
        return solo;
    }

    public boolean getDone(){
        return done;
    }

    public void playerInfo(){
        JLabel label=new JLabel(nameA);
        label.setFont(new Font("Snap ITC", Font.BOLD, 20));
        JOptionPane.showConfirmDialog(null,label,"Player's Info",JOptionPane.YES_OPTION);
    }

    public int setNumOfRoundsA(){
        return (numberOfRoundsA++);
    }

    public void setNumOfRoundsB(){
        numberOfRoundsB++;
    }

}
