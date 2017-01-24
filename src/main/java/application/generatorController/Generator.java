package main.java.application.generatorController;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import main.java.domain.defineDomain.BusinessRule;
import main.java.domain.defineDomain.facade.DefineDomainService;
import main.java.domain.generateDomain.Trigger;
import main.java.domain.generateDomain.facade.GenerateDomainService;

import java.io.IOException;
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
        //Template temp = application.generatorController.StringReplaceConf.getInstance().getCfg().getTemplate("Oracle/attribute/"+businessRule+".ftl");
        Trigger trigger = createTriggerWithTemplate(businessRule);

        GenerateDomainService.getInstance().saveTrigger(trigger);
    }

    private Trigger createTriggerWithTemplate(BusinessRule businessRule) {
        Trigger trigger = null;
        try {
            Template freeMarkerTemplate;
            StringWriter sw = new StringWriter();
            main.java.domain.defineDomain.Template codeTemplate;
            codeTemplate = DefineDomainService.getInstance().getTemplate(businessRule, businessRule.getTargetDatabase().getTargetDatabaseType().getId());
            freeMarkerTemplate = new Template("test", new StringReader(codeTemplate.getCode()), StringReplaceConf.getInstance().getCfg());
            freeMarkerTemplate.process(businessRule.getValues(), sw);

            trigger = new Trigger(sw.toString(), businessRule.getTargetDatabase().getTargetDatabaseType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return trigger;
    }


    public String generatedParent(HashMap root) {
        String generatedParent = null;

        try {
            Template temp = StringReplaceConf.getInstance().getCfg().getTemplate("Oracle/parentTrigger.ftl");
            StringWriter sw = new StringWriter();

            root.put("generatedTriggers", generatedTriggers);

            temp.process(root, sw);

            generatedParent = sw.toString();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (TemplateException te){
            te.printStackTrace();
        }
        return generatedParent;
    }
}
