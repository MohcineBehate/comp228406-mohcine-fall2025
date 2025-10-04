package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

/**
 * Test class: contains questions, options, and methods for a simple quiz
 */
public class Test {
    private String[] questions;
    private String[][] options;
    private int[] answers; // values 1..4
    private Random random;
    private int correctCount;
    private int incorrectCount;

    public Test() {
        random = new Random();

        // 5 example questions (basic Java)
        questions = new String[] {
                "What is the correct extension for a Java source file?",
                "Which keyword is used to inherit a class in Java?",
                "Which collection maintains insertion order and does not allow duplicates?",
                "What is the return type of the main method in Java?",
                "Which statement is used to handle exceptions?"
        };

        options = new String[][] {
                {"1) .jav", "2) .class", "3) .java", "4) .exe"},
                {"1) implement", "2) extends", "3) inherits", "4) override"},
                {"1) List", "2) Set", "3) Map", "4) Queue"},
                {"1) void", "2) int", "3) String", "4) boolean"},
                {"1) try/catch", "2) if/else", "3) switch", "4) for"}
        };

        // correct answers (1..4)
        answers = new int[] {3, 2, 2, 1, 1};

        correctCount = 0;
        incorrectCount = 0;
    }

    // Public method to start the quiz (called from main)
    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Question ").append(i + 1).append(":\n");
            sb.append(questions[i]).append("\n\n");
            for (int j = 0; j < 4; j++) {
                sb.append((j + 1)).append(". ").append(options[i][j]).append("\n");
            }
            String input = JOptionPane.showInputDialog(null, sb.toString(), "Quiz - Question " + (i + 1), JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Quiz cancelled by the user.");
                return;
            }

            int userAnswer;
            try {
                userAnswer = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                incorrectCount++;
                JOptionPane.showMessageDialog(null, generateMessage(false) + "\nInvalid input. Correct answer: " + options[i][answers[i] - 1]);
                continue;
            }

            if (checkAnswer(i, userAnswer)) {
                correctCount++;
                JOptionPane.showMessageDialog(null, generateMessage(true));
            } else {
                incorrectCount++;
                JOptionPane.showMessageDialog(null, generateMessage(false) + "\nCorrect answer: " + options[i][answers[i] - 1]);
            }
        }

        int total = correctCount + incorrectCount;
        double percent = total == 0 ? 0.0 : (100.0 * correctCount) / total;
        String result = String.format("Quiz Result:\nCorrect: %d\nIncorrect: %d\nPercentage: %.2f%%", correctCount, incorrectCount, percent);
        JOptionPane.showMessageDialog(null, result, "End of Quiz", JOptionPane.INFORMATION_MESSAGE);
    }

    // Check if the answer is correct
    private boolean checkAnswer(int qIndex, int userAnswer) {
        return userAnswer == answers[qIndex];
    }

    // Generate random message for correct or incorrect answer
    private String generateMessage(boolean correct) {
        switch (random.nextInt(4)) {
            case 0:
                return correct ? "Excellent!" : "No. Please try again";
            case 1:
                return correct ? "Good!" : "Wrong. Try once more";
            case 2:
                return correct ? "Keep up the good work!" : "Don't give up!";
            default:
                return correct ? "Nice work!" : "No. Keep trying..";
        }
    }
}
