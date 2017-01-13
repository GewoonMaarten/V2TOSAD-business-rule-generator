package domain;

import java.sql.* ;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
public class DatabaseConnection {
    private String username;
    private String password;
    private String url;
    private Connection conn;

    public DatabaseConnection(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url      = url;
        try{
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public Connection getConn(){
        return conn;
    }

}
