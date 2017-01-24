package main.java.domain.defineDomain;


/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class Template {
    private BusinessruleType businessruleType;
    private TargetDatabase targetDatabase;
    private String code;

    public Template(BusinessruleType businessruleType, TargetDatabase targetDatabase, String code) {
        this.businessruleType = businessruleType;
        this.targetDatabase = targetDatabase;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public TargetDatabase getTargetDatabase() {
        return targetDatabase;
    }
}
