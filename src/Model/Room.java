package Model;

import Controller.DbConnexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int idr;
    private int numberOfPlaces;
    private ArrayList<Bed> listBed;
    private int number;
    private String restriction;
    private boolean state;               // false si la chambre est vide, true si la chambre est occupée
    private int occupiedBeds;            // variable présente le nombre de lits occupés dans notre centre

    /**
     * on a pas besoin de occupiedBeds puisqu'on peut l'avoir avecbune requet sql
     * il faut rajouter l'attribut restriction
     * la fonction get available place est à definr dans le controller
     * il faut rajouter un libelle pour le room, c'est prévu dans le cahier de charge
     * il faut définir la méthode toString
     * on a pas besoin de l'attribut number of place puisqu'on peut l'avoir avec une requete sql
     * comment on va garder dans la bd l'arrayList listBed
     * il faut definir la methode toString dans toute tes classes
     * @param idr
     * @param numberOfPlaces
     */
    public Room(int idr, int numberOfPlaces) {
        this.idr = idr;
        this.numberOfPlaces = numberOfPlaces;
        state = false;                  // false car on vient de créer une nouvelle chambre et y a encore des places libres
        listBed = new ArrayList<>();// on initialise la liste des beds (list vide) et on va la remplire
        this.listBed = listBed;                                // en fonction du nombre de lits de la chambre
    }

    // getters et setters
    public int getIdr() {
        return idr;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public boolean getState() {
        return state;    // false si y a encore des places et True s'y a plus de place libre
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    // méthode pour rajouter un lit dans notre chambre chambre
    public void addBed(Bed bed){
        listBed.add(bed);
    }

    // méthode pour retourner le nombre de lits dans notre chambre
    public int getNumberBeds() {
        return listBed.size();
    }

    // méthode pour retourner la liste des lits
    public List<Bed> getBeds() {
        return listBed;
    }
    // méthode qui nous retourne la liste des chambres où il y a encore des places libres(lits) | on peut la déplacer vers CenterManager.java
    public static List<Room> getAvailableRooms(List<Room> rooms) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.getState()) {   // on prend que les chambres qui retourne false ie y a encore au moins une place libre
                availableRooms.add(room);  // là on rajoute toutes les chambres où il y a encore des places disponibles
            }
        }
        return availableRooms;
    }
    //***********************************  aussi à déf dans le controller(CenterManager.java)
    public String showRoom() {
        if (state) {  //faut qu'on rajoute aussi du détail
            return "Occupied";  // si state = True donc ya plus de place
        } else {
            return "Vacant";  // sinon on a encore des places
        }
    }

    /**
     * permet de sauvegarder les un objet en base de donnee
     *
     * @throws SQLException
     */
    public void save() throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try {
            statement.execute("INSERT INTO rooms VALUES (" + this.idr + "," + this.number + "," + this.restriction + "," + this.number + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() throws SQLException{
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();
        Statement statement = connection.createStatement();

        try{
            statement.execute("DELETE FROM rooms WHERE  idr =" +  this.idr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

// on peut aussi rajouter la méthode qui va nous retourner le nombre de place libre(à discuter on peut la mettre dans controller)


