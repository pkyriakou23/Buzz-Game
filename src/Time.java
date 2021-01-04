public class Time {
    SelectQuestions questions;

    public Time()
    {
        questions=new SelectQuestions();
    }
    public void addScore(Players player)
    {
        player.setScore(player.getScore() + 1000);
    }

}
