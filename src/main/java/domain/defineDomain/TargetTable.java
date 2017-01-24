package domain.defineDomain;

public class TargetTable {
    private int targetTableID;
    private String name;
    private TargetDatabase targetDatabase;

    public TargetTable(int targetTableID, String name, TargetDatabase targetDatabase) {
        this.targetTableID = targetTableID;
        this.name = name;
        this.targetDatabase = targetDatabase;
    }

    public int getTargetTableID() {
        return targetTableID;
    }

    public void setTargetTableID(int targetTableID) {
        this.targetTableID = targetTableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TargetDatabase getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(TargetDatabase targetDatabase) {
        this.targetDatabase = targetDatabase;
    }

    @Override
    public String toString() {
        return "TargetTable{" +
                "targetTableID=" + targetTableID +
                ", name='" + name + '\'' +
                ", targetDatabase=" + targetDatabase +
                '}';
    }
}
