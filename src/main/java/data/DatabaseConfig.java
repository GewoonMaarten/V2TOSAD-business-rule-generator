package data;


public class DatabaseConfig {
    private String host;
    private String username;
    private String password;
    private String databaseType;

    public DatabaseConfig(String host, String username, String password, String databaseType) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.databaseType = databaseType;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseType() {
        return databaseType;
    }
}
