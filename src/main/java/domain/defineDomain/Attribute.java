package domain.defineDomain;

public class Attribute {
    private int targetattributeid;
    private String name;
    private String type;
    private String table;

    public Attribute(int targetattributeid, String name, String type, String table) {
        this.targetattributeid = targetattributeid;
        this.name = name;
        this.type = type;
        this.table = table;
    }

    public int getTargetattributeid() {
        return targetattributeid;
    }

    public String getName() {
        return name;
    }

    public String getTable() { return table; }

    public String getType() {
        return type;
    }
}
