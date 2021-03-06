/**
 * Κλάση που βοηθά στην εμφάνιση των ερωτήσεων - επιλογών - απαντήσεων στην οθόνη.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class DisplayQuestions {
    SelectQuestions a;
    PhotoFrame photo;
    int numQ;
    ArrayList<Integer> opRan;
    int i, j;

    /**
     * Κατασκευαστής / Constructor
     */
    public DisplayQuestions()
    {
        photo=new PhotoFrame();
        a = new SelectQuestions();
        a.fillTable();
        numQ = a.getNumberOfQuestions();
        opRan = new ArrayList<>();
    }

    /**
     * Τυχαία επιλογή αριθμού ερώτησης i, η οποία θα ερωτηθεί στον διαγωνιζόμενο.
     */
    public int getRandomI(){
        Random r=new Random();
        do {
            i=r.nextInt(numQ);
        }
        while (a.isRepeat(i));              //έλεγχος για μη επανάληψη ερωτήσεων


        return i;
    }

    /**
     * Συνάρτηση για την εμφάνιση μίας ερώτησης στην οθόνη του υπολογιστή.
     * Η ερώτηση επιλέγεται τυχαία ανάμεσα σε ένα πλήθος ερωτήσεων.
     *
     */
    public String questions(int typeOfQuestion) {
        //έλεγχος για μη επανάληψη ερωτήσεων
        if (typeOfQuestion != 1) {
            i = getRandomI();
        }

        // yes το πεδίο στον πίνακα με τις ερωτήσεις για να ξέρει το σύστημα οτι ρωτήθηκε
        a.setYes(i);
        if(i>40&&i<80)
            photo.showImage(i-40);
        else
            photo.hideImage();
        return a.getQuestions(i);
    }

    /**
     * Επιλέγει τις πιθανές απαντήσεις κάθε ερώτησεις και τις αποθηκεύει σε έναν πίνακα opt.
     * Επιστρέφει τον πίνακα που δημιουργεί ώστε να παρέχονται οι πιθανές απαντήσεις όπου χρειάζεται.
     * @return πίνακας με πιθανές απαντήσεις της τρέχουσας ερώτησης
     */
    public String[] options()
    {
        Random r = new Random();
        String[] opt = new String[4];
        opt=a.getOptions(i);
        do{                                             //τυχαιότητα στην εμφάνιση επιλογών
            j=r.nextInt(4);
            if(!opRan.contains(j))
                opRan.add(j);                           //arraylist για να πάρω μια φορά τους αριθμούς 0,1,2,3
        }
        while (opRan.size()<4);

        String[] temp=new String[4];
        for(int a=0;a<4;a++)
            temp[a]=opt[opRan.get(a)];
        return temp;

    }

    /**
     * Έλεγχος αν η απάντηση που δόθηκε από τον διαγωνιζόμενο είναι σωστή.
     * @param ans η απάντηση του διαγωνιζόμενου δείνετε ως παράμετρος
     * @return Επιστρέφει true αν η απάντηση που δόθηκε είναι σωστή, ενώ αν είναι λανθασμένη επιστρέφει false.
     */
    public boolean isCorrect(String ans)
    {
        return (ans.equals(a.getAnswers(i)));
    }



    /**
     * Επιστρέφει την κατηγορία της ερώτησης με αριθμό numberOfQuestion.
     * Χρησιμοποιείται κυρίως στον τύπο γύρου ποντάρισμα σαν αρχική πληροφορία στην οποία θα βασιστεί ο παίχτης
     * για να ποντάρει το ποσό που επιθυμεί.
     * @param numberOfQuestion ο αριθμός της ερώτησης
     * @return την κατηγορία της ερώτησης με τον παραπάνω αριθμό
     */
    public String questionsCategory(int numberOfQuestion){
        return a.getCategory(numberOfQuestion);
    }
}
