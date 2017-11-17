package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        String urlConnection = "jdbc:sqlite:Kata5.DB";
        Connection connection = DriverManager.getConnection(urlConnection);
        
        Statement statement = connection.createStatement();
        String query = ("CREATE TABLE IF NOT EXISTS MAILS ('Id'INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT  NOT NULL)");
        statement.execute(query);
        
        String fileString = "emails.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File (fileString)));
        String mail;
        
        while((mail = reader.readLine()) != null) {
            if(!mail.contains("@")) continue;
            query = "INSERT INTO MAILS(mail) VALUES ('"+ mail + "')";
            statement.executeUpdate(query);
        }
        
        statement.close();
        connection.close();
    }
}
