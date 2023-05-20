package Controller;

import Model.Bed;
import Model.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomController {
    /**
     *
     * creer une enregistrement de d'un lit dans la bd
     */
    public  static void addBedOnRoom(Bed bed, Room room) throws SQLException {
        bed.save(); // sauvegarde dans la bd
        room.addBed(bed); // sauvegarde dans l'objet
    }

    /**
     * liste des beds contenue dans une room
     * @param room
     * @return
     */
    public static ArrayList<Bed> getBedsOfRoom(Room room){

        ArrayList<Bed> beds = null; // tableau de bed pour recuperer tout les lits

        DbConnexion dbConnexion = new DbConnexion();
        Connection connection =  dbConnexion.openConnexion();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM beds WHERE idr =" +  room.getIdr());
            /**
             * parcourir la liste de bed obtenu et renvoyer chaque objet dans la liste de beds
             */
            while (resultSet.next()){
                Bed bed = new Bed(resultSet.getInt("idr"), room);
                bed.setState(resultSet.getBoolean("state"));
                beds.add(bed);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error requete excecution");
        }

        return  beds;
    }

    /**
     * nombre de bed disponible dans une room
     */
    public static int getNumberOfAvailablePlace(Room room) {
        int c = 0;
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM beds WHERE idr =" + room.getIdr() + "AND state=" + false);
            c = resultSet.getInt("idb");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    /**
     * definir l'affichage d'un room avec ses attributs
     */
    public static Room  showRoom(Room room){
        return  room;
    }
}
