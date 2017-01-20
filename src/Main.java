import application.generatorController.Generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Generator generator = new Generator();

        HashMap rangeRoot = new HashMap();
        HashMap value = new HashMap<String, Object>();

        value.put("minimum", 123);
        value.put("maximum", 23423);

        rangeRoot.put("name", "range");
        rangeRoot.put("attribute", "salaris");
        rangeRoot.put("operator", "between");
        rangeRoot.put("value", value);
        generator.generateBusinessRuleById(1, rangeRoot, "range");

        HashMap compareRoot = new HashMap();
        HashMap compareValue = new HashMap<String, Object>();

        compareValue.put("compare", "test");

        compareRoot.put("name", "compare");
        compareRoot.put("attribute", "name");
        compareRoot.put("operator", "!=");
        compareRoot.put("value", compareValue);
        generator.generateBusinessRuleById(1, compareRoot, "compare");

        HashMap root = new HashMap();
        root.put("name", "test_trg");
        root.put("table", "test_table");

        System.out.println(generator.generatedParent(root));

    }
}
