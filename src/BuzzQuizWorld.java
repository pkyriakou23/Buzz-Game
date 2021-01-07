import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuzzQuizWorld {
        private JFrame frame;
        private JLabel label;
        private JButton ans1;
        private JButton ans2;
        private JPanel ansbox;

        public BuzzQuizWorld()
        {
            frame=new JFrame("Question");
            label=new JLabel();
            frame.setSize(400,100);
            ans1=new JButton();
            ans2=new JButton();
            ansbox=new JPanel();
        }
        private void game()
        {
            label.setText("poios einai o kaliteros");
            label.setAlignmentX(FlowLayout.RIGHT);
            frame.add(label,BorderLayout.PAGE_START);
            ans1.setText("ans1");
            ans2.setText("ans2");
            ans1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    System.out.println(ans1.getText());
                }
            } );


            ansbox.setLayout(new GridLayout(1,2));
            ansbox.add(ans1);
            ansbox.add(ans2);
            frame.add(ansbox,BorderLayout.PAGE_END);

            frame.setVisible(true);
        }


    }


