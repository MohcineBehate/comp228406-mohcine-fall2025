package exercise2;

import javax.swing.JOptionPane;

/**
 * Driver to simulate a simple Lotto game
 */
public class LottoApp {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Choose a number between 3 and 27:", "Lotto Game", JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Game cancelled.");
            return;
        }

        int userChoice;
        try {
            userChoice = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Game over.");
            return;
        }

        if (userChoice < 3 || userChoice > 27) {
            JOptionPane.showMessageDialog(null, "Number must be between 3 and 27. Game over.");
            return;
        }

        boolean won = false;
        StringBuilder history = new StringBuilder();

        for (int roll = 1; roll <= 5; roll++) {
            Lotto lotto = new Lotto();
            int[] nums = lotto.getNumbers();
            int sum = lotto.getSum();
            history.append("Roll ").append(roll).append(": ").append(nums[0]).append(", ").append(nums[1]).append(", ").append(nums[2]).append(" => ").append(sum).append("\n");

            JOptionPane.showMessageDialog(null, "Roll " + roll + ": " + nums[0] + ", " + nums[1] + ", " + nums[2] + "\nSum = " + sum);

            if (sum == userChoice) {
                JOptionPane.showMessageDialog(null, "Congratulations! You won on roll " + roll + "!");
                won = true;
                break;
            }
        }

        if (!won) {
            JOptionPane.showMessageDialog(null, "Sorry, computer wins.\nRoll history:\n" + history.toString());
        }
    }
}
