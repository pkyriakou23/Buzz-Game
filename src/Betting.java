import javax.swing.*;

/**
 * Τύπος γύρου: Ποντάρισμα
 *
 * Κλάση που αναπαριστά έναν από τους τύπους γύρων του παιχνιδιού, το Ποντάρισμα.
 * Ο παίχτης έχει την δυνατότητα να ποντάρει 250, 500, 750 ή 1000 πόντους.
 * Εάν απαντήσει σωστά στην ερώτηση που του γίνεται κερδίζει τους πόντους που πόνταρε, σλλιώς τους χάνει.
 * Καλεί τα γραφικά να εμφανιστούν

 */


public class Betting {
    private BettingGui questions;
    public  Betting()
    {
        questions=new BettingGui();
    }
    public void showBetting(DisplayQuestions d,JFrame menuFrame,int scoreA, int scoreB,boolean solo,boolean[] rounds) throws InterruptedException {
        questions.QuestionsWindow(d,menuFrame,scoreA,scoreB,solo,rounds);
        questions.game(d);

}
}