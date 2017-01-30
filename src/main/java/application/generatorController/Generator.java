package application.generatorController;

import domain.generateDomain.facade.GenerateDomainService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import domain.defineDomain.facade.DefineDomainService;

import java.io.StringReader;
import java.io.StringWriter;

public class Generator {

    public Generator(){}

    public String generateTriggerCodeByRuleId(int businessRuleID) {
        int definedBusinessRuleID = DefineDomainService.getInstance().defineBusinessRule(businessRuleID);
        String code = this.getTriggerCode(definedBusinessRuleID);
        saveTriggerCode(code, definedBusinessRuleID);
        return code;
    }

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

    private void saveTriggerCode(String code, int businessRuleID)
    {
        GenerateDomainService.getInstance().saveTrigger(code, businessRuleID);
    }
}
