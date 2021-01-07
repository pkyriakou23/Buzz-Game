/**
 * Κλάση που είναι υπεύθυνη για την συλλογή των ερωτήσεων - επιλογών - απαντήσεων από το αντίστοιχο αρχείο.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectQuestions {
    private String[][] questions;
    private String[] category;
    private String[][] options;
    private String[] answers;
    private final int NUMBER_OF_QUESTIONS=20;           //αριθμός ερωτήσεων στο file
    private final int NUMBER_OF_OPTIONS=4;

    /**
     * Κατασκευαστής / Constructor
     *
     * Ο πίνακας questions αποθηκεύει στην πρώτη του διάσταση την ερώτηση. Η δεύτερη του διάσταση χρησιμοποιείται βοηθητικά σαν check box,
     * ώστε να γίνεται έλεγχος αν η ερώτηση εμφανίστηκε (yes) ή όχι (no) στον διαγωνιζόμενο, ώστε να αποφεύχθουν επαναλήψεις της ίδιας ερώτησης στο παιχνίδι.
     *
     * Ο πίνακας category αποθηκεύει την κατηγορία στην οποία ανήκει η κάθε ερώτηση. Οι ερωτήσεις που υπάρχουν στο παιχνίδι ανήκουν σε τέσσερις κατηγορίες:
     * 1. Ιστορία, 2. Αθλητικά, 3. Επιστήμη και 4. Κοινωνικά - με αυτή την σειρά.
     *
     * Ο πίνακας options αποθηκεύει τις επιλογές της κάθε ερώτησης.
     * Κάθε ερώτηση έχει τέσσερις (4) επιλογές, από τις οποίες μόνο η μία (1) μπορεί να είναι σωστή.
     *
     * Ο πίνακας answers αποθηκεύει την απάντηση της κάθε ερώτησης.
     *
     * Το πλήθος των ερωτήσεων και των επιλογών έχουν δηλωθεί ως σταθερές.
     * Στο πρώτο μέρος ανάπτυξης της εργασίας θα χρησιμοποιηθούν είκοσι (20) ερωτήσεις, δηλαδή πέντε (5) από κάθε κατηγορία.
     */
    public SelectQuestions() {
        questions = new String[NUMBER_OF_QUESTIONS][2];
        category = new String[NUMBER_OF_QUESTIONS];
        answers = new String[NUMBER_OF_QUESTIONS];
        options = new String[NUMBER_OF_QUESTIONS][NUMBER_OF_OPTIONS];
    }

    /**
     * Επιστρέφει μια ερώτηση με βάση τον αριθμό της.
     * @param numberOfQuestion Ο αριθμός της ζητούμενης/ τρέχουσας ερώτησης.
     * @return Την αντίστοιχη ερώτηση
     */
    public String getQuestions(int numberOfQuestion)
    {
        return questions[numberOfQuestion][0];
    }

    /**
     * Επιστρέφει τις επιλογές μιας ερώτησης.
     * @param numberOfQuestion Ο αριθμός της ζητούμενης/ τρέχουσας ερώτησης.
     * @return Οι επιλογές της ερώτησης
     */
    public String[] getOptions(int numberOfQuestion) {
        String[] options = new String[NUMBER_OF_OPTIONS];
        for (int j = 0; j < NUMBER_OF_OPTIONS; j++)
            options[j] = this.options[numberOfQuestion][j];
        return options;
    }

    /**
     * Εμφανίζει στην οθόνη την σωστή απάντηση μιας ερώτησης και επιστρέφει την απάντησή της.
     * @param numberOfQuestion Ο αριθμός της ζητούμενης/ τρέχουσας ερώτησης.
     * @return Η απάντηση της ερώτησης.
     */
    public String getAnswers(int numberOfQuestion)
    {
       // System.out.println("The correct answer is "+answers[numberOfQuestion]);
        return answers[numberOfQuestion];
    }

    /**
     * @return  Επιστρέφει το πλήθος των ερωτήσεων.
     */
    public int getNumberOfQuestions()
    {
        return NUMBER_OF_QUESTIONS;
    }

    /**
     * Επιστρέφει την κατηγορία μιας ερώτησης
     * @param numberOfQuestion Ο αριθμός της ζητούμενης/ τρέχουσας ερώτησης.
     * @return Η κατηγορία της ερώτησης
     */
    public String getCategory(int numberOfQuestion){return category[numberOfQuestion];}

    /**
     * Ελέγχει το check box, δηλαδή την δεύτερη διάσταση του πίνακα questions, και αν είναι yes-> η ερώτηση επαναλαμβάνεται
     * επιστρέφει true διαφορετικά επιστρέφει false-> no-> η ερώτηση δεν επαναλαμβάνεται.
     * @param numberOfQuestion Ο αριθμός της ζητούμενης/ τρέχουσας ερώτησης.
     * @return true αν η ερώτηση επαναλαμβάνεται ή false αν η ερώτηση δεν επαναλαμβάνεται
     */
    public boolean isRepeat(int numberOfQuestion)
    { return (questions[numberOfQuestion][1].equals("yes")); }

    /**
     * Ορίζει την δεύτερη διάσταση (check box) του πίνακα questions σε yes εαν η ερώτηση χρησιμοποιήθηκε.
     * @param numberOfQuestion Ο αριθμός της ζητούμενης/ τρέχουσας ερώτησης.
     */
    public void setYes(int numberOfQuestion)
    { questions[numberOfQuestion][1]="yes"; }

    /**
     * Γεμίζει τους πίνακες με τις ερωτήσεις, τις επιλογές και τις απαντήσεις παίρνοντας τα κατάλληλα δεδομένα από τα αντίστοιχα αρχεία.
     */
    public void fillTable()
    {
        int i=0;
        int qtyOfQuestionsInEachCategory=NUMBER_OF_QUESTIONS/4;
        int counter=0;
        String categories[]={"History","Athletics","Science","Showbiz"};
        //fill questions
        try
        {

            File myObj = new File("questions.txt");
            // System.out.println("fill");
            Scanner myReader = new Scanner(myObj);
            int j=0;
            while (myReader.hasNextLine())
            {
                questions[i][0]  = myReader.nextLine();
                questions[i][1]="no";                       //στο πεδίο για αν ρωτήθηκε
                counter++;
                category[i]=categories[j];
                if(counter==qtyOfQuestionsInEachCategory){
                    counter=0;
                    j++;
                }
                i++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        //fill answers
        i=0;
        try
        {
            File myObj = new File("answers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                answers[i] = myReader.nextLine();
                i++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //fill options
        i=0;
        int j=0;
        try
        {
            File myObj = new File("options.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                options[i][j] = myReader.nextLine();
                j++;
                if(j==NUMBER_OF_OPTIONS)                                //για να αλλάζει γραμμή όταν πέρει τις 4 επιλογές
                {
                    j=0;
                    i++;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
