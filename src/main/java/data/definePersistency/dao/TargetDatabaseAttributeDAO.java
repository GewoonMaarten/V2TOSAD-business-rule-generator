package data.definePersistency.dao;

import data.BaseDAO;
import data.DbUtil;
import data.definePersistency.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class TargetDatabaseAttributeDAO extends BaseDAO
{
    private Connection connection;
    private Statement statement;
    private ArrayList<HashMap<String, Object>> hashMap;

    public TargetDatabaseAttributeDAO()
    {
        hashMap = new ArrayList<HashMap<String, Object>>();
    }

    public ArrayList<HashMap<String, Object>> getTargetDatabaseAttributesDetails(int targetTableID)
    {
        connection = ConnectionFactory.getConnection();
        try
        {
            statement = connection.createStatement();
            String query = "SELECT  * FROM TARGETATTRIBUTE WHERE TARGETTABLEID = " + targetTableID;
            hashMap = this.selectAllRecords(statement, query);
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
