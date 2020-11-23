import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SelectQuestions {
    private String[][] questions;
    private String[][] options;
    private String[] answers;
    private final int NUMBER_OF_QUESTIONS=20;           //αριθμός ερωτήσεων στο file
    private final int NUMBER_OF_OPTIONS=4;

    public SelectQuestions() {
        questions = new String[NUMBER_OF_QUESTIONS][2];             // ερώτηση και check box
        answers = new String[NUMBER_OF_QUESTIONS];
        options = new String[NUMBER_OF_QUESTIONS][NUMBER_OF_OPTIONS];
    }

    public String getQuestions(int numberOfQuestion)
    {
        return questions[numberOfQuestion][0];
    }

    public String[] getOptions(int numberOfQuestion) {
        String[] options = new String[NUMBER_OF_OPTIONS];
        for (int j = 0; j < NUMBER_OF_OPTIONS; j++)
            options[j] = this.options[numberOfQuestion][j];
        return options;
    }
    public String getAnswers(int numberOfQuestion)
    {
        System.out.println("The correct answer is "+answers[numberOfQuestion]);
        return answers[numberOfQuestion];
    }

    public int getNumberOfQuestions()
    {
        return NUMBER_OF_QUESTIONS;
    }


    public boolean isRepeat(int numberOfQuestion)
    {
        return (questions[numberOfQuestion][1].equals("yes"));

    }

    public void setYes(int numberOfQuestion){
        questions[numberOfQuestion][1]="yes";
    }

    //fill tables with questions,answers and options
    public void fillTable()
    {

        //Τα while παίρνουν μέχρι 5 στοιχεία. ??

        int i=0;
        //fill questions
        try
        {

            File myObj = new File("questions.txt");
            // System.out.println("fill");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                questions[i][0]  = myReader.nextLine();
                questions[i][1]="no";                           //στο πεδίο για αν ρωτήθηκε
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
