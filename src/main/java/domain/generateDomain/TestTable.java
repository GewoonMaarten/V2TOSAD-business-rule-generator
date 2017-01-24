package main.java.domain.generateDomain;

public class TestTable {
    private String TESTCOLUMN1;
    private String TESTCOLUMN2;
    private String TESTCOLUMN3;

    public TestTable(String TESTCOLUMN1, String TESTCOLUMN2, String TESTCOLUMN3) {
        this.TESTCOLUMN1 = TESTCOLUMN1;
        this.TESTCOLUMN2 = TESTCOLUMN2;
        this.TESTCOLUMN3 = TESTCOLUMN3;
    }

    public String getTESTCOLUMN1() {
        return TESTCOLUMN1;
    }

    public void setTESTCOLUMN1(String TESTCOLUMN1) {
        this.TESTCOLUMN1 = TESTCOLUMN1;
    }

    public String getTESTCOLUMN2() {
        return TESTCOLUMN2;
    }

    public void setTESTCOLUMN2(String TESTCOLUMN2) {
        this.TESTCOLUMN2 = TESTCOLUMN2;
    }

    public String getTESTCOLUMN3() {
        return TESTCOLUMN3;
    }

    public void setTESTCOLUMN3(String TESTCOLUMN3) {
        this.TESTCOLUMN3 = TESTCOLUMN3;
    }

    @Override
    public String toString() {
        return "TestTable{" +
                "TESTCOLUMN1='" + TESTCOLUMN1 + '\'' +
                ", TESTCOLUMN2='" + TESTCOLUMN2 + '\'' +
                ", TESTCOLUMN3='" + TESTCOLUMN3 + '\'' +
                '}';
    }
}
