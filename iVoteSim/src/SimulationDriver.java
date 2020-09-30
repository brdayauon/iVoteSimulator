import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
public class SimulationDriver {

    public static void main(String[] args){
        driver();
    }

    public static HashSet<Student> generateStudents(int amountOfStudents){
        HashSet<Student> setOfStudents = new HashSet<>();
        int min = 48;
        int max = 57;
        for(int i = 0; i < amountOfStudents; i++){
            StringBuilder studentID = new StringBuilder();
            for(int j = 0; j < 3; j++){
                int genRandomNumber = (int) (Math.random() * (max - min + 1)) + min;
                studentID.append((char) genRandomNumber);
            }
            if (setOfStudents.contains(studentID)) i -= 1;
            else {
                setOfStudents.add(new Student(studentID.toString()));
            }
        }
        return setOfStudents;
    }

    public static void generateAnswers(Question question, ArrayList<Student> students, VotingService voteService){
        ArrayList<Answer> questionOptions = question.answerArrayList();
        ArrayList<Answer> studentAnswer = new ArrayList<>();
        Random rand = new Random();

        for (Student student : students) {
            //answer of student to choose from the answer choices
            int answerOfStudent = rand.nextInt(questionOptions.size());
            studentAnswer.add(questionOptions.get((answerOfStudent)));
            System.out.println("student" +  student.studentID  +  " chose: " + studentAnswer);

            student.chooseAnswer(studentAnswer, voteService);
            studentAnswer.clear();
        }
    }

    public static void multipleChoiceTest(){
        String question = "What is your favorite language for mobile development?";
        int amountOfStudents = 30;
        System.out.println("Multiple Choice with " + amountOfStudents + " users.");

        //        2) configure the question for iClicker Service;
        ArrayList<Answer> answerChoices = new ArrayList<>();
        Answer a = new inputAnswer("A. Dart");
        Answer b = new inputAnswer("B. Kotlin");
        Answer c = new inputAnswer("C. Swift");
        Answer d = new inputAnswer("D. Objective C");

        answerChoices.add(a);
        answerChoices.add(b);
        answerChoices.add(c);
        answerChoices.add(d);
        Question multipleChoiceQuestion = new Question(answerChoices,question);
        VotingService multipleChoiceFormat = new multipleChoiceType(multipleChoiceQuestion);

        //        3) randomly generate a number students and the answers;
        //        4) submit all the students’ answers to iClicker Service;
        HashSet<Student> students = generateStudents(amountOfStudents);
        generateAnswers(multipleChoiceQuestion, new ArrayList<>(students), multipleChoiceFormat);

        //        5) call the iClicker Service output function to display the result
        multipleChoiceFormat.displayAllAnswers();
        answerChoices.clear();
    }

    public static void singleChoiceTest(){
        String question = "Are you studying Leetcode?";
        int amountOfStudents = 30;

        System.out.println("Single choice with " + amountOfStudents + " users.");

        //        2) configure the question for iClicker Service;
        ArrayList<Answer> answerChoices = new ArrayList<>();
        Answer firstChoice = new inputAnswer("A. Yes");
        Answer secondChoice = new inputAnswer("B. No");
        answerChoices.add(firstChoice);
        answerChoices.add(secondChoice);
        Question singleChoiceQuestion = new Question(answerChoices, question);
        VotingService singleChoiceFormat = new singleChoiceType(singleChoiceQuestion);

        //        3) randomly generate a number students and the answers;
        //        4) submit all the students’ answers to iClicker Service;
        HashSet<Student> students = generateStudents(amountOfStudents);
        generateAnswers(singleChoiceQuestion, new ArrayList<>(students), singleChoiceFormat);

        //        5) call the iClicker Service output function to display the result
        singleChoiceFormat.displayAllAnswers();
        answerChoices.clear();
    }
    public static void driver() {
        singleChoiceTest();
        System.out.println("\n------------------------------------------------------------\n");
        multipleChoiceTest();
    }
}
