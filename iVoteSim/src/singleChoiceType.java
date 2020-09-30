import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class singleChoiceType  implements  VotingService{
    private final Question question;
    private final HashMap<String, Answer> studentAnswers;
    private final HashMap<String, Integer> results;

    public singleChoiceType(){
        question = null;
        studentAnswers = new HashMap<>();
        results = new HashMap<>();
    }

    public singleChoiceType(Question question){
        this.question = question;
        studentAnswers = new HashMap<>();
        results = new HashMap<>();
    }

    @Override
    public void getAnswer(ArrayList<Answer> answers, String identifier){
  //      HashSet<Answer> studentChoices = new HashSet<>();

        if(studentAnswers.get(identifier) != null)
            studentAnswers.remove(identifier);

        if (!answers.isEmpty())
            studentAnswers.put(identifier,answers.get(answers.size()-1));

    }

    @Override
    public void displayAllAnswers() {
        Iterator<String> it = studentAnswers.keySet().iterator();
        results.clear();

        while (it.hasNext()) {
            String key = studentAnswers.get(it.next()).toString();
            if(!results.containsKey(key)){
                results.put(key,1);
            }
            else {
                results.put(key, results.get(key)+1);
            }
        }

        ArrayList<Answer> possbilities = question.answerArrayList();
        for(int i = 0; i < possbilities.size(); i++) {
            Answer possibility = possbilities.get(i);
            if ( !results.containsKey(possibility.toString()))
                results.put(possibility.toString(), 0);
        }


        System.out.println("Results for \"" + question + "\": ");

        it = results.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + ": ");
            System.out.println(results.get(key));
        }

    }

}
