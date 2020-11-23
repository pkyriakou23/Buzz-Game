import java.util.Scanner;

public class RightAnswer {

    // Οι ερωτήσεις ενός γύρου
    SelectQuestions questions;
    DisplayQuestions d;

    public RightAnswer(){
        questions=new SelectQuestions();
        d=new DisplayQuestions();
    }

    public void addScore(Players player)
    { player.setScore(player.getScore() + 1000); }           //πρόσθεση 1000 πόντων για σωστή απάντηση

    public void displayQuestions(Players player){
        Scanner input=new Scanner(System.in);
        String answer;
        boolean checkAnswer=false;

        for(int i=0;i<5;i++) {
            d.display();
            System.out.print("Your answer : ");
            answer = input.nextLine();
            checkAnswer = d.isCorrect(answer);
            if (checkAnswer) {
                System.out.println("You score +1000");
                addScore(player);                                //πρόσθεση σκορ
            }
        }
    }

}
