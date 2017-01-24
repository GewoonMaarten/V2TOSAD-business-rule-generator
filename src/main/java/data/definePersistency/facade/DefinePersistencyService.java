package data.definePersistency.facade;

import java.util.ArrayList;
import java.util.HashMap;

public class DefinePersistencyService {

    private static DefinePersistencyService instance = null;

    public static DefinePersistencyService getInstance(){
        if(instance == null){
            instance = new DefinePersistencyService();
        }
        return instance;
    }

    public HashMap<String,Object> getBusinessRuleDetails(int businessRuleID)
    {
        //TODO lookup business rule main.java.data all lowercase
        return null;
    }

    public HashMap<String,Object> getBusinessRuleTypeDetails(int businessRuleID)
    {
        //TODO lookup type main.java.data, add category main.java.data all lowercase ("category*")
        return null;
    }

    public HashMap<String, Object> getTargetDatabaseTypeDetails(int businessRuleID)
    {
        //TODO lookup target database type main.java.data
        return null;
    }

    public HashMap<String, Object> getTargetDatabaseDetails(int businessRuleID)
    {
        //TODO lookup target database main.java.data, add databasetype all lowercase ("type*")
        return null;
    }

    public ArrayList<HashMap<String, Object>> getBusinessRuleAttributesDetails(int businessRuleID)
    {
        //TODO lookup target attribute main.java.data, expect multiple
        return null;
    }

    public HashMap<String,Object> getTemplateDetails(int businessRuleTypeID, int targetDatabaseTypeID) {
        //TODO lookup template
        return null;
    }
}
