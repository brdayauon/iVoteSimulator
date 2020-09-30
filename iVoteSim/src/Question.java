import java.util.ArrayList;

public class Question {
    private final String question;
    private final ArrayList<Answer> answerArrayList;

    public Question(ArrayList<Answer> answerArrayList, String question){
        this.answerArrayList = answerArrayList;
        this.question = question;
    }

    public ArrayList<Answer> answerArrayList() {
        return answerArrayList;
    }

//    public void displayAnswerChoices(){
//        for (Answer answer : answerArrayList) {
//            answer.displayAnswers();
//        }
//    }

    @Override
    public String toString(){
        return this.question;
    }


}
