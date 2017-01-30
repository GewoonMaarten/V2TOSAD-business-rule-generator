package data.generatePersistency;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //bron: http://theopentutorials.com/tutorials/java/jdbc/jdbc-examples-introduction/
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String host = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
    public static final String username = "tosad_2016_2a_team2_target";
    public static final String password= "tosad_2016_2a_team2_target";
    public static final String DRIVER_CLASS = "oracle.jdbc.OracleDriver";

    public ConnectionFactory()
    {/*
        try
        {
            Class.forName(DRIVER_CLASS);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    private Connection createConnection(String host, String username, String password, String databaseType)
    {
        Connection connection = null;
        String DRIVER_CLASS="";

        try {
            if (databaseType.equals("MYSQL")) {
                DRIVER_CLASS = "com.mysql.jdbc.Driver";
            } else if (databaseType.equals("ORACLE")) {
                DRIVER_CLASS = "oracle.jdbc.OracleDriver";
            } else if (databaseType.equals("POSTGRESQL")) {
                DRIVER_CLASS = "org.postgresql.Driver";
            }
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Connection getConnection(String host, String username, String password, String databasetype)
    {
        return instance.createConnection(host, username, password, databasetype);
    }


}
