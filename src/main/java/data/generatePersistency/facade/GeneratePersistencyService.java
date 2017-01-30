package data.generatePersistency.facade;

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


    public void saveTrigger(String triggerCode, HashMap<String, Object> targetDatabase) {
        TriggerDAO triggerDAO = new TriggerDAO();
        triggerDAO.saveTrigger(triggerCode, targetDatabase);
    }
}
