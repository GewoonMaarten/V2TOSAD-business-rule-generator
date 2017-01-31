package data.definePersistency.facade;

import data.definePersistency.dao.*;

import java.util.ArrayList;
import java.util.HashMap;

public class DefinePersistencyService {

    private static DefinePersistencyService instance = null;

    public static DefinePersistencyService getInstance() {
        if (instance == null) {
            instance = new DefinePersistencyService();
        }
        return instance;
    }

    public HashMap<String, Object> getBusinessRuleDetails(int businessRuleID) {
        BusinessRuleDAO businessRuleDAO = new BusinessRuleDAO();
        return businessRuleDAO.getBusinessRuleDetails(businessRuleID);
    }

    public HashMap<String, Object> getBusinessRuleTypeDetails(int businessRuleID) {
        BusinessRuleTypeDAO businessRuleTypeDAO = new BusinessRuleTypeDAO();
        return businessRuleTypeDAO.getBusinessRuleTypeDetails(businessRuleID);
    }

    public HashMap<String, Object> getTargetDatabaseDetails(int targetDatabaseID) {
        TargetDatabaseDAO targetDatabaseDAO = new TargetDatabaseDAO();
        return targetDatabaseDAO.getTargetDatabaseDetails(targetDatabaseID);
    }

    public ArrayList<HashMap<String, Object>> getAttributesFromBusinessRuleDetails(int businessRuleID) {
        AttributeDAO attributeDAO = new AttributeDAO();
        return attributeDAO.getBusinessRuleAttributesDetails(businessRuleID);
    }

    public HashMap<String, Object> getTemplateDetails(int businessRuleTypeID, int targetDatabaseTypeID) {
        TemplateDAO templateDAO = new TemplateDAO();
        return templateDAO.getTemplateDetails(businessRuleTypeID, targetDatabaseTypeID);
    }
}
