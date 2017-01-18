package application.generatorController;

import domain.defineDomain.BusinessRule;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Generator {
    public void generateBusinessRuleById(int id) {
        Map root = new HashMap();
        Map value = new HashMap<String, Object>();

        value.put("minimum", 123);
        value.put("maximum", 23423);

        root.put("name", "test");
        root.put("attribute", "salaris");
        root.put("operator", "between");
        root.put("value", value);

        try {
            Template temp = StringReplaceConf.getInstance().getCfg().getTemplate("Oracle/attribute/range.ftl");
            StringWriter sw = new StringWriter();
            temp.process(root, sw);

            BusinessRule businessRule = new BusinessRule();
            businessRule.setGeneratedTrigger(sw.toString());

            ArrayList<String> generatedTriggers = new ArrayList<String>();

            generatedTriggers.add(sw.toString());

            System.out.println(generatedParent(generatedTriggers));

        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (TemplateException te){
            te.printStackTrace();
        }
    }


    private String generatedParent(ArrayList<String> generatedTriggers) {
        String generatedParent = null;


        try {
            Template temp = StringReplaceConf.getInstance().getCfg().getTemplate("Oracle/parentTrigger.ftl");
            StringWriter sw = new StringWriter();

            Map root = new HashMap();
            root.put("generatedTriggers", generatedTriggers);
            root.put("name", "test");
            root.put("table", "gert");

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
