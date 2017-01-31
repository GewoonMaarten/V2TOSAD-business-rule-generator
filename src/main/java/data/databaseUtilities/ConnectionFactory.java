package data.databaseUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory instance = new ConnectionFactory();

    public ConnectionFactory() {
    }

    private Connection createConnection(DatabaseConfig databaseConfig) {
        Connection connection = null;
        String DRIVER_CLASS = "";

        try {
            if (databaseConfig.getDatabaseType().equals("MYSQL")) {
                DRIVER_CLASS = "com.mysql.jdbc.Driver";
            } else if (databaseConfig.getDatabaseType().equals("ORACLE")) {
                DRIVER_CLASS = "oracle.jdbc.OracleDriver";
            } else if (databaseConfig.getDatabaseType().equals("POSTGRESQL")) {
                DRIVER_CLASS = "org.postgresql.Driver";
            }
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(databaseConfig.getHost(), databaseConfig.getUsername(), databaseConfig.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection(DbUtil.getToolDatabaseConfig());
    }

    public static Connection getConnection(DatabaseConfig databaseConfig) {
        return instance.createConnection(databaseConfig);
    }
}
