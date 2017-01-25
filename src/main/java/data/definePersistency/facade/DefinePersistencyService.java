package data.definePersistency.facade;

import data.definePersistency.dao.BusinessRuleDAO;
import data.definePersistency.dao.BusinessRuleTypeDAO;
import data.definePersistency.dao.TargetDatabaseDAO;

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
        BusinessRuleDAO businessRuleDAO = new BusinessRuleDAO();
        return businessRuleDAO.getBusinessRuleDetails(businessRuleID);
    }

    public HashMap<String,Object> getBusinessRuleTypeDetails(int businessRuleID)
    {
        BusinessRuleTypeDAO businessRuleTypeDAO = new BusinessRuleTypeDAO();
        return businessRuleTypeDAO.getBusinessRuleTypeDetails(businessRuleID);
    }

    public HashMap<String, Object> getTargetDatabaseDetails(int targetDatabaseID)
    {
        TargetDatabaseDAO targetDatabaseDAO = new TargetDatabaseDAO();
        return targetDatabaseDAO.getTargetDatabaseDetails(targetDatabaseID);
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
