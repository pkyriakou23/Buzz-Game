import java.util.Scanner;

public class RightAnswer {

    // Οι ερωτήσεις ενός γύρου
    SelectQuestions questions;


    public RightAnswer(){
        questions=new SelectQuestions();

    }

    public void addScore(Players player)
    { player.setScore(player.getScore() + 1000); }           //πρόσθεση 1000 πόντων για σωστή απάντηση

}
