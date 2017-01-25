package domain.defineDomain.facade;

import data.definePersistency.facade.DefinePersistencyService;
import domain.defineDomain.BusinessRule;
import domain.defineDomain.BusinessRuleBuilder;
import domain.defineDomain.TriggerTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class DefineDomainService {
    private static DefineDomainService instance = null;

    private ArrayList<BusinessRule> businessRules;

    private DefineDomainService(){
        businessRules = new ArrayList<BusinessRule>();
    }

    public static DefineDomainService getInstance(){
        if(instance == null){
            instance = new DefineDomainService();
        }
        return instance;
    }

    public BusinessRule getBusinessRule(int businessRuleID) {
        BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();
        return businessRuleBuilder.defineBusinessRule(businessRuleID);
    }

    public TriggerTemplate getTemplate(BusinessRule businessRule) {
        HashMap<String, Object> details = DefinePersistencyService.getInstance().getTemplateDetails(businessRule.getRuleType().getId(), businessRule.getTargetDatabase().getTargetDatabaseType().getId());
        TriggerTemplate triggerTemplate = new TriggerTemplate(((BigDecimal)details.get("templateid")).intValue(), businessRule.getRuleType(), businessRule.getTargetDatabase().getTargetDatabaseType(), (String)details.get("templatecode"));
        return triggerTemplate;
    }
}
