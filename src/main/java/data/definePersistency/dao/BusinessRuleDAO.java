package data.definePersistency.dao;

import data.BaseDAO;
import data.DbUtil;
import data.definePersistency.ConnectionFactory;

import java.sql.*;
import java.util.HashMap;

public class BusinessRuleDAO extends BaseDAO{
    private Connection connection;
    private Statement statement;
    private HashMap<String, Object> hashMap;

    public BusinessRuleDAO()
    {
        hashMap = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getBusinessRuleDetails(int businessRuleID)
    {
        connection = ConnectionFactory.getConnection();
        try
        {
        statement = connection.createStatement();
        String query = "SELECT * FROM BUSINESSRULE WHERE BUSINESSRULEID = " + businessRuleID;
        hashMap = this.selectOneRecord(statement, query);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return hashMap;
    }
}
