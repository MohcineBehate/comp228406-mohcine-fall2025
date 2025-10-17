package exercise2;

public abstract class GameTester {
    protected String name;
    protected boolean fullTime;

    public GameTester(String name, boolean fullTime) {
        this.name = name;
        this.fullTime = fullTime;
    }

    public abstract double calculateSalary();
}
