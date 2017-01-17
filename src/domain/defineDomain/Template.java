package domain.defineDomain;

/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class Template {
    private BusinessruleType businessruleType;
    private TargetDatabase targetDatabase;
    private String path;

    public Template(BusinessruleType businessruleType, TargetDatabase targetDatabase, String path) {
        this.businessruleType = businessruleType;
        this.targetDatabase = targetDatabase;
        this.path = path;
    }
}
