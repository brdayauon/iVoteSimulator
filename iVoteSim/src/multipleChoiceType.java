import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class multipleChoiceType implements VotingService {
    private final Question question;
    private final HashMap<String, ArrayList<Answer>> studentAnswers;
    private final HashMap<String, Integer> studentResults;
    private int total;

    public multipleChoiceType(Question question) {
        this.question = question;
        studentAnswers = new HashMap<>();
        studentResults = new HashMap<>();
    }

    @Override
    public void getAnswer(ArrayList<Answer> answers, String identifier) {
        HashSet<Answer> selectedOptions = new HashSet<>();
        ArrayList<Answer> answersNoDuplicates = new ArrayList<>();

        if (studentAnswers.get(identifier) != null) {
            studentAnswers.remove(identifier);
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
        studentResults.clear();

        while (it.hasNext()) {

            ArrayList<Answer> answers = studentAnswers.get(it.next());
            for (Answer answer : answers) {
                String k = answer.toString();

                //if dont exist then set to 1
                if (!studentResults.containsKey(k))
                    studentResults.put(k, 1);
                else { //if exist in table then += 1
                    int temp = studentResults.get(k);
                    temp += 1;
                    studentResults.put(k, temp);
                }
            }
        }

        //print everything here
        System.out.println("\n" + "Final Answers for \"" + question + "\": ");

        //print final statistics
        it = studentResults.keySet().iterator();
        while (it.hasNext()) {
            String k = it.next();
            System.out.println("\t\t" + k + ": " + studentResults.get(k));
            this.total += studentResults.get(k);
        }
        System.out.println("The total amount of people who voted is: " + this.total);

        }
    }


