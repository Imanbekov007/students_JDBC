package peaksoftava8.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Java8",
                    "postgres",
                    "postgres"
            );
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
