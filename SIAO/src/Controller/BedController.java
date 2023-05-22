package Controller;

import Model.Bed;
import Model.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BedController {

    /**
     * renvois la disponibilité d'un lit
     * @return
     */
    public static boolean isAvailable(Bed bed){
        return bed.getState();
    }

    /**
     * afficher les details d'un lit
     */
    public static Bed showBed(Bed bed){
        return bed;
    }

    /**
     * renois la liste des lit de la salle
     * @param idr
     * @return
     */
    public static ArrayList<Bed> getAllBeds(int idr){
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        ArrayList<Bed> beds = new ArrayList<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM beds WHERE idr =" +  idr + ";");

            // vu que dans le contructeur de bed tu as mis un attribut rooms je suis obligé de creer un onjet room pour creer un objet bed

            Room room = new Room(idr, 0, 0); // ne pas utilser les attributs de cet objet puisqu'il est fictif il me sert juste à creer l'objet bed

            while (resultSet.next()) {

                Bed bed = new Bed(resultSet.getInt("idb"),
                        room
                );
                bed.setState(resultSet.getBoolean("state"));
                 beds.add(bed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beds;
    }
}
