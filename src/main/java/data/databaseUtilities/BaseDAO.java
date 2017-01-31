package data.databaseUtilities;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDAO {
    private HashMap<String, Object> selectOneRecord;
    private ArrayList<HashMap<String, Object>> selectAllRecords;

    public HashMap<String, Object> selectOneRecord(Statement statement, String query) throws SQLException {
        selectOneRecord = new HashMap<String, Object>();
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columns; ++i) {
                selectOneRecord.put(md.getColumnName(i).toLowerCase(), rs.getObject(i));
            }
            break;
        }
        return selectOneRecord;
    }

    public ArrayList<HashMap<String, Object>> selectAllRecords(Statement statement, String query) throws SQLException {
        HashMap<String, Object> tableDetails;
        selectAllRecords = new ArrayList<HashMap<String, Object>>();
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        while (rs.next()) {
            tableDetails = new HashMap<String, Object>();
            for (int i = 1; i <= columns; ++i) {
                tableDetails.put(md.getColumnName(i).toLowerCase(), rs.getObject(i));
            }
            selectAllRecords.add(tableDetails);
        }
        return selectAllRecords;
    }
}
