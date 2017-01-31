package domain.generateDomain.facade;

import data.generatePersistency.facade.GeneratePersistencyService;
import domain.defineDomain.facade.DefineDomainService;
import domain.generateDomain.Trigger;

public class GenerateDomainService {
    private static GenerateDomainService instance = null;

    public static GenerateDomainService getInstance() {
        if (instance == null) {
            instance = new GenerateDomainService();
        }
        return instance;
    }

    public String getGeneratedTrigger(int businessRuleID) {
        DefineDomainService.getInstance().defineBusinessRule(businessRuleID);
        String triggerCode = DefineDomainService.getInstance().getBusinessRuleFromList(businessRuleID).getGeneratedTrigger();
        return triggerCode;
    }

    public void executeTriggerCode(String code, int businessRuleID) {
        Trigger trigger = new Trigger(code, DefineDomainService.getInstance().getBusinessRuleFromList(businessRuleID).getTargetDatabase());
        GeneratePersistencyService.getInstance().executeTrigger(trigger.getCode(), trigger.getTargetDatabase().getTargetDatabaseDetails());
    }


    public String getParentTemplate(int businessRuleID) {
        return GeneratePersistencyService.getInstance().getParentTemplate(DefineDomainService.getInstance().getBusinessRuleFromList(businessRuleID).getTargetDatabase().getTargetDatabaseType().getId());
    }
}
