package data.generatePersistency.dao;

import data.BaseDAO;
import data.ConnectionFactory;
import data.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ParentTemplateDAO extends BaseDAO {
    private Connection connection;
    private Statement statement;
    private HashMap<String, Object> hashMap;

    public ParentTemplateDAO() {
        hashMap = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getParentTemplateDetails(int targetDatabaseTypeID) {
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM TEMPLATEPARENT WHERE TARGETDATABASETYPEID = " + targetDatabaseTypeID;
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
