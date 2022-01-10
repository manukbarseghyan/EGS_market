package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class MySqlConnection {

        public Connection getConnection() throws SQLException {

            String URL = "jdbc:mysql://localhost:3306/market_db?serverTimezone=UTC";
            String USERNAME = "root";
            String PASSWORD = "12345678";
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(true);
            return connection;
        }
}
