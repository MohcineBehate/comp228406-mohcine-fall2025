package exercise2;

import java.util.Random;

/**
 * Lotto class: contains an array of 3 random integers (1..9)
 */
public class Lotto {
    private int[] numbers;

    public Lotto() {
        numbers = new int[3];
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            numbers[i] = r.nextInt(9) + 1; // 1..9
        }
    }

    public int[] getNumbers() {
        return numbers.clone(); // return a clone for encapsulation
    }

    public int getSum() {
        return numbers[0] + numbers[1] + numbers[2];
    }
}
