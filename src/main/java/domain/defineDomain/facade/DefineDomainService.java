package domain.defineDomain.facade;

import data.databaseUtilities.DatabaseErrorLogger;
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

    private DefineDomainService() {
        businessRules = new ArrayList<BusinessRule>();
    }

    public static DefineDomainService getInstance() {
        if (instance == null) {
            instance = new DefineDomainService();
        }
        return instance;
    }

    public int defineBusinessRule(int businessRuleID) throws Exception {
        BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();
        BusinessRule businessRule;
        try {
            businessRule = businessRuleBuilder.defineBusinessRule(businessRuleID);
        } catch (Exception e) {
            throw new Exception("Businessrule not found" + DatabaseErrorLogger.getInstance().getErrors());
        }
        addBusinessrule(businessRule);
        return businessRule.getId();
    }

    private void addBusinessrule(BusinessRule businessRule) {
        BusinessRule ruleFromList = getBusinessRuleFromList(businessRule.getId());
        if(ruleFromList != null) {
            businessRules.set(businessRules.indexOf(ruleFromList),businessRule);
        } else {
            businessRules.add(businessRule);
        }
    }

    public String getBusinessRuleName(int businessRuleID) throws Exception {
        BusinessRule businessRule;
        try {
            businessRule = this.getBusinessRuleFromList(businessRuleID);
        } catch(NullPointerException e) {
            throw new Exception("Businessrule has not been generated yet");
        }
        return businessRule.getName();
    }

    public String getTriggerTemplateCode(int businessRuleID) throws Exception {
        try {
            BusinessRule businessRule = this.getBusinessRuleFromList(businessRuleID);
            HashMap<String, Object> details = DefinePersistencyService.getInstance().getTemplateDetails(businessRule.getRuleType().getId(), businessRule.getTargetDatabase().getTargetDatabaseType().getId());
            TriggerTemplate triggerTemplate = new TriggerTemplate(((BigDecimal) details.get("templateid")).intValue(), businessRule.getRuleType(), businessRule.getTargetDatabase().getTargetDatabaseType(), (String) details.get("templatecode"));
            return triggerTemplate.getCode();
        } catch (NullPointerException e) {
            throw new Exception("No code template found" + DatabaseErrorLogger.getInstance().getErrors());
        }
    }

    public HashMap<String, Object> getTemplateVariables(int businessRuleID) {
        BusinessRule businessRule = this.getBusinessRuleFromList(businessRuleID);
        HashMap<String, Object> templateValues = new HashMap<String, Object>();
        templateValues.put("businessRuleName", businessRule.getName());
        templateValues.put("error" , businessRule.getError());
        templateValues.put("operator", businessRule.getOperator());

        int rowCounter = 0;
        while (rowCounter < businessRule.getAttributes().size()) {
            templateValues.put("attribute" + Integer.toString(rowCounter + 1), businessRule.getAttribute(rowCounter).getName());
            templateValues.put("table" + Integer.toString(rowCounter + 1), businessRule.getAttribute(rowCounter).getTable());
            rowCounter += 1;
        }

        rowCounter = 0;
        while (rowCounter < businessRule.getValues().size()) {
            templateValues.put("value" + Integer.toString(rowCounter + 1), businessRule.getValue(rowCounter));
            rowCounter += 1;
        }

        rowCounter = 0;
        String listOfValues = "";
        while (rowCounter < businessRule.getValues().size()) {
            if (rowCounter == 0) {
                listOfValues += "'" + businessRule.getValue(rowCounter) + "'";
            } else {
                listOfValues += ",'" + businessRule.getValue(rowCounter) + "'";
            }
            rowCounter += 1;
        }
        templateValues.put("listOfValues", listOfValues);

        return templateValues;
    }



    public BusinessRule getBusinessRuleFromList(int businessRuleID) {
        BusinessRule businessRule = null;
        for (BusinessRule businessRuleLoop : businessRules) {
            if (businessRuleLoop.getId() == businessRuleID) {
                businessRule = businessRuleLoop;
                break;
            }
        }
        return businessRule;
    }

    public String getTableName(int businessRuleID) {
        return getBusinessRuleFromList(businessRuleID).getAttribute(0).getTable();
    }
}
