import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class DisplayQuestions {
    SelectQuestions a;
    int numQ;
    ArrayList<Integer> opRan;
    int i, j;

    public DisplayQuestions()
    {
        a = new SelectQuestions();
        a.fillTable();
        numQ = a.getNumberOfQuestions();
        opRan = new ArrayList<>();
    }
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

    public boolean isCorrect(String ans)
    {
        return (ans.equals(a.getAnswers(i)));
    }

    public int getNumberOfCurrentQuestion(){
        return i;
    }
}
