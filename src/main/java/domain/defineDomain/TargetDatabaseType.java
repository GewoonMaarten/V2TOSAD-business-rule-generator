package main.java.domain.defineDomain;

import main.java.data.definePersistency.facade.DefinePersistencyService;

import java.util.HashMap;

/**
 * Created by Bart Heijenk on 23/01/2017.
 */
public class TargetDatabaseType {
    private int id;
    private String name;

    public TargetDatabaseType(int businessRuleID, String typename) {
        HashMap<String,Object> details = DefinePersistencyService.getInstance().getTargetDatabaseTypeDetails(businessRuleID);
        this.id = (Integer)details.get("id");
        this.name = (String)details.get("name");
    }
}
