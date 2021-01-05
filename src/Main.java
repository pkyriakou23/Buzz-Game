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
 *
 * @author PANAYIOTIS KYRIACOU
 * @author ALEXANDRA PROUNTZOU
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Τύπος Ερωτήσεων (typeOfQuestion) => 0:Right Answer (type1), 1:Betting (type2)

    public static void main(String[] args) {
        System.out.printf("Hello, let's play Buzz!" + "%n" + "Please enter full answers." + "%n");
        Players playerA = new Players();
        RightAnswer type1;
        Betting type2;
        DisplayQuestions d = new DisplayQuestions();


        int typeOfQuestion;
        type1 = new RightAnswer();
        type2 = new Betting();
        playerA.setName();

        while (playerA.getNumOfRounds() < 4)               //αριθμός γύρων παιχνιδιού: 4
        {
            playerA.setNumOfRounds();
            Random r = new Random();
            typeOfQuestion = r.nextInt(2);      //τυχαιότητα στην επιλογή τύπος γύρου


            for (int i = 0; i < 5; i++) {

                if (typeOfQuestion == 1)
                    type2.displayBetting(d,playerA);
                if (typeOfQuestion == 0)
                    type1.displayRightAnswer(d,playerA);
            }
        }
        System.out.println("Your final score is: " + playerA.getScore());
        System.out.println("GOOD GAME BYE BYE");
    }



}
