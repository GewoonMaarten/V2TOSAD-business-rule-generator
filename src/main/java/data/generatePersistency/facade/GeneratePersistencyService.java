package main.java.data.generatePersistency.facade;

import main.java.domain.generateDomain.Trigger;
import main.java.domain.generateDomain.facade.GenerateDomainService;

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
