package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {


    private static Connection connection;


    static {
        final String url = "jdbc:mysql://localhost:3306/market_db";
        final String user = "root";
        final String password = "12345678";
       // final String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection(url,user,password
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){

        return connection;
    }

}
