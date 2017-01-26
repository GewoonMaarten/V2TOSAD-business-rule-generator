package application.generatorController;

import domain.defineDomain.TriggerTemplate;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import domain.defineDomain.BusinessRule;
import domain.defineDomain.facade.DefineDomainService;
import domain.generateDomain.Trigger;
import domain.generateDomain.facade.GenerateDomainService;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Generator {

    public Generator(){}

    public String generateBusinessRuleById(int businessRuleID) {
        BusinessRule businessRule = DefineDomainService.getInstance().getBusinessRule(businessRuleID);
        Trigger trigger = createTriggerWithTemplate(businessRule);
        GenerateDomainService.getInstance().saveTrigger(trigger);
        return trigger.getCode();
    }

    private Trigger createTriggerWithTemplate(BusinessRule businessRule) {
        Trigger trigger = null;
        try {
            Template freeMarkerTemplate;
            StringWriter sw = new StringWriter();
            TriggerTemplate codeTriggerTemplate;
            codeTriggerTemplate = DefineDomainService.getInstance().getTemplate(businessRule);
            freeMarkerTemplate = new Template(businessRule.getName(), new StringReader(codeTriggerTemplate.getCode()), StringReplaceConf.getInstance().getCfg());
            freeMarkerTemplate.process(this.getTemplateValues(businessRule), sw);

            trigger = new Trigger(sw.toString(), businessRule.getTargetDatabase());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return trigger;
    }

    private HashMap<String, Object> getTemplateValues(BusinessRule businessRule)
    {
        HashMap<String, Object> templateValues = new HashMap<String, Object>();
        templateValues.put("businessRuleName", businessRule.getName());
        templateValues.put("operator", businessRule.getOperator());
        templateValues.put("compare", "2");

        int rowCounter = 0;
        while (rowCounter < businessRule.getAttributes().size())
        {
            templateValues.put("attribute" + Integer.toString(rowCounter + 1), businessRule.getAttribute(rowCounter).getName());
            rowCounter += 1;
        }
        return templateValues;
    }
}
