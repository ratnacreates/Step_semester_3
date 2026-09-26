import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer,
                    String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();

    public abstract String getType();
}

class MCQQuestion extends Question {

    public MCQQuestion(String questionText, String correctAnswer,
                       String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {

    public TrueFalseQuestion(String questionText, String correctAnswer,
                             String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    public EssayQuestion(String questionText, String correctAnswer,
                         String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    public double calculateScore() {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matchedKeywords = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        } else if (matchedKeywords == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {

    public static Question createQuestion(String type,
                                           String questionText,
                                           String correctAnswer,
                                           String studentAnswer,
                                           double points) {

        switch (type) {
            case "MCQ":
                return new MCQQuestion(
                        questionText, correctAnswer,
                        studentAnswer, points
                );

            case "TF":
                return new TrueFalseQuestion(
                        questionText, correctAnswer,
                        studentAnswer, points
                );

            case "ESSAY":
                return new EssayQuestion(
                        questionText, correctAnswer,
                        studentAnswer, points
                );

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            double points = Double.parseDouble(
                    parts[6].trim()
            );

            Question question = createQuestion(
                    type,
                    questionText,
                    correctAnswer,
                    studentAnswer,
                    points
            );

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}