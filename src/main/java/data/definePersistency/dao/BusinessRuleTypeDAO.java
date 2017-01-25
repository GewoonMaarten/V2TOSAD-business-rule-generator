package data.definePersistency.dao;

import data.BaseDAO;
import data.DbUtil;
import data.definePersistency.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BusinessRuleTypeDAO extends BaseDAO{

    private Connection connection;
    private Statement statement;
    private HashMap<String, Object> hashMap;

    public BusinessRuleTypeDAO()
    {
        hashMap = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getBusinessRuleTypeDetails(int businessRuleTypeID)
    {
        connection = ConnectionFactory.getConnection();
        try
        {
            statement = connection.createStatement();
            String query = "SELECT BUSINESSRULETYPE.*, CATEGORY.NAME AS CATEGORYNAME FROM BUSINESSRULETYPE LEFT OUTER JOIN CATEGORY ON " +
                    "CATEGORY.CATEGORYID = BUSINESSRULETYPE.CATEGORYID WHERE BUSINESSRULETYPEID = " + businessRuleTypeID;
            hashMap = this.selectStatement(statement, query);
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
