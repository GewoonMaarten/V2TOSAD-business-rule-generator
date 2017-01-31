package domain.defineDomain;

public class Attribute {
    private int targetattributeid;
    private String name;
    private String type;

    public Attribute(int targetattributeid, String name, String type) {
        this.targetattributeid = targetattributeid;
        this.name = name;
        this.type = type;
    }

    public int getTargetattributeid() {
        return targetattributeid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
