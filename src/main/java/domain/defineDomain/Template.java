package main.java.domain.defineDomain;


/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class Template {
    private BusinessruleType businessruleType;
    private TargetDatabaseType targetDatabaseType;
    private String code;

    public Template(BusinessruleType businessruleType, TargetDatabaseType targetDatabase, String code) {
        this.businessruleType = businessruleType;
        this.targetDatabaseType = targetDatabase;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public BusinessruleType getBusinessruleType() {
        return businessruleType;
    }

    public TargetDatabaseType getTargetDatabaseType() {
        return targetDatabaseType;
    }
}
