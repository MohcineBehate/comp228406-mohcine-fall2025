package exercise1;

import java.util.*;

public class InsuranceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Insurance> policies = new ArrayList<>();

        System.out.println("How many insurance records do you want to enter?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter type (health/life): ");
            String type = sc.next().trim().toLowerCase();
            Insurance policy = type.equals("life") ? new Life() : new Health();

            System.out.print("Enter monthly cost: ");
            double cost = sc.nextDouble();

            policy.setInsuranceCost(cost);
            policies.add(policy);
        }

        System.out.println("\n--- Insurance Summary ---");
        for (Insurance ins : policies) ins.displayInfo();

        sc.close();
    }
}
