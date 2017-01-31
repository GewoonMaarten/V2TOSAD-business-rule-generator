package application.generatorController;

import domain.generateDomain.facade.GenerateDomainService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import domain.defineDomain.facade.DefineDomainService;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Generator {

    public Generator(){}

    public String generateTriggerCodeByRuleId(int businessRuleID) {
        DefineDomainService.getInstance().defineBusinessRule(businessRuleID);
        String templateCode = DefineDomainService.getInstance().getTriggerTemplateCode(businessRuleID);
        String name = DefineDomainService.getInstance().getBusinessRuleName(businessRuleID);
        HashMap<String,Object> variables = DefineDomainService.getInstance().getTemplateVariables(businessRuleID);

        String code = this.getTriggerCode(templateCode, name, variables);
        return code;
    }

    private String getTriggerCode(String triggerTemplateCode, String name, HashMap<String, Object> variables) {
        StringWriter sw = new StringWriter();
        try {
            Template freeMarkerTemplate = new Template(name, new StringReader(triggerTemplateCode), StringReplaceConf.getInstance().getCfg());
            freeMarkerTemplate.process(variables, sw);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
    /*
    private String getTriggerCode(int businessRuleID) {
        StringWriter sw = new StringWriter();
        String triggerTemplateCode = DefineDomainService.getInstance().getTriggerTemplateCode(businessRuleID);
        try {
            Template freeMarkerTemplate = new Template(DefineDomainService.getInstance().getBusinessRuleName(businessRuleID),
                    new StringReader(triggerTemplateCode), StringReplaceConf.getInstance().getCfg());
            freeMarkerTemplate.process(DefineDomainService.getInstance().getTemplateVariables(businessRuleID), sw);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
*/



    public String generateParentTrigger(int businessRuleID, String table, ArrayList<String> generatedTriggers) {
        String parentTemplate = GenerateDomainService.getInstance().getParentTemplate(businessRuleID);
        String businessRuleName = DefineDomainService.getInstance().getBusinessRuleName(businessRuleID);
        String applicationName = "";
        String[] splitString = businessRuleName.split("_");
        table = table.split("\"")[1];

        for(int i = 0; i < 3; i++)
        {
            applicationName += splitString[i] = "_";
        }

        HashMap<String, Object> variables = new HashMap<String, Object>();
        variables.put("name", applicationName);
        variables.put("table", table);
        variables.put("generatedTriggers", generatedTriggers);

        String code = this.getTriggerCode(parentTemplate, applicationName, variables);
        GenerateDomainService.getInstance().executeTriggerCode(code, businessRuleID);
        return code;
    }
}
