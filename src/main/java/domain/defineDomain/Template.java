package domain.defineDomain;

public class Template {
    private int templateID;
    private String templateCode;
    private BusinessruleType businessruleType;
    private TargetDatabaseType targetDatabaseType;

    public Template(int templateID, String templateCode, BusinessruleType businessruleType, TargetDatabaseType targetDatabaseType) {
        this.templateID = templateID;
        this.templateCode = templateCode;
        this.businessruleType = businessruleType;
        this.targetDatabaseType = targetDatabaseType;
    }

    public int getTemplateID() {
        return templateID;
    }

    public void setTemplateID(int templateID) {
        this.templateID = templateID;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public BusinessruleType getBusinessruleType() {
        return businessruleType;
    }

    public void setBusinessruleType(BusinessruleType businessruleType) {
        this.businessruleType = businessruleType;
    }

    public TargetDatabaseType getTargetDatabaseType() {
        return targetDatabaseType;
    }

    public void setTargetDatabaseType(TargetDatabaseType targetDatabaseType) {
        this.targetDatabaseType = targetDatabaseType;
    }

    @Override
    public String toString() {
        return "Template{" +
                "templateID=" + templateID +
                ", templateCode='" + templateCode + '\'' +
                ", businessruleType=" + businessruleType +
                ", targetDatabaseType=" + targetDatabaseType +
                '}';
    }
}
