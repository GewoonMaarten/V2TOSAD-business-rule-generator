package data.generatePersistency.facade;

public class GeneratePersistencyService {
    private static GeneratePersistencyService instance = null;

    public static GeneratePersistencyService getInstance() {
        if(instance == null) {
            instance = new GeneratePersistencyService();
        }
        return instance;
    }


    public void saveTrigger(String triggerCode, String targetDatabase) {
        //TODO database stuffz
    }
}
