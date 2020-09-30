public class singleChoiceAnswer extends Answer {

    private String answer;

    public void setAnswer(String answer){
        this.answer = answer;
    }
    public singleChoiceAnswer(String answer){
        this.answer = answer;
    }

    @Override
    public String toString() {
        return  answer;
    }

    @Override
    public void displayAnswers() {
        System.out.println(answer);

    }
}
