package data.generatePersistency.dao;

import data.databaseUtilities.BaseDAO;
import data.databaseUtilities.ConnectionFactory;
import data.databaseUtilities.DatabaseConfig;
import data.databaseUtilities.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TriggerDAO extends BaseDAO {

    private Connection connection;
    private Statement statement;

    public void executeTrigger(String triggerCode, DatabaseConfig targetDatabaseDetails) {
        connection = ConnectionFactory.getConnection(targetDatabaseDetails);

        try {
            statement = connection.createStatement();
            triggerCode = triggerCode.replaceAll("\r\n", " ");
            statement.execute(triggerCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }

}
