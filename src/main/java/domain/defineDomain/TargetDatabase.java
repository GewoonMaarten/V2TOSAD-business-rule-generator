package domain.defineDomain;

import data.definePersistency.facade.DefinePersistencyService;

import java.math.BigDecimal;
import java.util.HashMap;

public class TargetDatabase {
    private int targetdatabaseid;
    private String application;
    private String applicationshort;
    private String url;
    private String username;
    private String password;
    private TargetDatabaseType targetDatabaseType;

    public TargetDatabase(int targetDatabaseID) {
        HashMap<String,Object> details = DefinePersistencyService.getInstance().getTargetDatabaseDetails(targetDatabaseID);

        targetdatabaseid = ((BigDecimal)details.get("targetdatabaseid")).intValue();
        application = (String)details.get("application");
        applicationshort = (String)details.get("applicationshort");
        url = (String)details.get("url");
        username = (String)details.get("username");
        password = (String)details.get("password");
        targetDatabaseType = new TargetDatabaseType(((BigDecimal)details.get("targetdatabasetypeid")).intValue(),(String)details.get("targetdatabasetypename"));
    }

    public TargetDatabaseType getTargetDatabaseType()
    {
        return targetDatabaseType;
    }

    public void setTargetDatabaseType(TargetDatabaseType targetDatabaseType) {
        this.targetDatabaseType = targetDatabaseType;
    }
}
