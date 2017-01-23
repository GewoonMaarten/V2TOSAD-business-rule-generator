package data.definePersistency.facade;

import java.util.ArrayList;
import java.util.HashMap;

public class DefinePersistency {

    private static DefinePersistency instance = null;

    public static DefinePersistency getInstance(){
        if(instance == null){
            instance = new DefinePersistency();
        }
        return instance;
    }

    public HashMap<String,Object> getBusinessRuleDetails(int businessRuleID)
    {
        //TODO lookup business rule data all lowercase
        return null;
    }

    public HashMap<String,Object> getBusinessRuleTypeDetails(int businessRuleID)
    {
        //TODO lookup type data, add category data all lowercase ("category*")
        return null;
    }

    public HashMap<String, Object> getTargetDatabaseTypeDetails(int businessRuleID)
    {
        //TODO lookup target database type data
        return null;
    }

    public HashMap<String, Object> getTargetDatabaseDetails(int businessRuleID)
    {
        //TODO lookup target database data, add databasetype all lowercase ("type*")
        return null;
    }

    public ArrayList<HashMap<String, Object>> getBusinessRuleAttributesDetails(int businessRuleID)
    {
        //TODO lookup target attribute data, expect multiple
        return null;
    }
}
