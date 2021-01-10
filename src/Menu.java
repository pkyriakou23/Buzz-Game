import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JFrame menu;
    private JButton infoButton;
    private JPanel buttonsPanel;
    private MenuButtons buttons;
    private JButton play;
    private RightAnswerGui question;
    private JLabel title;
    private JButton exit;
    private PlayersGUI p;

    public Menu(){
        menu=new JFrame();
        infoButton=new JButton();
        buttonsPanel=new JPanel();
        buttons=new MenuButtons();
        play=new JButton();
        question=new RightAnswerGui();
        title=new JLabel();
        exit=new JButton();
        p=new PlayersGUI();
    }

    public void createMenuScreen(){
        menu.setTitle("Buzz Quiz World Game");
        menu.setLocationRelativeTo(null);
        /*Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d=t.getScreenSize();
        int x=(d.width-menu.getWidth())/2;
        int y=(d.height-menu.getHeight())/2;
        menu.setLocation(x,y);*/
        menu.setSize(800,300);
        menu.setResizable(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        title.setText("BUZZ QUIZ WORLD GAME");
        //title.setBounds(50, 50, 100, 30);
        title.setFont(new Font("Snap ITC", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        buttonsPanel.add(title);

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.showInfo();
            }
        });
        infoButton.setText("INFO");
        infoButton.setSize(10,5);
        infoButton.setFont(new Font("Snap ITC",Font.PLAIN,45));
        buttonsPanel.add(infoButton);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.choosePlayer(menu);
            }
        });
        play.setText("PLAY");
        play.setFont(new Font("Snap ITC",Font.PLAIN,45));
        play.setSize(10,5);
        buttonsPanel.add(play);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.exitMessage();
            }
        });
        exit.setText("EXIT");
        exit.setFont(new Font("Snap ITC",Font.PLAIN,45));
        buttonsPanel.add(exit);
        buttonsPanel.setLayout(new GridLayout(5,1));

        menu.add(buttonsPanel,BorderLayout.CENTER);

    }

    public void start(){
        menu.setVisible(true);
    }

    public void hideMenu(){
        menu.setVisible(false);
    }

}
