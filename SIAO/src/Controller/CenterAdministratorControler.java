package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CenterAdministratorControler {

    public static boolean toConnect(String login, String password, String name){
        
        Boolean result = false;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection =  dbConnexion.openConnexion();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT email, password FROM centerAdmin WHERE name =" + name);
            String logined = resultSet.getString("email");
            String passwored = resultSet.getString("password");
            
            result = logined == login && passwored == passwored;            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
