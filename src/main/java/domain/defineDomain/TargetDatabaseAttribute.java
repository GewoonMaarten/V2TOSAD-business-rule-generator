package domain.defineDomain;

import java.util.HashMap;

public class TargetDatabaseAttribute {
    private int targetattributeid;
    private String name;
    private String type;

    public TargetDatabaseAttribute(int targetattributeid, String name, String type) {
        this.targetattributeid = targetattributeid;
        this.name = name;
        this.type = type;
    }
}
