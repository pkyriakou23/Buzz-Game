import java.util.Random;

public class Main {

    // Type of question => 0:Right Answer, 1:Betting

    public static void main(String[] args) {

        System.out.println("Hello, let's play Buzz!");

        Players playerA=new Players();
        RightAnswer type1;
        Betting type2;

        int typeOfQuestion=0;

        playerA.setName();
        playerA.setNumOfRounds();

        //while(playerA.getNumOfRounds()<=6) {
            Random r=new Random();
            typeOfQuestion = r.nextInt(2);
            System.out.println("Type of Question(main): "+ typeOfQuestion);
            if (typeOfQuestion == 0) {
                type1 = new RightAnswer();
                type1.displayQuestions(playerA);
            }
            if (typeOfQuestion == 1) {
                type2 = new Betting();
                type2.displayQuestions(playerA);
            }
            playerA.setNumOfRounds();
       // }
    }
}
