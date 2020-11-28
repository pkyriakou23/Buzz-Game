/**
 * Κλάση που βοηθά στην εμφάνιση των ερωτήσεων - επιλογών - απαντήσεων στην οθόνη.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class DisplayQuestions {
    SelectQuestions a;
    int numQ;
    ArrayList<Integer> opRan;
    int i, j;

    /**
     * Κατασκευαστής DisplayQuestions.
     * Αρχικοποιεί τον πίνακα τον ερωτήσεων, τον αριθμό της τρέχουσας ερώτησης και την δομή opRan.
     */
    public DisplayQuestions()
    {
        a = new SelectQuestions();
        a.fillTable();
        numQ = a.getNumberOfQuestions();
        opRan = new ArrayList<>();
    }

    /**
     * Εμφάνιση ερώτησης στην οθόνη του υπολογιστή.
     * Η λίστα opRan βοηθά στην εμφάνιση της αρίμησης a,b,c,d μπροστά από τις επιλογές της κάθε ερώτησης.
     */
    public void display()
    {
        Random r=new Random();
        String[] opt=new String[4];

        do {
            i=r.nextInt(numQ);
        }
        while (a.isRepeat(i));                          //έλεγχος για μη επανάληψη ερωτήσεων
        System.out.println();
        System.out.println(a.getQuestions(i));

        a.setYes(i);                                    // yes το πεδίο στον πίνακα με τις ερωτήσεις για να ξέρει το σύστημα οτι ρωτήθηκε

        opt=a.getOptions(i);
        do{                                             //τυχαιότητα στην εμφάνιση επιλογών
            j=r.nextInt(4);
            if(!opRan.contains(j))
                opRan.add(j);                           //arraylist για να πάρω μια φορά τους αριθμούς 0,1,2,3
        }
        while (opRan.size()<4);

        int a=97;                   //ASCII
        String ch="";
        Iterator<Integer> z=opRan.iterator();
        while(z.hasNext()) {
            ch=Character.toString((char)a);                 //για εμφάνιση μπροστά a,b,c,d
            System.out.print(ch+'.'+opt[z.next()]+"   ");
            a++;
        }
        System.out.println();

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
     * @return Επιστρέφει τον αριθμό της τρέχουσας ερώτησης.
     */
    public int getNumberOfCurrentQuestion(){
        return i;
    }
}
