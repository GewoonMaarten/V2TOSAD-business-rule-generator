package data.definePersistency.dao;

import data.databaseUtilities.BaseDAO;
import data.databaseUtilities.ConnectionFactory;
import data.databaseUtilities.DatabaseErrorLogger;
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
            String query = "SELECT BUSINESSRULEVALUE.BUSINESSRULEID BUSINESSRULEID, " +
                    "BUSINESSRULEVALUE.TARGETATTRIBUTEID TARGETATTRIBUTEID, " +
                    "BUSINESSRULEVALUE.VALUE VALUE, " +
                    "BUSINESSRULEVALUE.POSITION POSITION, " +
                    "BUSINESSRULEVALUE.BUSINESSRULEVALUEID BUSINESSRULEVALUEID, " +
                    "TARGETATTRIBUTE.TARGETATTRIBUTEID TARGETATTRIBUTEID_0, " +
                    "TARGETATTRIBUTE.NAME NAME, " +
                    "TARGETATTRIBUTE.TYPE TYPE, " +
                    "TARGETATTRIBUTE.TARGETTABLEID TARGETTABLEID, " +
                    "Targettable.TARGETTABLEID TARGETTABLEID_1, " +
                    "Targettable.NAME tablename, " +
                    "Targettable.TARGETDATABASEID TARGETDATABASEID FROM BUSINESSRULEVALUE LEFT OUTER JOIN TARGETATTRIBUTE ON TARGETATTRIBUTE.TARGETATTRIBUTEID = BUSINESSRULEVALUE.TARGETATTRIBUTEID " +
                    "LEFT OUTER JOIN Targettable on TARGETATTRIBUTE.TARGETTABLEID = Targettable.TARGETTABLEID " +
                    "WHERE BUSINESSRULEVALUE.BUSINESSRULEID = " + businessRuleID + " ORDER BY BUSINESSRULEVALUE.POSITION ASC";
            hashMap = this.selectAllRecords(statement, query);
        } catch (SQLException e) {
            e.printStackTrace();
            DatabaseErrorLogger.getInstance().addError(e.getMessage());
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return hashMap;
    }
}
