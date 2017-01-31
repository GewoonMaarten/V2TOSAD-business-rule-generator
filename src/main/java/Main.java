import application.generatorController.Generator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Generator generator = new Generator();
            ArrayList<String> code = new ArrayList<String>();
            code.add(generator.generateTriggerCodeByRuleId(70));
            generator.generateParentTrigger(70,"thing", code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
