package Sistema.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3309/Banco_do_serasa";
    private static final String username = "root";
    private static final String password = "root";
    public static Connection connectionFactory() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }
}
