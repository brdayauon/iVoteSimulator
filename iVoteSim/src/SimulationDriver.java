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
            System.out.println("answer of the student is: " + answerOfStudent);
            studentAnswer.add(questionOptions.get((answerOfStudent)));

            //    System.out.println("studentAnswer: " + studentAnswer);
            student.chooseAnswer(studentAnswer, voteService);
            studentAnswer.clear();
        }
    }

    public static void driver() {
        multipleChoiceTest();
    }

    public static void multipleChoiceTest(){
        int amountOfStudents = 30;
        HashSet<Student> students = generateStudents(amountOfStudents);
        System.out.println("Multiple Choice with " + amountOfStudents + " users.");

        ArrayList<Answer> answerChoices = new ArrayList<>();
        Answer a = new inputAnswer("A. Dart");
        Answer b = new inputAnswer("B. Kotlin");
        Answer c = new inputAnswer("C. Swift");
        Answer d = new inputAnswer("D. Objective C");

        answerChoices.add(a);
        answerChoices.add(b);
        answerChoices.add(c);
        answerChoices.add(d);

        Question multipleChoiceQuestion = new Question(answerChoices,"What is your favorite language for mobile development?");
        VotingService multipleChoiceFormat = new multipleChoiceType(multipleChoiceQuestion);
        generateAnswers(multipleChoiceQuestion, new ArrayList<>(students), multipleChoiceFormat);
        multipleChoiceFormat.displayAllAnswers();
        //   multipleChoiceQuestion.displayAnswerChoices();
        answerChoices.clear();
    }

    public static void singleChoiceTest(){
        int amountOfStudents = 30;
        HashSet<Student> students = generateStudents(amountOfStudents);
        System.out.println("Single choice with " + amountOfStudents + " users.");

        Answer firstChoice = new inputAnswer("1. ");
//        2) configure the question for iClicker Service;
////        3) randomly generate a number students and the answers;
//        generateStudents(amountOfStudents);
//        generateAnswers(singleChoice, new ArrayList<Student>(students), vService);
////        4) submit all the students’ answers to iClicker Service;
////        5) call the iClicker Service output function to display the result
    }
}
