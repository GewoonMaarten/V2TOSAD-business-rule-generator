package data.definePersistency.dao;

import data.databaseUtilities.BaseDAO;
import data.databaseUtilities.ConnectionFactory;
import data.databaseUtilities.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class TemplateDAO extends BaseDAO {
    private Connection connection;
    private Statement statement;
    private HashMap<String, Object> hashMap;

    public TemplateDAO() {
        hashMap = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getTemplateDetails(int businessRuleTypeID, int targetDatabaseTypeID) {
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM TEMPLATE WHERE BUSINESSRULETYPEID = " + businessRuleTypeID + " AND TARGETDATABASETYPEID = " + targetDatabaseTypeID;
            hashMap = this.selectOneRecord(statement, query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return hashMap;
    }
}
