import java.util.Scanner;

public class Betting {

    SelectQuestions questions;
    DisplayQuestions d;

    public  Betting(){
        questions=new SelectQuestions();
        d=new DisplayQuestions();
    }

    public void minusScore(Players player, int bet)                        //αφαιρείται απο το σκορ το ποντάρισμα που έθεσε
    {  player.setScore(player.getScore() - bet); }

    public void addScore(Players player,int bet){                          //πρόσθεση πονταρίσματος στο σκορ
        player.setScore(player.getScore() + bet);
    }
    public void displayQuestions(Players player){

        Scanner input=new Scanner(System.in);
        String answer;
        boolean checkAnswer=false;
        int bet=0;
        for(int i=0;i<5;i++)
        {
            d.display();                                                    //εμφάνιση ερώτησης
            System.out.print("Your bet: ");
            bet=input.nextInt();
            while (!(bet==250 || bet==500 || bet==750 || bet==1000))        //έλεγχος για σωστή είσοδο στο ποντάρισμα
            {
                System.out.println("You can bet only 250, 500, 750 or 1000 points!");
                System.out.println("Give bet again: ");
                bet=input.nextInt();
            }


            System.out.print("Your answer : ");
            answer = input.nextLine();
            answer = input.nextLine();
            checkAnswer = d.isCorrect(answer);
            if (checkAnswer) {
                System.out.println("You score +" + bet);
                addScore(player,bet);                           //πρόσθεση σκορ
            }
            else {
                minusScore(player,bet);                         //αφαίρεση σκορ
                System.out.println("You loose " + bet + " points!");
            }

        }
    }


}
