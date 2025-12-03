package exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args){
        Account shared = new Account(1000);

        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction(shared,"withdraw",300));
        list.add(new Transaction(shared,"deposit",500));
        list.add(new Transaction(shared,"withdraw",900));
        list.add(new Transaction(shared,"deposit",200));

        ExecutorService service = Executors.newFixedThreadPool(3);

        System.out.println("---- MULTIPLE ATM TRANSACTIONS ----");
        for(Transaction t : list) service.execute(t);

        service.shutdown();
    }
}
