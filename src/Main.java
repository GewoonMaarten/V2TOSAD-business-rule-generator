import data.DatabaseConnection;

public class Main {
    public static void main(String[] args){
        new DatabaseConnection("tosad_2016_2a_team2_target","tosad_2016_2a_team2_target", "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl");
    }
}
