package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String urlConnection = "jdbc:sqlite:Kata5.DB";
        Connection connection = DriverManager.getConnection(urlConnection);
        
        Statement statement = connection.createStatement();
        String query = "Select * from PEOPLE";
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }
    }
}
