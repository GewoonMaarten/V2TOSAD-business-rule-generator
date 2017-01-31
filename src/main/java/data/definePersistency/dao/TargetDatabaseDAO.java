package data.definePersistency.dao;

import data.BaseDAO;
import data.ConnectionFactory;
import data.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class TargetDatabaseDAO extends BaseDAO {
    private Connection connection;
    private Statement statement;
    private HashMap<String, Object> hashMap;

    public TargetDatabaseDAO() {
        hashMap = new HashMap<String, Object>();
    }

    public HashMap<String, Object> getTargetDatabaseDetails(int targetDatabaseID) {
        connection = ConnectionFactory.getConnection();
        try {
            statement = connection.createStatement();
            String query = "SELECT TARGETDATABASE.*, TARGETDATABASETYPE.NAME AS TARGETDATABASETYPENAME " +
                    "FROM TARGETDATABASE LEFT OUTER JOIN TARGETDATABASETYPE ON TARGETDATABASETYPE.TARGETDATABASETYPEID = " +
                    "TARGETDATABASE.TARGETDATABASEID WHERE TARGETDATABASEID = " + targetDatabaseID;
            hashMap = this.selectOneRecord(statement, query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return hashMap;
    }
}
