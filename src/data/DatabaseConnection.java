package data;

import java.sql.* ;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
public class DatabaseConnection {
    private String url;
    private String username;
    private String password;

    public DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection open() throws SQLException{
        return DriverManager.getConnection(this.url, this.username, this.password);
    }
}
