import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class BuzzQuizWorld {
        private JFrame frame;
        private JLabel label;
    private JLabel label2;
        private JButton ans1;
        private JButton ans2;
        private JButton ans3;
        private JButton ans4;
        private JPanel ansbox;
    boolean flag;

        String answer;

        public BuzzQuizWorld()
        {
            frame=new JFrame("Question");
            label=new JLabel();
            label2=new JLabel();
            frame.setSize(400,100);
            ans1=new JButton();
            ans2=new JButton();
            ans3=new JButton();
            ans4=new JButton();
            ansbox=new JPanel();
        }
        public void game(DisplayQuestions d)  {

            System.out.println("in game");
                String[] options = new String[4];

                flag=false;

                frame.setResizable(true);
                label.setText(d.questions(0));
            //    label.setVisible(true);
              //  label2.setVisible(true);
                label.setAlignmentX(FlowLayout.RIGHT);
                label2.setAlignmentX(FlowLayout.CENTER);
                frame.add(label, BorderLayout.PAGE_START);
                frame.add(label2, BorderLayout.CENTER);
                options = d.options();
                for (int i = 0; i < 4; i++)
                    if (d.isCorrect(options[i]))
                        answer = options[i];
                ans1.setText(options[0]);
                ans2.setText(options[1]);
                ans3.setText(options[2]);
                ans4.setText(options[3]);


                ansbox.setLayout(new GridLayout(1, 4));
                ansbox.add(ans1);
                ansbox.add(ans2);
                ansbox.add(ans3);
                ansbox.add(ans4);

                frame.add(ansbox, BorderLayout.PAGE_END);



                ans1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        correctAnswer(); flag=true;
                        if (ans1.getText().equals(answer))
                            label2.setText("You score +1000");
                    }
                });
                ans2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        correctAnswer();
                        if (ans2.getText().equals(answer))
                            label2.setText("You score +1000");
                    }
                });
                ans3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        correctAnswer();
                        if (ans3.getText().equals(answer))
                            label2.setText("You score +1000");

                    }
                });
                ans4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        correctAnswer();
                        if (ans4.getText().equals(answer))
                            label2.setText("You score +1000");
                    }
                });

                frame.setVisible(true);


                return;
            }



        public void correctAnswer()  {
            label.setText("Correct answer is "+answer);
            label.setVisible(true);
        }

    }


