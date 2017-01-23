package domain.defineDomain;

import data.definePersistency.facade.DefinePersistency;

import java.util.HashMap;

/**
 * Created by Bart Heijenk on 23/01/2017.
 */
public class TargetDatabaseType {
    private int id;
    private String name;

    public TargetDatabaseType(int businessRuleID) {
        HashMap<String,Object> details = DefinePersistency.getInstance().getTargetDatabaseTypeDetails(businessRuleID);
        this.id = (Integer)details.get("id");
        this.name = (String)details.get("name");
    }
}
