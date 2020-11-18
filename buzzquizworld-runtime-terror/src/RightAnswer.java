import java.util.Scanner;

public class RightAnswer {

    // Οι ερωτήσεις ενός γύρου
    SelectQuestions questions;
    DisplayQuestions d;

    public void RightAnswer(){
        questions=new SelectQuestions();
        questions.fillTable();
        d=new DisplayQuestions();
    }

    public void addScore(Players player){
        player.setScore(player.getScore() + 1000);
    }

    public void displayQuestions(Players player){
        Scanner input=new Scanner(System.in);
        String answer;
        boolean checkAnswer=false;

        for(int i=0;i<5;i++) {
            d.display();
            answer = input.nextLine();
            checkAnswer = d.isCorrect(answer);
            if (checkAnswer) {
               System.out.println("You score +1000");
                addScore(player);
            }
        }
    }

}
