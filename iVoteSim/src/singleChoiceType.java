import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class singleChoiceType  implements  VotingService{
    private final Question question;
    private final HashMap<String, Answer> studentAnswers;
    private final HashMap<String, Integer> studentResults;
    private int total;

    public singleChoiceType(Question question){
        this.question = question;
        studentAnswers = new HashMap<>();
        studentResults = new HashMap<>();
    }

    @Override
    public void getAnswer(ArrayList<Answer> answers, String identifier){
        //check if user submitted an answer
        if(studentAnswers.get(identifier) != null)
            studentAnswers.remove(identifier);
        else if (!answers.isEmpty())
            studentAnswers.put(identifier,answers.get(answers.size()-1));
    }

    @Override
    public void displayAllAnswers() {
        //need iterator
        Iterator<String> it = studentAnswers.keySet().iterator();
        studentResults.clear();

        //count occurrence of each answer
        while (it.hasNext()) {
            String k = studentAnswers.get(it.next()).toString();
            if(!studentResults.containsKey(k)){
                //if dont exist then set to 1
                studentResults.put(k,1);
            }
            else {
                //if exist in table then += 1
                int temp = studentResults.get(k);
                temp += 1;
                studentResults.put(k, temp);
            }
        }

        //print everything here
        System.out.println("\n" + "Final Answers for \"" + question + "\": ");

        //print final statistics
        it = studentResults.keySet().iterator();
        while (it.hasNext()) {
            String k = it.next();
            System.out.println("\t\t" + k + ": ");
            System.out.println("\t\t\t" + studentResults.get(k));
            this.total += studentResults.get(k);
        }
        System.out.println("The total amount of people who voted is: " + this.total);
    }

}
