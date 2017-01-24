package domain.defineDomain.facade;

import data.definePersistency.facade.DefinePersistencyService;
import domain.defineDomain.BusinessRule;
import domain.defineDomain.BusinessRuleBuilder;
import domain.defineDomain.Template;

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

    public Template getTemplate(BusinessRule businessRule, int targetDatabaseTypeId) {
        HashMap<String, Object> details = DefinePersistencyService.getInstance().getTemplateDetails(businessRule.getRuleType().getId(), targetDatabaseTypeId);

        Template template = new Template(businessRule.getRuleType(), businessRule.getTargetDatabase().getTargetDatabaseType(), (String) details.get("code"));
        return template;
    }
}
