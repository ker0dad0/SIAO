package View;

import Controller.DbConnexion;
import Controller.PersonInNeedController;
import Controller.RoomController;
import Model.Bed;
import Model.PersonInNeed;
import Model.Room;

import javax.xml.stream.events.DTD;
import java.sql.Connection;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        RoomController.getAllRooms();

        Date startDate = new Date(2022,11,10);
        Date endDate = new Date(2022,12,9);


        PersonInNeedController.registerPerson(0, 20, "Bili", "BOSH","masc", "15457889", startDate, endDate);
    }
    /**
     * j'ai pensé à un processus loger plus simple, e, fait quand on  va cliqué sur loger une personne ça nous renvoira sur la liste des lit disponible et on va juste cliquer sur l'un pour le rajouter là
     */

}