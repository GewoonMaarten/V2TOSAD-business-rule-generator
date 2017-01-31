package data.generatePersistency.dao;

import data.BaseDAO;
import data.ConnectionFactory;
import data.DatabaseConfig;
import data.DbUtil;

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
            statement.execute(triggerCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }

}
