package data.definePersistency.dao;

import data.BaseDAO;
import data.DbUtil;
import data.definePersistency.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class TargetDatabaseTableDAO extends BaseDAO
{
    private Connection connection;
    private Statement statement;
    private ArrayList<HashMap<String, Object>> hashMap;

    public TargetDatabaseTableDAO()
    {
        hashMap = new ArrayList<HashMap<String, Object>>();
    }

    public ArrayList<HashMap<String, Object>> getTargetDatabaseTablesDetails(int targetDatabaseID)
    {
        connection = ConnectionFactory.getConnection();
        try
        {
            statement = connection.createStatement();
            String query = "SELECT TARGETTABLE.* FROM TARGETTABLE WHERE TARGETDATABASEID = " + targetDatabaseID;
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
