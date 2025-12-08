package exercise1;

import java.sql.*;
import java.util.ArrayList;

public class PlayerDAO {

    // INSERT
    public static void insertPlayer(String name, String email, int age) {
        String sql = "INSERT INTO \"Player\" (player_name, player_email, player_age) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.executeUpdate();
            System.out.println("Player added!");

        } catch (Exception e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // READ ALL
    public static ArrayList<Player> getAllPlayers() {
        ArrayList<Player> list = new ArrayList<>();
        String sql = "SELECT player_id, player_name, player_email, player_age FROM \"Player\"";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Player(
                        rs.getInt("player_id"),
                        rs.getString("player_name"),
                        rs.getString("player_email"),
                        rs.getInt("player_age")
                ));
            }

        } catch (Exception e) {
            System.out.println("Query failed: " + e.getMessage());
        }

        return list;
    }

    // UPDATE
    public static void updatePlayer(int id, String name, String email, int age) {
        String sql = "UPDATE \"Player\" SET player_name=?, player_email=?, player_age=? WHERE player_id=?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);
            stmt.setInt(4, id);
            stmt.executeUpdate();

            System.out.println("Player updated!");

        } catch (Exception e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // DELETE
    public static void deletePlayer(int id) {
        String sql = "DELETE FROM \"Player\" WHERE player_id=?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Player deleted!");

        } catch (Exception e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}
