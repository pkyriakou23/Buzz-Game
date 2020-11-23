import java.util.Random;

public class Main {

    // Type of question => 0:Right Answer, 1:Betting

    public static void main(String[] args) {
        System.out.println("Hello, let's play Buzz!");
        Players playerA=new Players();
        RightAnswer type1;
        Betting type2;
        // SelectQuestions a=new SelectQuestions();
        int typeOfQuestion;

        playerA.setName();

        while(playerA.getNumOfRounds()<4)               //αριθμός γυρων παιχνιδιού
        {
            playerA.setNumOfRounds();
            Random r=new Random();
            typeOfQuestion = r.nextInt(2);         //τυχαιότητα στην επιλογή είδος παιχνιδιού
            if (typeOfQuestion == 0) {
                type1 = new RightAnswer();
                type1.displayQuestions(playerA);
            }
            if (typeOfQuestion == 1) {
                type2 = new Betting();
                type2.displayQuestions(playerA);
            }

        }
    }
}
