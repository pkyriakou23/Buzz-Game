import java.util.Scanner;

/**
 * Τύπος γύρου: Ποντάρισμα
 *
 * Κλάση που αναπαριστά έναν από τους τύπους γύρων του παιχνιδιού, το Ποντάρισμα.
 * Ο παίχτης έχει την δυνατότητα να ποντάρει 250, 500, 750 ή 1000 πόντους.
 * Εάν απαντήσει σωστά στην ερώτηση που του γίνεται κερδίζει τους πόντους που πόνταρε, σλλιώς τους χάνει.
 */

public class Betting {

    SelectQuestions questions;

    /**
     * Κατασκευαστής / Constructor
     */
    public  Betting()
    {
        questions=new SelectQuestions();
    }

    /**
     * Αφαίρεση πόντων από το σκορ του παίχτη, σε περίπτωση που απάντησε λανθασμένα την ερώτηση.
     * @param player ο παίχτης που διαγωνίζεται
     * @param bet το ποσό που πόνταρε ο παίχτης
     */
    public void minusScore(Players player, int bet)
    {
        player.setScore(player.getScore() - bet);
    }

    /**
     * Προσθήκη πόντων στο σκορ του παίχτη, σε περίπτωση που απάντησε σωστά στην ερώτηση.
     * @param player ο παίχτης που διαγωνίζεται
     * @param bet το ποσό που πόνταρε ο παίχτης
     */
    public void addScore(Players player,int bet){                          //πρόσθεση πονταρίσματος στο σκορ
        player.setScore(player.getScore() + bet);
    }

    public void displayBetting(DisplayQuestions d, Players p )
    {
        int bet = 0;
        String answer;
        boolean checkAnswer = false;

        Scanner input = new Scanner(System.in);
        Scanner inBet = new Scanner(System.in);

        System.out.printf("%n" + "Category: " + d.questionsCategory(d.getNumberOfCurrentQuestion()) + "%n" + "%n");
        System.out.printf("Bet 250, 500, 750 or 1000 points!" + "%n" + "Your bet: ");
        bet = inBet.nextInt();

        while (!(bet == 250 || bet == 500 || bet == 750 || bet == 1000))        //έλεγχος για σωστή είσοδο στο ποντάρισμα
        {
            System.out.println("You can bet only 250, 500, 750 or 1000 points!");
            System.out.print("Give bet again: ");
            bet = inBet.nextInt();
        }

      //  d.display(1);
        System.out.print("Your answer : ");
        answer = input.nextLine();
        checkAnswer = d.isCorrect(answer);

        if (checkAnswer)
        {
            System.out.println("You score +" + bet);
            addScore(p, bet);
        }
        else
        {
            minusScore(p, bet);                         //αφαίρεση σκορ
            System.out.println("You loose " + bet + " points!");
        }

    }

}
