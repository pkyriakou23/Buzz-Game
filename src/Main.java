import java.util.Random;
import java.util.Scanner;

public class Main {

    // Type of question => 0:Right Answer, 1:Betting

    public static void main(String[] args) {
        System.out.println("Hello, let's play Buzz!");
        Players playerA = new Players();
        RightAnswer type1;
        Betting type2;
        DisplayQuestions d = new DisplayQuestions();

        int bet = 0;
        int typeOfQuestion;
        type1 = new RightAnswer();
        type2 = new Betting();
        playerA.setName();

        while (playerA.getNumOfRounds() < 4)               //αριθμός γύρων παιχνιδιού
        {
            playerA.setNumOfRounds();
            Random r = new Random();
            typeOfQuestion = r.nextInt(2);      //τυχαιότητα στην επιλογή είδος παιχνιδιού

            Scanner input = new Scanner(System.in);
            Scanner inBet = new Scanner(System.in);
            String answer;
            boolean checkAnswer = false;

            for (int i = 0; i < 5; i++) {
                d.display();

                if (typeOfQuestion == 1) {
                    System.out.print("Your bet: ");
                    bet = inBet.nextInt();
                    while (!(bet == 250 || bet == 500 || bet == 750 || bet == 1000))        //έλεγχος για σωστή είσοδο στο ποντάρισμα
                    {
                        System.out.println("You can bet only 250, 500, 750 or 1000 points!");
                        System.out.println("Give bet again: ");
                        bet = inBet.nextInt();
                    }
                }

                System.out.print("Your answer : ");
                answer = input.nextLine();
                checkAnswer = d.isCorrect(answer);

                if (checkAnswer) {

                    if (typeOfQuestion == 0) {
                        System.out.println("You score +1000");
                        type1.addScore(playerA);                        //πρόσθεση σκορ
                    } else {
                        System.out.println("You score +" + bet);
                        type2.addScore(playerA, bet);
                    }
                } else {
                    if (typeOfQuestion == 1) {
                        type2.minusScore(playerA, bet);                         //αφαίρεση σκορ
                        System.out.println("You loose " + bet + " points!");
                    }

                }
            }
        }
        System.out.println("Your final score is: " + playerA.getScore());
    }
}
