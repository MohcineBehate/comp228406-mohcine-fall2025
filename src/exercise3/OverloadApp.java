package exercise3;

/**
 * Driver to call the overloaded methods and display results
 */
public class OverloadApp {
    public static void main(String[] args) {
        int r1 = OverloadDemo.sum(2, 3);
        double r2 = OverloadDemo.sum(2.5, 3.7);
        int r3 = OverloadDemo.sum(1, 2, 3);

        System.out.println("sum(2,3) = " + r1);
        System.out.println("sum(2.5,3.7) = " + r2);
        System.out.println("sum(1,2,3) = " + r3);
    }
}
