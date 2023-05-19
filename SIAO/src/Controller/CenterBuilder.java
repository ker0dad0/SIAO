package Controller;
import Model.*;
import java.util.ArrayList;
public class CenterBuilder {


    public Center CenterBuilder(){
            return new Center(Configuration.name, Configuration.adresse, Configuration.roomNumber);
    }
// on va créer un centre avec 30 chambre et chaque chambre contient 4 lits
    public void initialisation(Center center){
        for (int i = 0; i< center.getRoomNumber(); i++){
            Room room = new Room(i, 4);
            for (int j = 0; j< room.getNumberOfPlaces(); j++){
                Bed bed = new Bed(j, room);
                room.addBed(bed);
            }
            center.addRoom(room);
        }
    }

}
