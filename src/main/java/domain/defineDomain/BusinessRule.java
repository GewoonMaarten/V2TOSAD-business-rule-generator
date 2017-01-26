package domain.defineDomain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class BusinessRule {
    private int id;
    private String name;
    private String generatedTrigger;
    private String operator;
    private BusinessruleType ruleType;
    private TargetDatabase targetDatabase;
    private ArrayList<Attribute> attributes;
    private ArrayList<String> values;
    private String error;

    public BusinessRule(int id, String name, String operator, String error) {
        this.id = id;
        this.name = name;
        this.operator = operator;
        this.attributes = new ArrayList<Attribute>();
        this.values = new ArrayList<String>();
        this.error = error;
    }

    public String getGeneratedTrigger() {
        return generatedTrigger;
    }

    public int getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOperator() {
        return operator;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public Attribute getAttribute(int index)
    {
        return attributes.get(index);
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public String getValue(int index)
    {
        return values.get(index);
    }

    public String getError() {
        return error;
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

    public void addAtributes(ArrayList<HashMap<String, Object>> attributes)
    {
        for(HashMap<String, Object> attributeDetails: attributes)
        {
            if(attributeDetails.get("targetattributeid") != null) {
                this.attributes.add(new Attribute(((BigDecimal) attributeDetails.get("targetattributeid")).intValue(),
                        (String) attributeDetails.get("name"), (String) attributeDetails.get("type")));
            }
        }
    }

    public void addValues(ArrayList<HashMap<String, Object>> values)
    {
        for(HashMap<String, Object> attributeDetails: values)
        {
            if(attributeDetails.get("value") != null) {
                this.values.add((String)attributeDetails.get("value"));
            }
        }
    }

    public TargetDatabase getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(TargetDatabase targetDatabase) {
        this.targetDatabase = targetDatabase;
    }
}
