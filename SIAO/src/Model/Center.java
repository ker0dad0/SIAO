package Model;
import Model.Room;
import java.util.ArrayList;

public class Center {
    private String name;
    private String adresse;
    private int roomNumber;
    private ArrayList<Room> listRoom;

    public Center(String name, String adresse, int roomNumber){
        this.name = name;
        this.adresse = adresse;
        this.roomNumber = roomNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse ;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberRooms(){
        return listRoom.size();
    }

    public ArrayList getRooms(){
        return listRoom;
    }

    public Room getRoomById(int idr){
        return listRoom.get(listRoom.indexOf(ro));

    }

}
