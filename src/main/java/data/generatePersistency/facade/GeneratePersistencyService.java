package data.generatePersistency.facade;

import data.generatePersistency.dao.ParentTemplateDAO;
import data.generatePersistency.dao.TriggerDAO;

import java.util.HashMap;

public class GeneratePersistencyService {
    private static GeneratePersistencyService instance = null;

    public static GeneratePersistencyService getInstance() {
        if(instance == null) {
            instance = new GeneratePersistencyService();
        }
        return instance;
    }


    public void executeTrigger(String triggerCode, HashMap<String, Object> targetDatabase) {
        TriggerDAO triggerDAO = new TriggerDAO();
        triggerDAO.executeTrigger(triggerCode, targetDatabase);
    }

    public String getParentTemplate(int targetDatabaseTypeID) {
        ParentTemplateDAO parentTemplateDAO = new ParentTemplateDAO();
        HashMap<String, Object> parentTemplateDetails = parentTemplateDAO.getParentTemplateDetails(targetDatabaseTypeID);
        return (String) parentTemplateDetails.get("templateparentcode");

    }
}
