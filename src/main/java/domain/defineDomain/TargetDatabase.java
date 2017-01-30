package domain.defineDomain;

import data.definePersistency.facade.DefinePersistencyService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.WeakHashMap;

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

    public HashMap<String, Object> getTargetDatabaseDetails()
    {
        HashMap<String, Object> targetDatabaseDetails = new HashMap<String,Object>();
        targetDatabaseDetails.put("databasetype", targetDatabaseType.getTargetDatabaseTypeName());
        targetDatabaseDetails.put("username", username);
        targetDatabaseDetails.put("password", password);
        targetDatabaseDetails.put("host", url);
        return targetDatabaseDetails;
    }
}
