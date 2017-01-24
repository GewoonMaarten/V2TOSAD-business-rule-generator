package main.java.data.definePersistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //bron: http://theopentutorials.com/tutorials/java/jdbc/jdbc-examples-introduction/
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String host = "jdbc:oracle:thin:@ondora02.hu.nl:8521/tosad_2016_2a_team2";
    public static final String username = "tosad_2016_2a_team2";
    public static final String password= "developer123";
    public static final String DRIVER_CLASS = "oracle.jdbc.OracleDriver";

    public ConnectionFactory()
    {
        try
        {
            Class.forName(DRIVER_CLASS);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection()
    {
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(host, username, password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection()
    {
        return instance.createConnection();
    }
}
