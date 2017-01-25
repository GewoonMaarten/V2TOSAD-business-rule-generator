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
    private ArrayList<String> generatedTriggers;

    public Generator(){
        generatedTriggers = new ArrayList<String>();
    }


    public void generateBusinessRuleById(int businessRuleID) {
        BusinessRule businessRule = DefineDomainService.getInstance().getBusinessRule(businessRuleID);
        //TriggerTemplate temp = application.generatorController.StringReplaceConf.getInstance().getCfg().getTemplate("Oracle/attribute/"+businessRule+".ftl");
        Trigger trigger = createTriggerWithTemplate(businessRule);

        GenerateDomainService.getInstance().saveTrigger(trigger);
    }

    private Trigger createTriggerWithTemplate(BusinessRule businessRule) {
        Trigger trigger = null;
        try {
            Template freeMarkerTemplate;
            StringWriter sw = new StringWriter();
            TriggerTemplate codeTriggerTemplate;
            codeTriggerTemplate = DefineDomainService.getInstance().getTemplate(businessRule);
            freeMarkerTemplate = new Template("Ronaldo", new StringReader(codeTriggerTemplate.getCode()), StringReplaceConf.getInstance().getCfg());
            freeMarkerTemplate.process(this.getTemplateValues(businessRule), sw);

            trigger = new Trigger(sw.toString(), businessRule.getTargetDatabase().getTargetDatabaseType());
            System.out.println(trigger.getCode());
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
        templateValues.put("targetDatabaseAttribute1", "age");
        templateValues.put("operator", businessRule.getOperator());
        templateValues.put("ruleTypeName", "2");
        templateValues.put("compare", "compare yolo");
        return templateValues;
    }
}
