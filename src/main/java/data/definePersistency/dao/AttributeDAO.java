package data.definePersistency.dao;

import data.BaseDAO;
import data.DbUtil;
import data.definePersistency.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class AttributeDAO extends BaseDAO
{
    private Connection connection;
    private Statement statement;
    private HashMap<String, Object> hashMap;

    public AttributeDAO()
    {
        hashMap = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getBusinessRuleAttributesDetails(int targetDatabaseID)
    {
        connection = ConnectionFactory.getConnection();
        try
        {
            statement = connection.createStatement();
            String query = "SELECT  * FROM BUSINESSRULE WHERE BUSINESSRULEID = " + targetDatabaseID;
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
