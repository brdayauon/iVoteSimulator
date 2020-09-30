public class inputAnswer extends Answer{
    private String answer;

    public inputAnswer(String answer){
        this.answer = answer;
    }

    public void displayAnswers(){
        System.out.println(answer);
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }

    @Override
    public String toString(){
        return answer;
    }


}
