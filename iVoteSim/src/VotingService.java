import java.util.ArrayList;

public interface VotingService {

    //receive answer from a "user"
     void getAnswer(ArrayList<Answer> answers, String identifier);

    //shows the answer
     void displayAllAnswers();

 }
