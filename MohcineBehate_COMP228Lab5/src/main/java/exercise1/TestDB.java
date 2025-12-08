package exercise1;

public class TestDB {
    public static void main(String[] args) {

        System.out.println("Adding sample players...");
        PlayerDAO.insertPlayer("Mohamed", "mohamed@gmail.com", 25);
        PlayerDAO.insertPlayer("John", "john@gmail.com", 30);

        System.out.println("Adding sample games...");
        GameDAO.insertGame("FIFA 25");
        GameDAO.insertGame("GTA VI");

        System.out.println("Linking players to games...");
        PlayerGameDAO.insertPlayerGame(1, 1);
        PlayerGameDAO.insertPlayerGame(2, 2);

        System.out.println("DONE.");
    }
}
