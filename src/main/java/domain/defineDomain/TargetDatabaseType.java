package domain.defineDomain;

import data.definePersistency.facade.DefinePersistencyService;

import java.util.HashMap;

public class TargetDatabaseType {
    private int id;
    private String name;

    public TargetDatabaseType(int businessRuleID, String typename) {
        HashMap<String,Object> details = DefinePersistencyService.getInstance().getTargetDatabaseTypeDetails(businessRuleID);
        this.id = (Integer)details.get("id");
        this.name = (String)details.get("name");
    }

    public int getId() {
        return id;
    }


}
