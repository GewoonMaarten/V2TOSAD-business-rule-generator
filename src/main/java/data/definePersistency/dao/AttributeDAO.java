package data.definePersistency.dao;

import data.databaseUtilities.BaseDAO;
import data.databaseUtilities.ConnectionFactory;
import data.databaseUtilities.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AttributeDAO extends BaseDAO {
    private Connection connection;
    private Statement statement;
    private ArrayList<HashMap<String, Object>> hashMap;

    public AttributeDAO() {
        hashMap = new ArrayList<HashMap<String, Object>>();
    }

    public ArrayList<HashMap<String, Object>> getBusinessRuleAttributesDetails(int businessRuleID) {
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM BUSINESSRULEVALUE LEFT OUTER JOIN TARGETATTRIBUTE ON " +
                    "TARGETATTRIBUTE.TARGETATTRIBUTEID = BUSINESSRULEVALUE.TARGETATTRIBUTEID WHERE " +
                    "BUSINESSRULEVALUE.BUSINESSRULEID = " + businessRuleID + "ORDER BY BUSINESSRULEVALUE.POSITION ASC";
            hashMap = this.selectAllRecords(statement, query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return hashMap;
    }
}
