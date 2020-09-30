public class inputAnswer extends Answer{
    private final String answer;

    public inputAnswer(String answer){
        this.answer = answer;
    }

    public void displayAnswers(){
        System.out.println(answer);
    }

    @Override
    public String toString(){
        return answer;
    }
}
