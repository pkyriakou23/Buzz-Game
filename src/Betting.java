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

}
