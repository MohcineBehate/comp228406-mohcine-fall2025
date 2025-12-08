package exercise1;

public class Player {
    private long playerId;
    private String playerName;
    private String playerEmail;
    private int playerAge;

    public Player(long playerId, String playerName, String playerEmail, int playerAge) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerAge = playerAge;
    }

    // -- GETTERS -
    public long getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    @Override
    public String toString() {
        return playerName + " (" + playerId + ")";
    }
}
