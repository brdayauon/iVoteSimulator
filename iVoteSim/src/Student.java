import java.util.ArrayList;

public class Student {
    String studentID;

    public Student(String studentID) {
        this.studentID = studentID;
    }

    //submit answers to voting service
    //@Override
    public void chooseAnswer(ArrayList<Answer> answers, VotingService voteService) {
        voteService.getAnswer(answers, studentID);
    }


    @Override
    public String toString() {
        return studentID;
    }

    @Override
    public boolean equals(Object other) {
        return other.toString().equals(studentID);
    }

    //	each Student should have a unique student ID
   // @Override
    public String identifier() {
        return studentID;
    }

}