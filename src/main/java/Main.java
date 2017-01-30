import application.generatorController.Generator;
import data.generatePersistency.dao.TriggerDAO;
import domain.defineDomain.facade.DefineDomainService;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Generator generator = new Generator();
        generator.generateTriggerCodeByRuleId(70);
    }
}
