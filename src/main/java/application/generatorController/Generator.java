package application.generatorController;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import domain.defineDomain.facade.DefineDomainService;

import java.io.StringReader;
import java.io.StringWriter;

public class Generator {

    public Generator(){}

    public String generateBusinessRuleById(int businessRuleID) {
        int definedBusinessRuleID = DefineDomainService.getInstance().defineBusinessRule(businessRuleID);
        return this.getTriggerCode(definedBusinessRuleID);
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
}
