package main.java.domain.generateDomain;

import main.java.domain.defineDomain.TargetDatabase;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
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
