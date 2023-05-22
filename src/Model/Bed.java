package Model;

import Controller.DbConnexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bed {
    private int idb;
    private Room room;
    private boolean state;  // false si le lit est vide, true si le lit est occupé

    public Bed(int idb, Room room) {
        this.idb = idb;
        this.room = room;
        state = false;  // car on vient de créer un nouveau lit donc il est libre
    }

    //getters et setters
    public int getIdb() {
        return idb;
    }

    public Room getRoom() {
        return room;
    }


    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getIdRoom() {    // cette méthode pour retourner juste l'id du chambre où il existe notre lit
        return room.getIdr();
    }



    /**
     * méthode pour retourner la lise des lits libres | on peut la définir danns le controller(CenterManger.java)
     */

    public static List<Bed> getAvailablePlaces(List<Bed> beds) {
        List<Bed> availableBeds = new ArrayList<>();
        for (Bed bed : beds) {
            if (!bed.getState()) {
                availableBeds.add(bed);
            }
        }
        return availableBeds;
    }

    /**
     * méthode de type string pour nous retourner le statut d'un lit | on va la déplacer vers(CenterManager.java)
     */

    public String showBed() {
        if (state) {
            return "Occupied";
        } else {
            return "Vacant";
        }
    }

    /**
     * sauvegarder cette objet dans dans la base de donnée
     */
    public void save() throws SQLException {

        /**
         * etablir la connexion avant d'exécuter la requete sql
         */
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try {
            statement.execute("INSERT INTO beds VALUES (" + this.state + "," + this.idb + "," + room.getIdr() + ");");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * supprimer  l'enregistrement correspondant à cette objet de la base donnée
     */

    public void delete() throws SQLException{

        /**
         * etalir la connexion à la bd avant la requete
         */

        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try{
            statement.execute("DELETE FROM beds WHERE  idb =" +  this.idb );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



