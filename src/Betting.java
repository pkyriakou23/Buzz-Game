import java.util.Scanner;

public class Betting {

    SelectQuestions questions;


    public  Betting(){
        questions=new SelectQuestions();

    }

    public void minusScore(Players player, int bet)                        //αφαιρείται απο το σκορ το ποντάρισμα που έθεσε
    {  player.setScore(player.getScore() - bet); }

    public void addScore(Players player,int bet){                          //πρόσθεση πονταρίσματος στο σκορ
        player.setScore(player.getScore() + bet);
    }

}
