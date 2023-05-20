package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;
import java.sql.*;

/**
 * class qui permet de faire la connexion à la bd utilisale dans tout le projet
 */
public class DbConnexion {
    private final String url = "jdbc:mysql://localhost:3306/siao-db";
    private final String userName = "root";
    private final String password = "";
    private Connection connection;

    public void DbConnexion() {

    }

    /*
    methode de la classe qui permet de faire la connexion à la base de donné : utile pour creer et executer les fonction métiers
     */
    public Connection openConnexion() {
        try {
            connection = DriverManager.getConnection(this.url, this.userName, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connexion error");
        }

        return connection;
    }

}
