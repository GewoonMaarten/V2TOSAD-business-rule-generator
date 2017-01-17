package data.definePersistency;

import data.DatabaseConnection;
import domain.defineDomain.BusinessruleType;
import domain.defineDomain.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class BusinessRuleTypeDAO {

    private static BusinessRuleTypeDAO instance = null;

    private BusinessRuleTypeDAO(){}

    public static BusinessRuleTypeDAO getInstance(){
        if(instance == null){
            instance = new BusinessRuleTypeDAO();
        }
        return instance;
    }


    public BusinessruleType getBussinessRuleTypeById(int id){
        BusinessruleType businessruleType = null;

        String sql = "select name, code, description, EXAMPLE, categoryID from BusinessRuleType where businessRuleTypeID = "+ id;

        Connection conn = null;
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection("tosad_2016_2a_team2","tosad_2016_2a_team2", "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl");
            conn = databaseConnection.open();
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("name");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String example = rs.getString("EXAMPLE");
                int categoryId = rs.getInt("categoryID");

                Category category = CategoryDAO.getInstance().getCategorybyId(categoryId);
                if(example != null){
                    businessruleType = new BusinessruleType(id, name, code, description, example, category);
                } else {
                    businessruleType = new BusinessruleType(id, name, code, description, category);
                }

            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }

        return businessruleType;
    }
}
