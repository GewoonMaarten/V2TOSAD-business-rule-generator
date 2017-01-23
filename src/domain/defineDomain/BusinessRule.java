package domain.defineDomain;

import java.util.HashMap;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
public class BusinessRule {
    private int id;
    private String name;
    private HashMap<String, Object> values;
    private String generatedTrigger;
    private BusinessruleType ruleType;

    public BusinessRule(int id, String name, HashMap<String, Object> values) {
        this.id = id;
        this.name = name;
        this.values = values;
    }

    public String getGeneratedTrigger() {
        return generatedTrigger;
    }

    public int getId() {

        return id;
    }

    public void setGeneratedTrigger(String generatedTrigger){
        this.generatedTrigger = generatedTrigger;
    }

    public BusinessruleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(BusinessruleType ruleType) {
        this.ruleType = ruleType;
    }
}
