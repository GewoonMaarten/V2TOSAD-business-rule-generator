package data;

import java.sql.*;
import java.util.HashMap;

public class BaseDAO {
    private HashMap<String, Object> hashMap;

    public HashMap<String, Object> selectStatement(Statement statement, String query) throws SQLException
    {
        hashMap = new HashMap<String, Object>();
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        while (rs.next())
        {
            for(int i=1; i<=columns; ++i)
            {
                hashMap.put(md.getColumnName(i).toLowerCase(),rs.getObject(i));
            }
            break;
        }
        return hashMap;
    }
}
