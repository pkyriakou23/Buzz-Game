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
                UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 20));
                nameA = JOptionPane.showInputDialog(null,"ΔΩΣΕ ΤΟ ΟΝΟΜΑ ΣΟΥ: ");
                if(nameA!=null) {
                    JOptionPane.showMessageDialog(null, "ΠΑΙΚΤΗΣ1: " + nameA);
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

                mainScreen.setVisible(false);
            }
        });

        playersChoice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solo=false;
                UIManager.put("OptionPane.messageFont", new Font("Century Gothic", Font.PLAIN, 20));
                nameA = JOptionPane.showInputDialog("ΔΩΣΕ ΤΟ ΟΝΟΜΑ: ");
                if(nameA!=null)
                    JOptionPane.showMessageDialog(null, "ΠΑΙΚΤΗΣ1: " + nameA);
                else if(nameA==null){
                    JOptionPane.showMessageDialog(null,"Error! ΔΕΝ ΕΔΩΣΕΣ ΟΝΟΜΑ!");
                }

                nameB = JOptionPane.showInputDialog("ΔΩΣΕ ΟΝΟΜΑ: ");
                if(nameB!=null)
                    JOptionPane.showMessageDialog(null, "ΠΑΙΚΤΗΣ1: " + nameB);
                else if(nameB==null)
                    JOptionPane.showMessageDialog(null,"Error! ΔΕΝ ΕΔΩΣΕΣ ΟΝΟΜΑ!");

                if(nameA!=null && nameB!=null) {
                    playersFrame.setVisible(false);
                    done=true;
                }
            }
        });

        playerPanel.setLayout(new GridLayout(2,1));

        playersChoice1.setText("1 ΠΑΙΚΤΗΣ");
        playersChoice1.setFont(new Font("Century Gothic",Font.PLAIN,45));
        playerPanel.add(playersChoice1);
        playersChoice2.setText("2 ΠΑΙΚΤΗΣ");
        playersChoice2.setFont(new Font("Century Gothic",Font.PLAIN,45));
        playerPanel.add(playersChoice2);
        playersFrame.setTitle("ΟΘΟΝΗ ΠΑΙΚΤΗ");
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
        label.setFont(new Font("Century Gothic", Font.BOLD, 20));
        JOptionPane.showConfirmDialog(null,label,"ΠΛΗΡΟΦΟΡΙΕΣ",JOptionPane.YES_OPTION);
    }

    public int setNumOfRoundsA(){
        return (numberOfRoundsA++);
    }

    public void setNumOfRoundsB(){
        numberOfRoundsB++;
    }

}
