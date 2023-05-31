package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CenterAdministratorControler {

    public static boolean toConnect(String login, String password){

        Boolean result = false;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection =  dbConnexion.openConnexion();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT login, password FROM centersAdmin WHERE ida =" + 1);
            String logined = resultSet.getString("login");
            String passwored = resultSet.getString("password");

            result = logined == login && passwored == password;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}