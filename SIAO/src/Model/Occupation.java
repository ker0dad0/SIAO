package Model;
import Controller.DbConnexion;
import Model.Bed;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Occupation {
    private int ido;
    private PersonInNeed person;
    private Bed bed;
    //private Room room;  car on déjà défini les classe Bed avec Room.


    // méthode constructeur: pour affecter un person dans un lit si y a des places (on va voir ça dans la partie Controller)
    public Occupation(PersonInNeed person, Bed bed /* Room room,*/ , int ido) {
        this.ido = ido;
        this.person = person;
        this.bed = bed;
       // this.room = room;

    }

    // getters et setters
    public PersonInNeed getPerson() {
        return person;
    }

    public void setPerson(PersonInNeed person) {
        this.person = person;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Room getRoom() {
        return bed.getRoom();
    }

   /* public void setRoom(Room room) {
        this.bed.getRoom() = room;
    } */



    // méthode pour calculer la durée d'occupation d'un lit
    public int occupationTime() {
        long startTime = person.getStartDate().getTime();
        long endTime = person.getEndDate().getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (24 * 60 * 60 * 1000);   //1000 présente le nombre milliseconde d'une seconde
        return (int) diffDays;
    }


    // méthode qui va changer le statut du lit et des informations du chambre après la nouvelle affectation
    public void affectationBed() {
        if (!bed.getState()) {
            bed.setState(true);  // pour changer le statut du lit après affectation
            bed.getRoom().setOccupiedBeds(bed.getRoom().getOccupiedBeds() + 1); // pour changer le nombre de lits occupé dans la chambre
            System.out.println("Person " + person.getFirstName() + " " + person.getLastName() + " assigned to Bed " + bed.getIdb() + " in Room " + bed.getRoom().getIdr());
        } else {
            // peur etre on va modifier ça
            System.out.println("Bed " + bed.getIdb() + " is already occupied.");
        }
    }

    // méthode pour détruire une occupation après endDate
    public void deleteOccupation() {
        bed.setState(false);
        bed.getRoom().setOccupiedBeds(bed.getRoom().getOccupiedBeds() - 1);
        System.out.println("Occupation deleted successfully. Bed " + bed.getIdb() + " in Room " + bed.getRoom().getIdr() + " is now vacant.");
    }

    public void save() throws SQLException {
        DbConnexion dbConnexion = new DbConnexion();
        Connection connection = dbConnexion.openConnexion();

        Statement statement = connection.createStatement();
        try {
            statement.execute("INSERT INTO rooms VALUES (" + this.ido + "," + this.getBed().getIdb() +  "," + this.getRoom().getIdr() + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  delete() throws SQLException {
            DbConnexion dbConnexion = new DbConnexion();
            Connection connection = dbConnexion.openConnexion();
            Statement statement = connection.createStatement();

            try{
                statement.execute("DELETE FROM occupation WHERE  ido =" +  this.ido);
            }catch (Exception e){
                e.printStackTrace();
            }
    }

}

