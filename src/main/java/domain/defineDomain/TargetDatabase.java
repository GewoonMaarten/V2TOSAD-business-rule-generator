package main.java.domain.defineDomain;

import main.java.data.definePersistency.facade.DefinePersistencyService;

import java.util.HashMap;

/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class TargetDatabase {
    private int id;
    private TargetDatabaseType type;
    private String password;
    private String username;
    private TargetDatabaseType targetDatabaseType;

    public TargetDatabase(int bussinessRuleID) {
        HashMap<String,Object> details = DefinePersistencyService.getInstance().getTargetDatabaseDetails(bussinessRuleID);

        id = (Integer)details.get("id");
        password = (String)details.get("password");
        username = (String)details.get("username");

        type = new TargetDatabaseType((Integer)details.get("typeid"),(String)details.get("typename"));
    }

    public TargetDatabaseType getTargetDatabaseType()
    {
        return type;
    }

    public void setTargetDatabaseType(TargetDatabaseType targetDatabaseType) {
        this.targetDatabaseType = targetDatabaseType;
    }
}
