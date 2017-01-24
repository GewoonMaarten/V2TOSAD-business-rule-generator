package domain.defineDomain;

public class Operator {
    private int operatorID;
    private String value;

    public Operator(int operatorID, String value) {
        this.operatorID = operatorID;
        this.value = value;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operatorID=" + operatorID +
                ", value='" + value + '\'' +
                '}';
    }
}
