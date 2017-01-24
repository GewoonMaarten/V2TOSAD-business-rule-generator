package domain.generateDomain.facade;

import data.generatePersistency.facade.GeneratePersistencyService;
import domain.generateDomain.Trigger;

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
