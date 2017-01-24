package domain.defineDomain;

public class TargetDatabaseType {
    public int targetDatabaseTypeID;
    public String name;

    public TargetDatabaseType(int targetDatabaseTypeID, String name) {
        this.targetDatabaseTypeID = targetDatabaseTypeID;
        this.name = name;
    }

    public int getTargetDatabaseTypeID() {
        return targetDatabaseTypeID;
    }

    public void setTargetDatabaseTypeID(int targetDatabaseTypeID) {
        this.targetDatabaseTypeID = targetDatabaseTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TargetDatabaseType{" +
                "targetDatabaseTypeID=" + targetDatabaseTypeID +
                ", name='" + name + '\'' +
                '}';
    }
}
