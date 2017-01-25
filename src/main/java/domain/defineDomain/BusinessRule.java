package domain.defineDomain;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessRule {
    private int id;
    private String name;
    private String generatedTrigger;
    private String operator;
    private BusinessruleType ruleType;
    private TargetDatabase targetDatabase;
    private ArrayList<TargetDatabaseTable> targetDatabaseTables;
    private String error;

    public BusinessRule(int id, String name, String operator, String error) {
        this.id = id;
        this.name = name;
        this.operator = operator;
        this.targetDatabaseTables = new ArrayList<TargetDatabaseTable>();
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

    public ArrayList<TargetDatabaseTable> getTargetDatabaseTables() {
        return targetDatabaseTables;
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

    public void addTable(TargetDatabaseTable targetDatabaseTable)
    {
        targetDatabaseTables.add(targetDatabaseTable);
    }

    public TargetDatabase getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(TargetDatabase targetDatabase) {
        this.targetDatabase = targetDatabase;
    }
}
