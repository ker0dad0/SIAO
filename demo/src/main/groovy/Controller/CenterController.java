package Controller;

import Model.Center;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CenterController {
    /**
     * cette fonction permet recuperer les info du centre
     * @return
     */
    public static Center getCenter() throws SQLException {

        Center center = null;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM centers WHERE idc = 1");

        center.setName(resultSet.getString("name"));
        center.setAdresse(resultSet.getString("Adresse"));
        center.setRoomNumber(resultSet.getInt("roomsNumber"));

        return center;
    }
}
