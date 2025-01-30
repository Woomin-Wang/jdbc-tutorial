package wisoft.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresAccess {

    private static Connection conn = null;

    public static Connection setConnection() {
        final String url = "jdbc:postgresql://localhost:15432/exercise";
        final String username = "woomin";
        final String password = "cgrto46ndl";

        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (final ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }

        return conn;
    }

}