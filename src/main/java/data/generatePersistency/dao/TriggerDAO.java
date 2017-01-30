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

    public void executeTrigger(String triggerCode, HashMap<String, Object> targetDatabaseDetails)
    {
        connection = ConnectionFactory.getConnection(targetDatabaseDetails);

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
