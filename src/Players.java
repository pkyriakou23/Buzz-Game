/**
 * Κλάση που αναπαριστά τον παίχτη που διαγωνίζεται.
 */

import java.util.Scanner;

public class Players {
    private String name;
    private int score;
    private int numberOfRounds;

    /**
     * Κατασκευαστής / Constructor
     * Αρχικοποιεί το όνομα του παίχτη, το σκορ του και τον αριθμό των γύρων στους οποίους συμμετείχε.
     */
    public Players(){
        name=null;
        score=0;
        numberOfRounds=0;
    }

    /**
     * Setters για το όνομα του παίχτη.
     * Ζητά από τον διαγωνιζόμενο το όνομα του και το αποθηκεύει στην αντίστοιχη μεταβλητή name.
     */
    public void setName(String name){
        this.name=name;

    }

    /**
     *Setter για το σκορ.
     * @param previousScore Το σκορ του παίχτη μέχρι στιγμής.
     */
    public void setScore(int previousScore){
        this.score=previousScore;
    }

    /**
     * Setter για τον αριθμό των γύρων
     * Αυξάνει τον αριθμό των γύρων στους οποίους έχει διαγωνιστεί ο παίχτης κατά ένα και εμφανίζει στην οθόνη
     * τους πόντους που έχει συγκεντρώσει ο διαγωνιζόμενος, καθώς και τον αριθμό του επόμενου γύρου.
     */
    public void setNumOfRounds(){
        numberOfRounds++;

        System.out.println("\n"+"Your score is: "+score+"\n");              //εμφάνιση σκορ στο τέλος κάθε γύρου
        System.out.println("Round " + numberOfRounds);
    }

    /**
     *Επιστρέφει το όνομα του παίχτη.
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Επιστρέφει το σκορ του παίχτη.
     * @return score
     */
    public int getScore(){
        return score;
    }

    /**
     * Επιστρέφει τον αριθμό των γύρων που έχει παίξει μέχρι στιγμής ο παίχτης.
     * @return numberOfRounds
     */
    public int getNumOfRounds(){
        return numberOfRounds;
    }

    /**
     * Εμφανίζει στην οθόνη το σκορ του παίχτη.
     */
    public void showScore(){
        System.out.println(score);
    }

    /**
     * Εμφανίζει τον αριθμό των γύρων στους οποίους διαγωνίστηκε ο παίχτης.
     */
    public void showRound(){
        System.out.println(numberOfRounds);
    }
}
