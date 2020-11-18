import java.util.Scanner;

public class Betting {

    SelectQuestions questions;
    DisplayQuestions d;

    public void Betting(){
        questions=new SelectQuestions();
        questions.fillTable();
        d=new DisplayQuestions();
    }

    public void betPoints(Players player, int bet){
        player.setScore(player.getScore() - bet);
    }

    public void displayQuestions(Players player){
        Scanner input=new Scanner(System.in);
        String answer;
        boolean checkAnswer=false;
        int bet=0;

        for(int i=0;i<5;i++) {
            d.display();
            System.out.print("Your bet: ");
            bet=input.nextInt();
            if(bet==250 || bet==500 || bet==750 || bet==1000) {
                answer = input.nextLine();
                checkAnswer = d.isCorrect(answer);
                if (checkAnswer) {
                    System.out.println("You score +" + bet);
                }
                else {
                    betPoints(player,bet);
                    System.out.println("You loose " + bet + "points!");
                }
            }
            else{
                System.out.println("You can bet only 250, 500, 750 or 1000 points!");
            }
        }
    }


}
