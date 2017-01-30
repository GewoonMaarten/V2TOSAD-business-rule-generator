package data.generatePersistency.dao;

import data.BaseDAO;
import data.DbUtil;
import data.generatePersistency.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class TriggerDAO  extends BaseDAO{

    private Connection connection;
    private Statement statement;

    public void saveTrigger(String triggerCode, HashMap<String,String> targetDatabaseDetails)
    {
        connection = ConnectionFactory.getConnection(targetDatabaseDetails.get("host"), targetDatabaseDetails.get("username"), targetDatabaseDetails.get("password"), targetDatabaseDetails.get("databasetype"));

        try {
            statement = connection.createStatement();
            statement.execute(triggerCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }

}
