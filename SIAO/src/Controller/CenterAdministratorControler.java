package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CenterAdministratorControler {
    /**
     * renvoi un booléen si l'authgetification a réussi
     * tu vas te servir du retour de la fonction pour faire l'authentification
     * @param login
     * @param password
     * @return
     */
    public static boolean toConnect(String login, String password){
        
        Boolean result = false;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection =  dbConnexion.openConnexion();
        final String name = "admin";

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
