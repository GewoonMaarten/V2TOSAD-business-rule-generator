package data.generatePersistency.facade;

import domain.generateDomain.Trigger;

public class GeneratePersistencyService {
    private static GeneratePersistencyService instance = null;

    public static GeneratePersistencyService getInstance() {
        if(instance == null) {
            instance = new GeneratePersistencyService();
        }
        return instance;
    }


    public void saveTrigger(Trigger trigger) {
        //TODO database stuffz
    }
}
