package main.java.data.generatePersistency.facade;

import main.java.data.generatePersistency.dao.TestTableDAO;
import main.java.domain.generateDomain.TestTable;

public class GeneratePersistencyService {
    private TestTableDAO dao;

    public GeneratePersistencyService() {
        dao = new TestTableDAO();
    }

    public TestTable getTestTableData(int id)
    {
        return dao.getTestTable(id);
    }
}
