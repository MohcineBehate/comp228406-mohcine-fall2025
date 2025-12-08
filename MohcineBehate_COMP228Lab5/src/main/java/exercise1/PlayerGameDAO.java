package exercise1;

import java.sql.*;
import java.util.ArrayList;

public class PlayerGameDAO {

    // INSERT
    public static void insertPlayerGame(int playerId, int gameId) {
        String sql = "INSERT INTO \"PlayerGame\" (player_id, game_id) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, playerId);
            stmt.setInt(2, gameId);
            stmt.executeUpdate();

            System.out.println("Player linked to game!");

        } catch (Exception e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // REPORT: payer + Game names
    public static ArrayList<String[]> getPlayerReport() {
        ArrayList<String[]> list = new ArrayList<>();

        String sql = """
                SELECT p.player_id, p.player_name, p.player_email, p.player_age,
                       g.game_title
                FROM "Player" p
                LEFT JOIN "PlayerGame" pg ON p.player_id = pg.player_id
                LEFT JOIN "Game" g ON pg.game_id = g.game_id
                ORDER BY p.player_id;
                """;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String[] row = new String[5];
                row[0] = String.valueOf(rs.getLong("player_id"));
                row[1] = rs.getString("player_name");
                row[2] = rs.getString("player_email");
                row[3] = String.valueOf(rs.getInt("player_age"));
                row[4] = rs.getString("game_title");  // may be null

                list.add(row);
            }

        } catch (Exception e) {
            System.out.println("Report failed: " + e.getMessage());
        }

        return list;
    }
}
