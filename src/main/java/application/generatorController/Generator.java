package application.generatorController;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Generator {
    private ArrayList<String> generatedTriggers;

    public Generator(){
        generatedTriggers = new ArrayList<String>();
    }

    //ROOT AND BUSINESSRULETYPE ARE TEMPORARY PARAMETERS
    public void generateBusinessRuleById(int id, HashMap root, String businessRule) {

//
//        try {
//            Template temp = application.generatorController.StringReplaceConf.getInstance().getCfg().getTemplate("Oracle/attribute/"+businessRule+".ftl");
//            StringWriter sw = new StringWriter();
//            temp.process(root, sw);
//
//            //BusinessRule businessRule = new BusinessRule();
//            //businessRule.setGeneratedTrigger(sw.toString());
//
//            //System.out.println(sw.toString());
//            generatedTriggers.add(sw.toString());
//
//            //System.out.println(generatedParent(generatedTriggers));
//
//        }catch (IOException ioe){
//            ioe.printStackTrace();
//        }catch (TemplateException te){
//            te.printStackTrace();
//        }
//    }


//    public String generatedParent(HashMap root) {
//        String generatedParent = null;
//
//        try {
//            Template temp = StringReplaceConf.getInstance().getCfg().getTemplate("Oracle/parentTrigger.ftl");
//            StringWriter sw = new StringWriter();
//
//            root.put("generatedTriggers", generatedTriggers);
//
//            temp.process(root, sw);
//
//            generatedParent = sw.toString();
//        }catch (IOException ioe){
//            ioe.printStackTrace();
//        }catch (TemplateException te){
//            te.printStackTrace();
//        }
//        return generatedParent;
//    }
}}
