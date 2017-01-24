package domain.defineDomain;

public class BusinessRule {
    private int businessRuleID;
    private String name;
    private String generatedTrigger;
    private Operator operator;
    private BusinessruleType businessruleType;
    private TargetDatabase targetDatabase;
    private String error;

    public BusinessRule(int businessRuleID, String name, String generatedTrigger, Operator operator, BusinessruleType businessruleType, TargetDatabase targetDatabase, String error) {
        this.businessRuleID = businessRuleID;
        this.name = name;
        this.generatedTrigger = generatedTrigger;
        this.operator = operator;
        this.businessruleType = businessruleType;
        this.targetDatabase = targetDatabase;
        this.error = error;
    }

    public int getBusinessRuleID() {
        return businessRuleID;
    }

    public void setBusinessRuleID(int businessRuleID) {
        this.businessRuleID = businessRuleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneratedTrigger() {
        return generatedTrigger;
    }

    public void setGeneratedTrigger(String generatedTrigger) {
        this.generatedTrigger = generatedTrigger;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BusinessruleType getBusinessruleType() {
        return businessruleType;
    }

    public void setBusinessruleType(BusinessruleType businessruleType) {
        this.businessruleType = businessruleType;
    }

    public TargetDatabase getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(TargetDatabase targetDatabase) {
        this.targetDatabase = targetDatabase;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BusinessRule{" +
                "businessRuleID=" + businessRuleID +
                ", name='" + name + '\'' +
                ", generatedTrigger='" + generatedTrigger + '\'' +
                ", operator=" + operator +
                ", businessruleType=" + businessruleType +
                ", targetDatabase=" + targetDatabase +
                ", error='" + error + '\'' +
                '}';
    }
}