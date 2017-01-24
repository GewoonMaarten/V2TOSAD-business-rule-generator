package main.java.domain.generateDomain;

import main.java.domain.defineDomain.TargetDatabaseType;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
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
