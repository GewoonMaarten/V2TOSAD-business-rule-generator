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

    public int defineBusinessRule(int businessRuleID)
    {
        BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();
        BusinessRule businessRule = businessRuleBuilder.defineBusinessRule(businessRuleID);
        businessRules.add(businessRule);
        return businessRule.getId();
    }

    public String getBusinessRuleName(int businessRuleID)
    {
        BusinessRule businessRule = this.getBusinessRuleFromList(businessRuleID);
        return businessRule.getName();
    }

    public String getTriggerTemplateCode(int businessRuleID)
    {
        BusinessRule businessRule = this.getBusinessRuleFromList(businessRuleID);
        HashMap<String, Object> details = DefinePersistencyService.getInstance().getTemplateDetails(businessRule.getRuleType().getId(), businessRule.getTargetDatabase().getTargetDatabaseType().getId());
        TriggerTemplate triggerTemplate = new TriggerTemplate(((BigDecimal)details.get("templateid")).intValue(), businessRule.getRuleType(), businessRule.getTargetDatabase().getTargetDatabaseType(), (String)details.get("templatecode"));
        return triggerTemplate.getCode();
    }

    public HashMap<String, Object> getTemplateVariables(int businessRuleID)
    {
        BusinessRule businessRule = this.getBusinessRuleFromList(businessRuleID);
        HashMap<String, Object> templateValues = new HashMap<String, Object>();
        templateValues.put("businessRuleName", businessRule.getName());
        templateValues.put("operator", businessRule.getOperator());

        int rowCounter = 0;
        while (rowCounter < businessRule.getAttributes().size())
        {
            templateValues.put("attribute" + Integer.toString(rowCounter + 1), businessRule.getAttribute(rowCounter).getName());
            rowCounter += 1;
        }

        rowCounter = 0;
        while (rowCounter < businessRule.getValues().size())
        {
            templateValues.put("value" + Integer.toString(rowCounter + 1), businessRule.getValue(rowCounter));
            rowCounter += 1;
        }

        rowCounter = 0;
        String listOfValues = "";
        while (rowCounter < businessRule.getValues().size())
        {
            if(rowCounter == 0)
            {
                listOfValues += "'" + businessRule.getValue(rowCounter) + "'";
            }
            else
            {
                listOfValues += ",'" + businessRule.getValue(rowCounter) + "'";
            }
            rowCounter += 1;
        }
        templateValues.put("listOfValues", listOfValues);

        return templateValues;
    }

    private BusinessRule getBusinessRuleFromList(int businessRuleID)
    {
        BusinessRule businessRule = null;
        for(BusinessRule businessRuleLoop : businessRules)
        {
            if(businessRuleLoop.getId() == businessRuleID)
            {
                businessRule = businessRuleLoop;
                break;
            }
        }
        return businessRule;
    }
}
