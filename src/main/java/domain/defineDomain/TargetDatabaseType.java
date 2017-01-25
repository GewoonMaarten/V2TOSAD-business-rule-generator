package domain.defineDomain;

public class TargetDatabaseType {
    private int targetDatabaseTypeID;
    private String targetDatabaseTypeName;

    public TargetDatabaseType(int targetDatabaseTypeID, String targetDatabaseTypeName) {
        this.targetDatabaseTypeID = targetDatabaseTypeID;
        this.targetDatabaseTypeName = targetDatabaseTypeName;
    }

    public int getId() {
        return targetDatabaseTypeID;
    }
}
