import application.generatorController.Generator;
import data.definePersistency.dao.TemplateDAO;
import data.generatePersistency.dao.TriggerDAO;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Generator generator = new Generator();
        TriggerDAO test = new TriggerDAO();
        TemplateDAO test2 = new TemplateDAO();
        test2.getTemplateDetails(2,3);
        HashMap<String, String> testmap = new HashMap<String, String>();
        testmap.put("host", "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl");
        testmap.put("username", "tosad_2016_2a_team2_target");
        testmap.put("password", "tosad_2016_2a_team2_target");
        testmap.put("databasetype", "");
        test.saveTrigger("bla", testmap);
    }
}
