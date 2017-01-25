package domain.defineDomain;

public class TriggerTemplate {
    private int templateid;
    private String templatecode;
    private BusinessruleType businessruleType;
    private TargetDatabaseType targetDatabaseType;

    public TriggerTemplate(int templateid, BusinessruleType businessRuleType, TargetDatabaseType targetDatabaseType, String code) {
        this.templateid = templateid;
        this.businessruleType = businessRuleType;
        this.targetDatabaseType = targetDatabaseType;
        this.templatecode = code;
    }

    public String getCode() {
        return templatecode;
    }

    public BusinessruleType getBusinessruleType() {
        return businessruleType;
    }

    public TargetDatabaseType getTargetDatabaseType() {
        return targetDatabaseType;
    }
}
