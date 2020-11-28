/**
 * Εργασία Αντικειμενοστρεφή Προγραμματισμού 2020
 * 3ο Εξάμηνο
 *
 * Σχεδιασμός και υλοποίηση ενός παιχνιδιού ερωτήσεων, βασισμένο στο βραβευμένο παιχνίδι του PlayStation "Buzz! Quiz World".
 *
 * 1ο Μέρος Ανάπτυξης Εργασίας:
 * Περιλαμβάνει μία πρώτη ελάχιστη έκδοση του λογισμικού που σχεδιάζουμε, η οποία αποτελείται από
 * command line interface, αφορά μόνο ατομικό παιχνίδι, περιέχει ερωτήσεις χωρίς εικόνα,
 * μόνο δύο τύπους γύρων (σωστή απάντηση και ποντάρισμα) και δεν θα διατηρεί αρχείο με
 * νίκες και σκορ.
 * Ο αριθμός των ερωτήσεων, καθώς και τα σχετικά δεδομένα τους είναι περιορισμένος.
 * Οι ερωτήσεις είναι αποθηκευμένες σε απλά αρχεία κειμένου .txt, για δική μας ευκολία,
 * και όχι στη μνήμη του υπολογιστή (στον κώδικα του προγράμματος) όπως ζητήθηκε.
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Τύπος Ερωτήσεων (typeOfQuestion) => 0:Right Answer (type1), 1:Betting (type2)

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

        while (playerA.getNumOfRounds() < 4)               //αριθμός γύρων παιχνιδιού: 4
        {
            playerA.setNumOfRounds();
            Random r = new Random();
            typeOfQuestion = r.nextInt(2);      //τυχαιότητα στην επιλογή τύπος γύρου

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
