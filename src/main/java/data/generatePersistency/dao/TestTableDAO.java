package data.generatePersistency.dao;

import data.DbUtil;
import data.generatePersistency.ConnectionFactory;
import domain.generateDomain.TestTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTableDAO {
    private Connection connection;
    private Statement statement;

    public TestTableDAO() {}

    public TestTable getTestTable(int id)
    {
        String query = "SELECT * FROM TESTTABLE WHERE TESTCOLUMN1 = 'test1'";
        ResultSet rs = null;
        TestTable testTable = null;
        try
        {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()){
                String test1 = rs.getString("TESTCOLUMN1");
                String test2 = rs.getString("TESTCOLUMN2");
                String test3 = rs.getString("TESTCOLUMN3");
                testTable = new TestTable(test1, test2, test3);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return testTable;
    }
}
