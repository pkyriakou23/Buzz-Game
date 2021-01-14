import java.io.*;
import java.util.Scanner;

/**
 * Κλάση η οποία χρησιμοποιείται για την αποθήκευση τριών αρχείων τα οποία αντιστοιχούν
 * στις νίκες κάθε παίχτη στο παιχνίδι 2 παιχτών και στα ονόματα των παικτών αυτών, και τέλος
 * στο υψηλότερο του σκορ στο ατομικό παιχνίδι. Τα τρία αυτά αρχεία έχουν τα ονόματα Wins.txt,
 * PlayersNames.txt και HighScore, αντίστοιχα.
 */

public class ScoreFile {

    private int currentHighScore;
    private int lineA;
    private int lineB;
    private int winA;
    private int winB;

    /**
     * Κατασκευαστής/ Constructor
     * Αρχικοποιείται το υψηλότερο σκορ μέσω του αρχείου HighScore.txt,
     * καθώς και οι υπόλοιπες μεταβλητές. Οι μεταβλητές lineA και lineB χρησιμοποιούνται
     * για αποθήκευση της θέσης των παικτών και οι μεταβλητές winA και winB για αποθήκευση
     * των ήδη υπάρχοντων νικών των παικτών, στην περίπτωση που το παιχνίδι είναι ανταγωνιστικό,
     * στα παράλληλα αρχεία Wins.txt και PlayerNames.txt.
     */

    public ScoreFile(){
        try {
            File myObj = new File("HighScore.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            currentHighScore = Integer.parseInt(data);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        lineA=0;
        lineB=0;

        winA=0;
        winB=0;
    }

    /**
     * Συνάρτηση η οποία συγκρίνει το σκορ που συγκέντρωσε κάποιος παίκτης σε ένα παιχνίδι
     * με το ήδη υπάρχων υψηλότερο σκορ και αν είναι μεγαλύτερο από αυτό το αποθηκεύει στο
     * αρχείο με όνομα HighScore.txt.
     *
     * @param scoreOfGame Το σκορ που συγκέντρωσε ο παίκτης στο τρέχον παιχνίδι.
     * @throws IOException
     */
    public void setHighScore(int scoreOfGame) throws IOException {
        try {
            if(scoreOfGame>currentHighScore){
                currentHighScore=scoreOfGame;
                FileWriter myObj = new FileWriter("HighScore.txt");
                myObj.write(String.valueOf(currentHighScore));
                myObj.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Συνάρτηση η οποία επιστρέφει το υψηλότερο μέχρι στιγμής σκορ που συγκεντρώθηκε στο παιχνίδι από έναν παίκτη.
     * @return Το υψηλότερο σκορ
     */
    public int getHighScore(){
        return currentHighScore;
    }

    /**
     * Συνάρτηση η οποία δέχεται ως παράμετρους τα ονόματα των δύο παικτών που ανταγωνίζονται και
     * αναζητά για αυτά στο αρχείο PlayersNames.txt. Εαν τα ονόματα των παικτών υπάρχουν σημαίνει πως οι
     * παίκτες αυτοί έχουν διαγωνιστεί ξανά και οι νίκες που ενδεχομένως θα κάνουν αποθηκεύονται στην αντίστοιχη
     * θέση στο αρχείο Wins.txt. Διαφορετικά, το όνομα του νέου παίκτη προστίθεται στο τέλος του αρχείου PlayersNames.txt.
     * Η θέση των δύο παικτών στα δύο παράλληλα αρχεία αποθηκεύεται στις μεταβλητές
     * lineA και lineB, για τον 1ο και τον 2ο παίκτη αντίστοιχα.
     * @param nameA το όνομα που δίνεται από τον πρώτο παίκτη
     * @param nameB το όνομα που καταχωρεί ο δεύτερος παίκτης
     */
    public void findPlayers(String nameA,String nameB){
        try {
            File myObj = new File("PlayersNames.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int counter=1;
            boolean foundA=false;
            boolean foundB=false;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if(data.equals(nameA)){
                    lineA=counter;
                    foundA=true;
                }
                if(data.equals(nameB)){
                    lineB=counter;
                    foundB=true;
                }
                counter++;
            }
            if(!foundA){
                writeNameOfPlayer(nameA);
            }
            if(!foundB){
                writeNameOfPlayer(nameB);
            }
            myReader.close();
            setWins();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Συμπληρωματική συνάρτηση της προηγούμενης, η οποία χρησιμοποιείται για να γράψει το όνομα
     * του νεόυ παίκτη στο αρχείο PlayersNames.txt
     * @param name το όνομα του παίκτη που δεν υπάρχει ήδη στο αρχείο
     * @throws IOException
     */
    public void writeNameOfPlayer(String name) throws IOException {
        FileWriter out=new FileWriter("PlayersNames.txt",true);
        out.write(System.lineSeparator() + name);
        out.close();

        FileWriter outW=new FileWriter("Wins.txt",true);
        outW.write(System.lineSeparator() + "0");
        outW.close();
    }

    /**
     * Συνάρτηση που δέχεται ως παραμέτρους δύο boolean μεταβλητές που καθορίζουν ποιος παίκτης νίκησε στο παιχνίδι.
     * Με την βοήθειά της προστήθεται στον κατάλληλο παίκτη η νίκη που έκανε.
     * @param winOfPlayerA παίρνει την τιμή true αν έχει νικήσει ο πρώτος παίκτης, διαφορετικά έχει την τιμή false
     * @param winOfPlayerB παίρνει την τιμή true αν έχει νικήσει ο δεύτερος παίκτης, διαφορετικά έχει την τιμή false
     */
    public void addWin(boolean winOfPlayerA,boolean winOfPlayerB){
        if(winOfPlayerA) {
            winA++;
        }else if(winOfPlayerB) {
            winB++;
        }else if(winOfPlayerA && winOfPlayerB){
            winA++;
            winB++;
        }
    }

    /**
     * Συνάρτηση που καθορίζει τις ήδη υπάρχουσες νίκες καθένα από τους δύο παίκτες,
     * ώστε να μπορεί να προστεθεί στην πορεία σε αυτή η πιθανή νίκη του παίκτη.
     */
    public void setWins(){
        try {
            File myObj = new File("Wins.txt");
            Scanner myReader = new Scanner(myObj);
            String data = null;
            int counter=1;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if(counter==lineA){
                    winA=Integer.parseInt(data);
                }
                if(counter==lineB){
                    winB=Integer.parseInt(data);
                }
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Συνάρτηση η οποία καταγράφει στο αρχείο Wins.txt την νίκη του παίκτη που κέρδισε στο παιχνίδι.
     * Αυτή η συνάρτηση αρχικά αντιγράφει τα περιεχόμενα του αρχείου Wins.txt σε μια προσωρινή μεταβλητή
     * και έπειτα αφού προσθέσει την νίκη που έγινε στην αντίστοιχη θέση στο αρχείο ξαναγράφει σε αυτό
     * όλα τα δεδομένα.
     */
    public void writeWins() {
        try {
            BufferedReader filename = new BufferedReader(new FileReader("Wins.txt"));
            StringBuffer in = new StringBuffer();
            String data;
            int counter=1;
            String targetA = null,targetB=null;

            while ((data = filename.readLine()) != null) {
                in.append(data);
                in.append('\n');
                if(counter==lineA){
                    targetA=data;
                }
                if(counter==lineB){
                    targetB=data;
                }
                counter++;
            }
            filename.close();
            String str = in.toString();

            str = str.replace(targetA, String.valueOf(winA));
            str = str.replace(targetB, String.valueOf(winB));

            FileOutputStream out = new FileOutputStream("Wins.txt");
            out.write(str.getBytes());
            out.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }

    /**
     * Συνάρτηση η οποία παίρνει τα ονόματα των παικτών από το αρχείο PlayersNames.txt
     * και τις επιστρέφει όπου είναι απαραίτητο. Χρησιμοποιείται για να εμφανίσει τα ονόματα
     * των παικτών στο ανταγωνιστικό παιχνίδι στο αρχικό μενού του παιχνιδιού στο κουμπί SCORE.
     * @return τα ονόματα των παικτών
     * @throws IOException
     */
    public String getNames() throws IOException {
        BufferedReader filename = new BufferedReader(new FileReader("PlayersNames.txt"));
        StringBuffer in = new StringBuffer();
        String data,str="";

        while ((data = filename.readLine()) != null) {
            str+=data;
            str+="              ";
        }
        filename.close();
        return str;
    }

    /**
     * Συνάρτηση η οποία παίρνει τις νίκες των παικτών από το αρχείο Wins.txt
     * και τις επιστρέφει όπου είναι απαραίτητο. Χρησιμοποιείται για να εμφανίσει τις νίκες
     * των παικτών στο ανταγωνιστικό παιχνίδι στο αρχικό μενού του παιχνιδιού στο κουμπί SCORE.
     * @return οι νίκες των παικτών
     * @throws IOException
     */
    public String getWins() throws IOException {
        BufferedReader filename = new BufferedReader(new FileReader("Wins.txt"));
        StringBuffer in = new StringBuffer();
        String data,str="";

        while ((data = filename.readLine()) != null) {
            str+=data;
            str+="              ";
        }
        filename.close();
        return str;
    }


}
