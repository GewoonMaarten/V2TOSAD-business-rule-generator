package domain.generateDomain;

import domain.defineDomain.TargetDatabaseType;

public class Trigger {
    private String code;
    private TargetDatabaseType targetDatabaseType;
    public Trigger(String code, TargetDatabaseType targetDatabase) {
        this.code = code;
        this.targetDatabaseType = targetDatabase;
    }

    public String getCode() {
        return code;
    }

    public TargetDatabaseType getTargetDatabase() {
        return targetDatabaseType;
    }
}
