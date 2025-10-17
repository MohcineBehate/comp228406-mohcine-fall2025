package exercise2;

import java.util.*;

public class GameTesterApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<GameTester> testers = new ArrayList<>();

        System.out.print("Enter number of testers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Type (full/part): ");
            String type = sc.next().toLowerCase();

            if (type.startsWith("f")) testers.add(new FullTimeGameTester(name));
            else {
                System.out.print("Hours: ");
                int hours = sc.nextInt();
                testers.add(new PartTimeGameTester(name, hours));
            }
        }

        System.out.println("\n--- Tester Payroll ---");
        for (GameTester gt : testers)
            System.out.printf("%s | Salary: $%.2f%n", gt.name, gt.calculateSalary());

        sc.close();
    }
}
