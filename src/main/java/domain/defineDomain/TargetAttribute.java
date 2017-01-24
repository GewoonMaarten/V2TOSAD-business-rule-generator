package domain.defineDomain;

public class TargetAttribute {
    private int targetAttributeID;
    private String name;
    private String type;
    private TargetTable targetTable;

    public TargetAttribute(int targetAttributeID, String name, String type, TargetTable targetTable) {
        this.targetAttributeID = targetAttributeID;
        this.name = name;
        this.type = type;
        this.targetTable = targetTable;
    }

    public int getTargetAttributeID() {
        return targetAttributeID;
    }

    public void setTargetAttributeID(int targetAttributeID) {
        this.targetAttributeID = targetAttributeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TargetTable getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(TargetTable targetTable) {
        this.targetTable = targetTable;
    }

    @Override
    public String toString() {
        return "TargetAttribute{" +
                "targetAttributeID=" + targetAttributeID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", targetTable=" + targetTable +
                '}';
    }
}
