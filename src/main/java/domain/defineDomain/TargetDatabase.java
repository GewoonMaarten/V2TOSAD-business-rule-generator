package domain.defineDomain;

/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class TargetDatabase {
    private int targetDatabaseID;
    private String application;
    private String appliactionShort;
    private String url;
    private String username;
    private String password;
    private TargetDatabaseType targetDatabaseType;

    public TargetDatabase(int targetDatabaseID, String application, String appliactionShort, String url, String username, String password, TargetDatabaseType targetDatabaseType) {
        this.targetDatabaseID = targetDatabaseID;
        this.application = application;
        this.appliactionShort = appliactionShort;
        this.url = url;
        this.username = username;
        this.password = password;
        this.targetDatabaseType = targetDatabaseType;
    }

    public int getTargetDatabaseID() {
        return targetDatabaseID;
    }

    public void setTargetDatabaseID(int targetDatabaseID) {
        this.targetDatabaseID = targetDatabaseID;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAppliactionShort() {
        return appliactionShort;
    }

    public void setAppliactionShort(String appliactionShort) {
        this.appliactionShort = appliactionShort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TargetDatabaseType getTargetDatabaseType() {
        return targetDatabaseType;
    }

    public void setTargetDatabaseType(TargetDatabaseType targetDatabaseType) {
        this.targetDatabaseType = targetDatabaseType;
    }

    @Override
    public String toString() {
        return "TargetDatabase{" +
                "targetDatabaseID=" + targetDatabaseID +
                ", application='" + application + '\'' +
                ", appliactionShort='" + appliactionShort + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", targetDatabaseType=" + targetDatabaseType +
                '}';
    }
}
