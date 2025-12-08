package exercise1;

import java.sql.*;
import java.util.ArrayList;

public class GameDAO {

    // INSERT
    public static void insertGame(String title) {
        String sql = "INSERT INTO \"Game\" (game_title) VALUES (?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.executeUpdate();
            System.out.println("Game added!");

        } catch (Exception e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // GET ALL
    public static ArrayList<String> getAllGames() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT game_title FROM \"Game\"";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(rs.getString("game_title"));
            }

        } catch (Exception e) {
            System.out.println("Select failed: " + e.getMessage());
        }

        return list;
    }
}
