package domain.generateDomain;

import domain.defineDomain.TargetDatabase;

public class Trigger {
    private String code;
    private TargetDatabase targetDatabase;
    public Trigger(String code, TargetDatabase targetDatabase) {
        this.code = code;
        this.targetDatabase = targetDatabase;
    }

    public String getCode() {
        return code;
    }

    public TargetDatabase getTargetDatabase() {
        return targetDatabase;
    }
}
