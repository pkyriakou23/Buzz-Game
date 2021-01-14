import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisplayQuestionsTest {

    @Test
    void getRandomI() {
        DisplayQuestions d=new DisplayQuestions();
        ArrayList<Integer> ar=new ArrayList<Integer>();
        ar.add(d.getRandomI());
        ar.add(d.getRandomI());
        ar.add(d.getRandomI());
        ar.add(d.getRandomI());
        ar.add(d.getRandomI());
        ar.add(d.getRandomI());
        System.out.println(ar);
    }

    @Test
    void questions() {
        DisplayQuestions d=new DisplayQuestions();
        assertEquals(d.questions(0),d.questions(1));
        assertEquals(d.questions(2),d.questions(1));
        assertEquals(d.questions(3),d.questions(1));
    }
}