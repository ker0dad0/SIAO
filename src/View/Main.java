package View;

import Controller.DbConnexion;
import Controller.RoomController;
import Model.Bed;
import Model.Room;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(1, 78);
        Bed bed = new Bed(1, room);

        try{
            room.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}