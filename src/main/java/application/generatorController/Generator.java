package application.generatorController;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import domain.defineDomain.BusinessRule;
import domain.defineDomain.facade.DefineDomainService;

import java.io.StringReader;
import java.io.StringWriter;

public class Generator {

    public Generator(){}

    public String generateBusinessRuleById(int businessRuleID) {
        // TODO save generated trigger in the database
        BusinessRule businessRule = DefineDomainService.getInstance().getBusinessRule(businessRuleID);
        return this.getTriggerCode(businessRule);
    }

    private String getTriggerCode(BusinessRule businessRule) {
        StringWriter sw = new StringWriter();
        String triggerTemplateCode = DefineDomainService.getInstance().getTriggerTemplateCode(businessRule);
        try {
            Template freeMarkerTemplate = new Template(businessRule.getName(), new StringReader(triggerTemplateCode), StringReplaceConf.getInstance().getCfg());
            freeMarkerTemplate.process(DefineDomainService.getInstance().getTemplateVariables(businessRule), sw);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
