package data.generatePersistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class ConnectionFactory {
    private static ConnectionFactory instance = new ConnectionFactory();

    public ConnectionFactory()
    {
    }

    private Connection createConnection(HashMap<String, Object> targetDatabaseDetails)
    {
        String databaseType = (String) targetDatabaseDetails.get("databasetype");
        String host = (String) targetDatabaseDetails.get("host");
        String username = (String) targetDatabaseDetails.get("username");
        String password = (String) targetDatabaseDetails.get("password");
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

    public static Connection getConnection(HashMap<String, Object> targetDatabaseDetails)
    {
        return instance.createConnection(targetDatabaseDetails);
    }
}
