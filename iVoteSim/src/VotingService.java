import java.util.ArrayList;

public interface VotingService {

    //receive answers
     void getAnswer(ArrayList<Answer> answers, String identifier);

    //shows the answer
     void displayAllAnswers();

 }
