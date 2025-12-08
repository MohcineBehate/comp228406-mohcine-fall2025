package exercise1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {


    private static final String URL =
            "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres" +
                    "?user=postgres.jescmboyyeamhrrjdjce" +
                    "&password=sssupabase75" +
                    "&sslmode=require";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connected to database!");
            return conn;
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
