package data.generatePersistency.facade;

import data.databaseUtilities.DatabaseConfig;
import data.generatePersistency.dao.ParentTemplateDAO;
import data.generatePersistency.dao.TriggerDAO;

import java.util.HashMap;

public class GeneratePersistencyService {
    private static GeneratePersistencyService instance = null;

    public static GeneratePersistencyService getInstance() {
        if (instance == null) {
            instance = new GeneratePersistencyService();
        }
        return instance;
    }


    public void executeTrigger(String triggerCode, HashMap<String, Object> targetDatabase) throws Exception {
        TriggerDAO triggerDAO = new TriggerDAO();
        triggerDAO.executeTrigger(triggerCode,
                new DatabaseConfig((String) targetDatabase.get("host"),
                        (String) targetDatabase.get("username"),
                        (String) targetDatabase.get("password"),
                        (String) targetDatabase.get("databasetype")));
    }

    public String getParentTemplate(int targetDatabaseTypeID) {
        ParentTemplateDAO parentTemplateDAO = new ParentTemplateDAO();
        HashMap<String, Object> parentTemplateDetails = parentTemplateDAO.getParentTemplateDetails(targetDatabaseTypeID);
        return (String) parentTemplateDetails.get("templateparentcode");

    }
}
