package football.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection getConnection() throws SQLException {

        String url = System.getenv("JDBC_URL");
        String user = System.getenv("JDBC_USERNAME");
        String password = System.getenv("JDBC_PASSWORD");

        return DriverManager.getConnection(url, user, password);
    }
}

