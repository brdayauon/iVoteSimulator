import java.util.ArrayList;

public class Question {
    private  String question;
    private final ArrayList<Answer> answerArrayList;

    public Question(){
        question = "";
        answerArrayList = new ArrayList<>();
    }

    public Question(ArrayList<Answer> answerArrayList, String question){
        this.answerArrayList = answerArrayList;

        this.question = question;
    }

    public ArrayList<Answer> answerArrayList() {
        return answerArrayList;
    }

    public String question(){
        return question;
    }

    public void setAnswers(ArrayList<Answer> answerArrayList){
        for (Answer answer : answerArrayList) {
            this.answerArrayList.add(answer);
        }
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public void displayAnswerChoices(){
        for (Answer answer : answerArrayList) {
            answer.displayAnswers();
        }
    }

    @Override
    public String toString(){
        return this.question;
    }


}
