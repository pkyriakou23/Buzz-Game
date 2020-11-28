/**
 * Τύπος γύρου: Σωστή Απάντηση
 *
 * Κλάση που αναπαριστά έναν από τους τύπους γύρων του παιχνιδιού, την Σωστή Απάντηση.
 * Κάθε παίχτης που απαντάει σωστά κερδίζει 1000 πόντους.
 */

public class RightAnswer {

    SelectQuestions questions;

    /**
     * Κατασκευαστής κλάσης RightAnswer: Καθορίζει τις ερωτήσεις ενός γύρου
     */
    public RightAnswer()
    {
        questions=new SelectQuestions();
    }

    /**
     *Προσθήκη 1000 πόντων για σωστή απάντηση.
     * @param player ο παίχτης που διαγωνίζεται
     */
    public void addScore(Players player)
    {
        player.setScore(player.getScore() + 1000);
    }

}
