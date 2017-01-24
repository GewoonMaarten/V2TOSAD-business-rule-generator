package main.java.domain.defineDomain.facade;

import main.java.data.definePersistency.facade.DefinePersistencyService;
import main.java.domain.defineDomain.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Maarten de Klerk on 18-1-2017.
 */
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
