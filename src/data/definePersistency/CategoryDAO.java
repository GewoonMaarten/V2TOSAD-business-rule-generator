package data.definePersistency;

import data.DatabaseConnection;
import domain.defineDomain.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Maarten de Klerk on 17-1-2017.
 */
public class CategoryDAO {
    private static CategoryDAO instance = null;

    private CategoryDAO(){}


    public static CategoryDAO getInstance(){
        if(instance == null){
            instance = new CategoryDAO();
        }
        return instance;
    }

    public Category getCategorybyId(int id){
        Category category = null;

        String sql = "select name from Category where categoryID ="+id;

        Connection conn = null;
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection("tosad_2016_2a_team2","tosad_2016_2a_team2", "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl");
            conn = databaseConnection.open();
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("name");

                category = new Category(id, name);
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

        return category;
    }

}

