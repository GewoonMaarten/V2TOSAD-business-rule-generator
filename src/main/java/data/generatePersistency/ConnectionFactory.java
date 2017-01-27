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

    private Connection createConnection(String host, String username, String password, String DRIVER_CLASS)
    {
        Connection connection = null;

        Connection conn = null;
        try {
            Class.forName(this.DRIVER_CLASS);
            String db_class;
            db_class = DriverManager.getConnection(host, username, password).getClass().getName();
            System.out.println(db_class);
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
