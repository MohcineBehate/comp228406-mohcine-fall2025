package exercise1;

public class Transaction implements Runnable {
    private Account account;
    private String type;
    private double amount;

    public Transaction(Account account,String type,double amount){
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void run(){
        if(type.equalsIgnoreCase("deposit")) account.deposit(amount);
        else if(type.equalsIgnoreCase("withdraw")) account.withdraw(amount);
    }
}
