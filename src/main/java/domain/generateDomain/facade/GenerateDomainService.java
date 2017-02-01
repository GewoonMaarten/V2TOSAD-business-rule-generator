package domain.generateDomain.facade;

import data.databaseUtilities.DatabaseErrorLogger;
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

    //use if you want to switch to letting the user manually change trigger code in APEX
    public String getGeneratedTrigger(int businessRuleID) throws Exception {
        DefineDomainService.getInstance().defineBusinessRule(businessRuleID);
        String triggerCode = DefineDomainService.getInstance().getBusinessRuleFromList(businessRuleID).getGeneratedTrigger();
        return triggerCode;
    }

    public void executeTriggerCode(String code, int businessRuleID) throws Exception {
        try {
            Trigger trigger = new Trigger(code, DefineDomainService.getInstance().getBusinessRuleFromList(businessRuleID).getTargetDatabase());
            GeneratePersistencyService.getInstance().executeTrigger(trigger.getCode(), trigger.getTargetDatabase().getTargetDatabaseDetails());
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new Exception("Cannot execute trigger" + DatabaseErrorLogger.getInstance().getErrors());
        }
    }


    public String getParentTemplate(int businessRuleID) throws Exception {
        try {
            return GeneratePersistencyService.getInstance().
                    getParentTemplate(DefineDomainService.getInstance().
                            getBusinessRuleFromList(businessRuleID).getTargetDatabase().
                            getTargetDatabaseType().getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new Exception("Cannot find parent template");
        }
    }
}
