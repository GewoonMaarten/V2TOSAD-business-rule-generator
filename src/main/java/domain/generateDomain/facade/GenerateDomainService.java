package domain.generateDomain.facade;

import data.generatePersistency.facade.GeneratePersistencyService;
import domain.defineDomain.TargetDatabase;
import domain.defineDomain.facade.DefineDomainService;
import domain.generateDomain.Trigger;

import java.lang.annotation.Target;
import java.util.HashMap;

public class GenerateDomainService {
    private static GenerateDomainService instance = null;

    public static GenerateDomainService getInstance(){
        if(instance == null){
            instance = new GenerateDomainService();
        }
        return instance;
    }

    public void saveTrigger(String code, int businessRuleID) {
        Trigger trigger = new Trigger(code, DefineDomainService.getInstance().getBusinessRuleFromList(businessRuleID).getTargetDatabase());
        GeneratePersistencyService.getInstance().saveTrigger(trigger.getCode(), trigger.getTargetDatabase().getTargetDatabaseDetails());
    }


}
