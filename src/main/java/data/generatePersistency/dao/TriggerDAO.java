package data.generatePersistency.dao;

import data.databaseUtilities.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TriggerDAO extends BaseDAO {

    private Connection connection;
    private Statement statement;

    public void executeTrigger(String triggerCode, DatabaseConfig targetDatabaseDetails) throws Exception {
        connection = ConnectionFactory.getConnection(targetDatabaseDetails);
        try {
            statement = connection.createStatement();
            //triggerCode = triggerCode.replaceAll("\r\n", " ");
            statement.execute(triggerCode);
        } catch (SQLException e) {
            DatabaseErrorLogger.getInstance().addError(e.getMessage());
            throw new Exception("Failed to execute trigger on target" + DatabaseErrorLogger.getInstance().getErrors());
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }

}
