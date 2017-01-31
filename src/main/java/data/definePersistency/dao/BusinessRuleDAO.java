package data.definePersistency.dao;

import application.generatorController.Generator;
import data.databaseUtilities.BaseDAO;
import data.databaseUtilities.ConnectionFactory;
import data.databaseUtilities.DatabaseErrorLogger;
import data.databaseUtilities.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BusinessRuleDAO extends BaseDAO {
    private Connection connection;
    private Statement statement;
    private HashMap<String, Object> hashMap;

    public BusinessRuleDAO() {
        hashMap = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getBusinessRuleDetails(int businessRuleID){
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.createStatement();
            String query = "SELECT BUSINESSRULE.*, OPERATOR.VALUE AS OPERATORVALUE FROM BUSINESSRULE LEFT OUTER JOIN " +
                    "OPERATOR ON OPERATOR.OPERATORID = BUSINESSRULE.OPERATORID WHERE BUSINESSRULEID = " + businessRuleID;
            hashMap = this.selectOneRecord(statement, query);
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
