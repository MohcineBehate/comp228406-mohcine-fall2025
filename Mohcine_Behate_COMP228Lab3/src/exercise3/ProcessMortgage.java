package exercise3;

import java.util.*;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mortgage[] list = new Mortgage[3];

        System.out.print("Enter current prime rate (%): ");
        double prime = sc.nextDouble() / 100.0;

        for (int i = 0; i < 3; i++) {
            System.out.print("Type (business/personal): ");
            String type = sc.next().toLowerCase();
            System.out.print("Number: ");
            String num = sc.next();
            System.out.print("Customer name: ");
            String name = sc.next();
            System.out.print("Amount: ");
            double amt = sc.nextDouble();
            System.out.print("Term (1/3/5): ");
            int term = sc.nextInt();

            if (type.startsWith("b")) list[i] = new BusinessMortgage(num, name, amt, prime, term);
            else list[i] = new PersonalMortgage(num, name, amt, prime, term);
        }

        System.out.println("\n--- Mortgage Summary ---");
        for (Mortgage m : list) System.out.println(m.getMortgageInfo());

        sc.close();
    }
}
