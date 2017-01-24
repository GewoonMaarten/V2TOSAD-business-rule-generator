package data.generatePersistency.facade;

import data.generatePersistency.dao.TestTableDAO;
import domain.generateDomain.TestTable;

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
