package main.java.domain.generateDomain.facade;

import main.java.data.generatePersistency.facade.GeneratePersistencyService;
import main.java.domain.generateDomain.Trigger;

public class GenerateDomainService {
    private static GenerateDomainService instance = null;

    public static GenerateDomainService getInstance(){
        if(instance == null){
            instance = new GenerateDomainService();
        }
        return instance;
    }

    public void saveTrigger(Trigger trigger) {
        GeneratePersistencyService.getInstance().saveTrigger(trigger);
    }
}
