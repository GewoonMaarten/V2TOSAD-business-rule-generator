package domain.defineDomain;

import data.definePersistency.facade.DefinePersistency;

import java.util.HashMap;

/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class TargetDatabase {
    private int id;
    private TargetDatabaseType type;
    private String password;
    private String username;

    public TargetDatabase(int bussinessRuleID) {
        HashMap<String,Object> details = DefinePersistency.getInstance().getTargetDatabaseDetails(bussinessRuleID);

        id = (Integer)details.get("id");
        password = (String)details.get("password");
        username = (String)details.get("username");

        type = new TargetDatabaseType((Integer)details.get("typeid"),(String)details.get("typename"));
    }

    public TargetDatabaseType getTargetDatabaseType()
    {
        return type;
    }
}
