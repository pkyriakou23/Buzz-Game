import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class DisplayQuestions {
    SelectQuestions a=new SelectQuestions();
    int numQ=a.getNumberOfQuestions();
    HashSet<Integer> opRan=new HashSet<Integer>();
    int i,j;

    public void display()
    {
        // a.fillTable();
        Random r=new Random();
        String[] opt=new String[4];

        do {
            i=r.nextInt(numQ);
        }
        while (a.isRepeat(i));

        a.setYes(i);

        System.out.println(a.getQuestions(i));

        opt=a.getOptions(i);

        do{
            j=r.nextInt(4);
            opRan.add(j);
        }
        while (opRan.size()==4);
        int a=97;                   //ASCII
        String ch="";
        Iterator<Integer> z=opRan.iterator();
        while(z.hasNext()) {
            ch=Character.toString((char)a);
            System.out.print(ch+'.'+opt[z.next()]+"   ");
            a++;
        }

        // System.out.println("a." + opt[z.next()] + "  b." + opt[z.next()] + "  c." + opt[z.next()] + "  d." + opt[z.next()]);
    }

    public boolean isCorrect(String ans)
    {
        return (ans.equals(a.getAnswers(i)));
    }

    public int getNumberOfCurrentQuestion(){
        return i;
    }
}
