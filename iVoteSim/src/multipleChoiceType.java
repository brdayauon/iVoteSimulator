import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class multipleChoiceType implements VotingService {
    private final Question question;
    private final HashMap<String, ArrayList<Answer>> studentAnswers;
    private final HashMap<String, Integer> results;
    private int total;

//    public multipleChoiceType(){
//        question = null;
//        studentAnswers = new HashMap<>();
//        results = new HashMap<>();
//    }

    public multipleChoiceType(Question question) {
        this.question = question;
        studentAnswers = new HashMap<>();
        results = new HashMap<>();
    }

    @Override
    public void getAnswer(ArrayList<Answer> answers, String identifier) {
        HashSet<Answer> selectedOptions = new HashSet<>();
        ArrayList<Answer> answersNoDuplicates = new ArrayList<>();

        if (studentAnswers.get(identifier) != null) {
            studentAnswers.remove(identifier);
        }

        assert question != null;
        ArrayList<Answer> possibilities = question.answerArrayList();
        for (Answer possibility : possibilities) {
            if (!results.containsKey(possibility.toString())) {
                results.put(possibility.toString(), 0);
            }
        }

        for (Answer check : answers) {
            if (!selectedOptions.contains(check)) {
                answersNoDuplicates.add(check);
                selectedOptions.add(check);
            }
        }

        studentAnswers.put(identifier, answersNoDuplicates);

    }

    @Override
    public void displayAllAnswers() {
        Iterator<String> it = studentAnswers.keySet().iterator();
        results.clear();

        while (it.hasNext()) {

            ArrayList<Answer> answers = studentAnswers.get(it.next());
            for (Answer answer : answers) {
                String key = answer.toString();
                if (!results.containsKey(key))
                    results.put(key, 1);
                else {
                    results.put(key, results.get(key) + 1);
                }
            }
        }

            //print results
            it = results.keySet().iterator();
            System.out.println("Results for \"" + question + "\": ");

            while (it.hasNext()) {
                String key = it.next();
                System.out.print(key + ": ");
                System.out.println(results.get(key));
                this.total += 1;
            }

        }
    }


